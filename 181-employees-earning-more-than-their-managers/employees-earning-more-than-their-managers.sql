# Write your MySQL query statement below
SELECT name as EMPLOYEE
FROM EMPLOYEE e1
WHERE e1.SALARY >(
    SELECT SALARY FROM EMPLOYEE e2 WHERE e2.id=e1.managerId
)