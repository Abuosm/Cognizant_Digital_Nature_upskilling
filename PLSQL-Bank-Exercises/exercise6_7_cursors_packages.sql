SET SERVEROUTPUT ON;

---------------------------------------------------
-- EXERCISE 6 : CURSORS
---------------------------------------------------

---------------------------------------------------
-- Scenario 1
-- GenerateMonthlyStatements
---------------------------------------------------

DECLARE

CURSOR GenerateMonthlyStatements IS

SELECT
c.Name,
t.TransactionID,
t.Amount,
t.TransactionDate

FROM Customers c

JOIN Accounts a
ON c.CustomerID=a.CustomerID

JOIN Transactions t
ON a.AccountID=t.AccountID

WHERE

EXTRACT(
MONTH
FROM t.TransactionDate
)

=

EXTRACT(
MONTH
FROM SYSDATE
);

BEGIN

FOR rec IN GenerateMonthlyStatements LOOP

DBMS_OUTPUT.PUT_LINE(

'Customer: '
|| rec.Name
|| ' Transaction: '
|| rec.TransactionID
|| ' Amount: '
|| rec.Amount

);

END LOOP;

END;
/

---------------------------------------------------
-- Scenario 2
-- ApplyAnnualFee
---------------------------------------------------

DECLARE

CURSOR ApplyAnnualFee IS

SELECT
AccountID,
Balance

FROM Accounts;

v_fee NUMBER:=100;

BEGIN

FOR rec IN ApplyAnnualFee LOOP

UPDATE Accounts

SET Balance=
Balance-v_fee

WHERE AccountID=
rec.AccountID;

END LOOP;

COMMIT;

END;
/

---------------------------------------------------
-- Scenario 3
-- UpdateLoanInterestRates
---------------------------------------------------

DECLARE

CURSOR UpdateLoanInterestRates IS

SELECT
LoanID,
InterestRate

FROM Loans;

BEGIN

FOR rec IN UpdateLoanInterestRates LOOP

UPDATE Loans

SET InterestRate=
InterestRate+0.5

WHERE LoanID=
rec.LoanID;

END LOOP;

COMMIT;

END;
/

---------------------------------------------------
-- EXERCISE 7 : PACKAGES
---------------------------------------------------

---------------------------------------------------
-- Scenario 1
-- CustomerManagement
---------------------------------------------------

CREATE OR REPLACE PACKAGE
CustomerManagement

AS

PROCEDURE AddCustomer(

id NUMBER,
nm VARCHAR2,
bal NUMBER

);

PROCEDURE UpdateCustomer(

id NUMBER,
bal NUMBER

);

FUNCTION GetBalance(

id NUMBER

)

RETURN NUMBER;

END;
/

CREATE OR REPLACE PACKAGE BODY
CustomerManagement

AS

PROCEDURE AddCustomer(

id NUMBER,
nm VARCHAR2,
bal NUMBER

)

IS

BEGIN

INSERT INTO Customers

VALUES(

id,
nm,
SYSDATE,
bal,
SYSDATE,
NULL

);

END;

PROCEDURE UpdateCustomer(

id NUMBER,
bal NUMBER

)

IS

BEGIN

UPDATE Customers

SET Balance=
bal

WHERE CustomerID=
id;

END;

FUNCTION GetBalance(

id NUMBER

)

RETURN NUMBER

IS

v NUMBER;

BEGIN

SELECT Balance

INTO v

FROM Customers

WHERE CustomerID=
id;

RETURN v;

END;

END;
/

---------------------------------------------------
-- Scenario 2
-- EmployeeManagement
---------------------------------------------------

CREATE OR REPLACE PACKAGE
EmployeeManagement

AS

PROCEDURE HireEmployee(

id NUMBER,
nm VARCHAR2,
sal NUMBER

);

FUNCTION AnnualSalary(

id NUMBER)

RETURN NUMBER;

END;
/

CREATE OR REPLACE PACKAGE BODY
EmployeeManagement

AS

PROCEDURE HireEmployee(

id NUMBER,
nm VARCHAR2,
sal NUMBER

)

IS

BEGIN

INSERT INTO Employees

VALUES(

id,
nm,
'Staff',
sal,
'General',
SYSDATE

);

END;

FUNCTION AnnualSalary(

id NUMBER

)

RETURN NUMBER

IS

v NUMBER;

BEGIN

SELECT Salary*12

INTO v

FROM Employees

WHERE EmployeeID=id;

RETURN v;

END;

END;
/

---------------------------------------------------
-- Scenario 3
-- AccountOperations
---------------------------------------------------

CREATE OR REPLACE PACKAGE
AccountOperations

AS

PROCEDURE OpenAccount(

aid NUMBER,
cid NUMBER,
bal NUMBER

);

PROCEDURE CloseAccount(

aid NUMBER

);

FUNCTION TotalBalance(

cid NUMBER

)

RETURN NUMBER;

END;
/

CREATE OR REPLACE PACKAGE BODY
AccountOperations

AS

PROCEDURE OpenAccount(

aid NUMBER,
cid NUMBER,
bal NUMBER

)

IS

BEGIN

INSERT INTO Accounts

VALUES(

aid,
cid,
'Savings',
bal,
SYSDATE

);

END;

PROCEDURE CloseAccount(

aid NUMBER

)

IS

BEGIN

DELETE FROM Accounts
WHERE AccountID=
aid;

END;

FUNCTION TotalBalance(

cid NUMBER

)

RETURN NUMBER

IS

v NUMBER;

BEGIN

SELECT SUM(Balance)

INTO v

FROM Accounts

WHERE CustomerID=
cid;

RETURN v;

END;

END;
/