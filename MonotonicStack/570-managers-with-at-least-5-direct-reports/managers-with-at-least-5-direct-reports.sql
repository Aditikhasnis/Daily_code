# Write your MySQL query statement below

select name from  Employee
where ID in (
    select managerId from Employee
    Group By managerId
    Having Count(managerId)>=5
)
