SET SERVEROUTPUT ON;

---------------------------------------------------
-- EXERCISE 4 : FUNCTIONS
---------------------------------------------------

---------------------------------------------------
-- Scenario 1
-- CalculateAge
---------------------------------------------------

CREATE OR REPLACE FUNCTION CalculateAge(

p_dob DATE

)

RETURN NUMBER

AS

v_age NUMBER;

BEGIN

v_age :=
TRUNC(
MONTHS_BETWEEN(
SYSDATE,
p_dob
)/12
);

RETURN v_age;

END;
/

---------------------------------------------------
-- Scenario 2
-- Monthly Installment (EMI)
---------------------------------------------------

CREATE OR REPLACE FUNCTION
CalculateMonthlyInstallment(

p_amount NUMBER,
p_interest NUMBER,
p_years NUMBER

)

RETURN NUMBER

AS

r NUMBER;
n NUMBER;
emi NUMBER;

BEGIN

r:=p_interest/12/100;

n:=p_years*12;

emi:=

p_amount*

(

r*
POWER(
1+r,
n

)

/

(

POWER(
1+r,
n
)-1

)

);

RETURN ROUND(
emi,
2
);

END;
/

---------------------------------------------------
-- Scenario 3
-- HasSufficientBalance
---------------------------------------------------

CREATE OR REPLACE FUNCTION
HasSufficientBalance(

p_account NUMBER,
p_amount NUMBER

)

RETURN VARCHAR2

AS

v_balance NUMBER;

BEGIN

SELECT Balance

INTO v_balance

FROM Accounts

WHERE AccountID=
p_account;

IF v_balance>=p_amount THEN

RETURN 'TRUE';

ELSE

RETURN 'FALSE';

END IF;

END;
/

---------------------------------------------------
-- TEST FUNCTIONS
---------------------------------------------------

SELECT
CalculateAge(
TO_DATE(
'1995-08-15',
'YYYY-MM-DD'
)
)
FROM dual;

SELECT
CalculateMonthlyInstallment(
500000,
8,
5
)
FROM dual;

SELECT
HasSufficientBalance(
1,
100
)
FROM dual;

---------------------------------------------------
-- EXERCISE 5 : TRIGGERS
---------------------------------------------------

---------------------------------------------------
-- Scenario 1
-- Update LastModified
---------------------------------------------------

CREATE OR REPLACE TRIGGER
UpdateCustomerLastModified

BEFORE UPDATE

ON Customers

FOR EACH ROW

BEGIN

:NEW.LastModified
:=SYSDATE;

END;
/

---------------------------------------------------
-- Scenario 2
-- Audit Log
---------------------------------------------------

CREATE TABLE AuditLog(

LogID NUMBER
GENERATED ALWAYS AS IDENTITY,

TransactionID NUMBER,

LogDate DATE,

Description
VARCHAR2(300)

);

CREATE OR REPLACE TRIGGER
LogTransaction

AFTER INSERT

ON Transactions

FOR EACH ROW

BEGIN

INSERT INTO AuditLog(

TransactionID,
LogDate,
Description

)

VALUES(

:NEW.TransactionID,
SYSDATE,
'Transaction Added'

);

END;
/

---------------------------------------------------
-- Scenario 3
-- Transaction Rules
---------------------------------------------------

CREATE OR REPLACE TRIGGER
CheckTransactionRules

BEFORE INSERT

ON Transactions

FOR EACH ROW

DECLARE

v_balance NUMBER;

BEGIN

SELECT Balance

INTO v_balance

FROM Accounts

WHERE AccountID=
:NEW.AccountID;

IF

:NEW.TransactionType=
'Withdrawal'

AND

:NEW.Amount>
v_balance

THEN

RAISE_APPLICATION_ERROR(
-20004,
'Insufficient Balance'
);

END IF;

IF

:NEW.TransactionType=
'Deposit'

AND

:NEW.Amount<=0

THEN

RAISE_APPLICATION_ERROR(
-20005,
'Invalid Deposit'
);

END IF;

END;
/