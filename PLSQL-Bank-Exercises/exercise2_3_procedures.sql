SET SERVEROUTPUT ON;

---------------------------------------------------
-- EXERCISE 2 : ERROR HANDLING
---------------------------------------------------

---------------------------------------------------
-- Scenario 1
-- SafeTransferFunds
---------------------------------------------------

CREATE OR REPLACE PROCEDURE SafeTransferFunds(

p_from NUMBER,
p_to NUMBER,
p_amount NUMBER

)

AS

v_balance NUMBER;

BEGIN

SELECT Balance
INTO v_balance
FROM Accounts
WHERE AccountID=p_from;

IF v_balance < p_amount THEN
RAISE_APPLICATION_ERROR(
-20001,
'Insufficient Balance'
);
END IF;

UPDATE Accounts
SET Balance=
Balance-p_amount
WHERE AccountID=p_from;

UPDATE Accounts
SET Balance=
Balance+p_amount
WHERE AccountID=p_to;

COMMIT;

DBMS_OUTPUT.PUT_LINE(
'Transfer Success'
);

EXCEPTION

WHEN OTHERS THEN

ROLLBACK;

DBMS_OUTPUT.PUT_LINE(
'Transfer Failed : '
|| SQLERRM
);

END;
/

---------------------------------------------------
-- Scenario 2
-- UpdateSalary
---------------------------------------------------

CREATE OR REPLACE PROCEDURE UpdateSalary(

p_employee NUMBER,
p_percent NUMBER

)

AS

v_exists NUMBER;

BEGIN

SELECT COUNT(*)
INTO v_exists
FROM Employees
WHERE EmployeeID=
p_employee;

IF v_exists=0 THEN
RAISE_APPLICATION_ERROR(
-20002,
'Employee Not Found'
);
END IF;

UPDATE Employees

SET Salary=
Salary+
(Salary*p_percent/100)

WHERE EmployeeID=
p_employee;

COMMIT;

DBMS_OUTPUT.PUT_LINE(
'Salary Updated'
);

EXCEPTION

WHEN OTHERS THEN

DBMS_OUTPUT.PUT_LINE(
SQLERRM
);

END;
/

---------------------------------------------------
-- Scenario 3
-- AddNewCustomer
---------------------------------------------------

CREATE OR REPLACE PROCEDURE AddNewCustomer(

p_id NUMBER,
p_name VARCHAR2,
p_dob DATE,
p_balance NUMBER

)

AS

BEGIN

INSERT INTO Customers
VALUES(

p_id,
p_name,
p_dob,
p_balance,
SYSDATE,
NULL

);

COMMIT;

EXCEPTION

WHEN DUP_VAL_ON_INDEX THEN

DBMS_OUTPUT.PUT_LINE(
'Customer Already Exists'
);

ROLLBACK;

END;
/

---------------------------------------------------
-- EXERCISE 3 : STORED PROCEDURES
---------------------------------------------------

---------------------------------------------------
-- Scenario 1
-- Monthly Interest
---------------------------------------------------

CREATE OR REPLACE PROCEDURE
ProcessMonthlyInterest

AS

BEGIN

UPDATE Accounts

SET Balance=
Balance+
(Balance*0.01)

WHERE AccountType=
'Savings';

COMMIT;

END;
/

---------------------------------------------------
-- Scenario 2
-- Employee Bonus
---------------------------------------------------

CREATE OR REPLACE PROCEDURE
UpdateEmployeeBonus(

p_department VARCHAR2,
p_bonus NUMBER

)

AS

BEGIN

UPDATE Employees

SET Salary=
Salary+
(Salary*p_bonus/100)

WHERE Department=
p_department;

COMMIT;

END;
/

---------------------------------------------------
-- Scenario 3
-- TransferFunds
---------------------------------------------------

CREATE OR REPLACE PROCEDURE
TransferFunds(

p_from NUMBER,
p_to NUMBER,
p_amount NUMBER

)

AS

v_balance NUMBER;

BEGIN

SELECT Balance
INTO v_balance
FROM Accounts
WHERE AccountID=
p_from;

IF v_balance < p_amount THEN

RAISE_APPLICATION_ERROR(
-20003,
'Insufficient Funds'
);

END IF;

UPDATE Accounts
SET Balance=
Balance-p_amount
WHERE AccountID=
p_from;

UPDATE Accounts
SET Balance=
Balance+p_amount
WHERE AccountID=
p_to;

COMMIT;

END;
/