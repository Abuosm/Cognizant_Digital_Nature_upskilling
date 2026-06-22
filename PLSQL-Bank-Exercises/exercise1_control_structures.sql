SET SERVEROUTPUT ON;

---------------------------------------------------
-- Scenario 1
-- Discount 1% loan interest for customers >60
---------------------------------------------------

BEGIN

FOR c IN (
SELECT CustomerID,
TRUNC(MONTHS_BETWEEN(SYSDATE,DOB)/12) AGE
FROM Customers
)

LOOP

IF c.AGE > 60 THEN

UPDATE Loans
SET InterestRate=
InterestRate-1
WHERE CustomerID=
c.CustomerID;

DBMS_OUTPUT.PUT_LINE(
'Discount applied to customer '
|| c.CustomerID
);

END IF;

END LOOP;

COMMIT;

END;
/

---------------------------------------------------
-- Scenario 2
-- Set VIP flag
---------------------------------------------------

ALTER TABLE Customers
ADD IsVIP VARCHAR2(5);

BEGIN

FOR c IN (
SELECT CustomerID,
Balance
FROM Customers
)

LOOP

IF c.Balance > 10000 THEN

UPDATE Customers
SET IsVIP='TRUE'
WHERE CustomerID=
c.CustomerID;

END IF;

END LOOP;

COMMIT;

END;
/

---------------------------------------------------
-- Scenario 3
-- Loan reminders
---------------------------------------------------

BEGIN

FOR l IN (

SELECT
c.Name,
LoanID,
EndDate

FROM Customers c
JOIN Loans l

ON c.CustomerID=
l.CustomerID

WHERE EndDate
BETWEEN SYSDATE
AND SYSDATE+30

)

LOOP

DBMS_OUTPUT.PUT_LINE(
'Reminder: '
|| l.Name
|| ' Loan '
|| l.LoanID
|| ' due on '
|| l.EndDate
);

END LOOP;

END;
/