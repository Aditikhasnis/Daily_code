# Write your MySQL query statement below
select s.user_id as user_id,
COALESCE(ROUND(SUM(CASE WHEN c.action='confirmed' then 1 ELSE 0 END)/COUNT(c.user_id),2),0) as confirmation_rate
from Signups s 
left join Confirmations c
on s.user_id =c.user_id
GROUP BY s.user_id
ORDER BY confirmation_rate

