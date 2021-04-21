
-- count of male and female employees
select gender, count(id) from employee e group by gender;

-- sort table based on age highest to lowest
select * from employee e order by age desc;

-- task 1 count employees per city
select city, count(id) from employee
group by city;

-- task 2 count employees per city and sort them from lowest count to highest count
select city, count(id) from employee
group by city
order by count(id);

-- task 3 count employees per age category and arrange them from highest count to lowest count
select age, count(id) from employee
group by age
order by count(id) desc;

-- display employees for a particular age
select * from employee where age=25;

-- display employees for a particular age and particular city
select * from employee where age=25 and city='Hyderabad';

-- display employees for a particular age or particular city
select * from employee where age=25 or city='Hyderabad';

-- display employees between age range
select * from employees where age between 22 and 23;

-- like operator - pattern
select * from employee where name like 's%';

-- subquery - query within a query is called a subquery
select * from employee where age in
(select max(age) from employee);

-- having clause (display cities where employee count > 2)
-- having is a filter you can apply on group by results
select city, count(id) from employee e group by city
having count(id)>2;

-- task 4 - display count of male and female employees in every city
select city, gender, count(*) from employee
group by city, gender

-- task 5 - display count of male and female employees in every city where the female count is >2
select city, gender, count(*) from employee
group by city, gender
having count(*) > 2


select e.name, d.name from employee e 
inner join
department d 
on e.deptid = d.deptid;

select e.name,coalesce(d.name,'NO department assigned') from employee e 
left join
department d
on e.deptid = d.deptid ;

select e.name, d.name from employee e 
right join
department d 
on e.deptid = d.deptid;

select e.name, d.name from employee e 
full join
department d 
on e.deptid = d.deptid;

-- task 6: find department name(s) where highest number of employees working
select d.name, count(e.id) from employee e 
join department d on e.deptid = d.deptid 
group by d.name
order by count(e.id) desc;
-- task 7: find department name(s) where lowest number of employees working
-- task 8: print department name where highest number of employees are working
-- task 9: print the city names where more than 2 employees are working from same department
-- task 10: explore and try few examples on set operators: union, unionall, intersect, minus
-- task 11: sign up hackerrank and practice SQL queries there (only select), try sqlzoo.net 

