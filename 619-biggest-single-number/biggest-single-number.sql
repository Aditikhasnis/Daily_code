# Write your MySQL query statement below
SELECT MAX(n) as num  FROM (SELECT NUM as n FROM MYNUMBERS 
GROUP BY NUM
HAVING COUNT(*)=1) AS SUBQUERY 