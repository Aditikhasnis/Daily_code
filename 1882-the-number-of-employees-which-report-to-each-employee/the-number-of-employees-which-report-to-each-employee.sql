# Write your MySQL query statement below

select DISTINCT e1.employee_id, e1.name , count(e2.name) as reports_count, round(avg(e2.age)) as average_age
 from employees e1  join employees e2 on 
e1.employee_id=e2.reports_to
group by e2.reports_to 
order by e1.employee_id

-- (select count(name) as cnt ,reports_to as rip,round(avg(age)) as av from employees 
-- group by reports_to 
-- having reports_to is  not null) as subquery
-- where employee_id=reports_to