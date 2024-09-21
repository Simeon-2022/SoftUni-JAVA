CREATE DATABASE IF NOT EXISTS `hotel`; 
USE `hotel`;

CREATE TABLE departments (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50)
);

INSERT INTO departments(name) VALUES('Front Office'), ('Support'), ('Kitchen'), ('Other');

CREATE TABLE employees (
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	job_title VARCHAR(50) NOT NULL,
	department_id INT NOT NULL,
	salary DOUBLE NOT NULL,
	CONSTRAINT `fk_department_id` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
);

INSERT INTO `employees` (`first_name`,`last_name`, `job_title`,`department_id`,`salary`) VALUES
	('John', 'Smith', 'Manager',1, 900.00),
	('John', 'Johnson', 'Customer Service',2, 880.00),
	('Smith', 'Johnson', 'Porter', 4, 1100.00),
	('Peter', 'Petrov', 'Front Desk Clerk', 1, 1100.00),
	('Peter', 'Ivanov', 'Sales', 2, 1500.23),
	('Ivan' ,'Petrov', 'Waiter', 3, 990.00),
	('Jack', 'Jackson', 'Executive Chef', 3, 1800.00),
	('Pedro', 'Petrov', 'Front Desk Supervisor', 1, 2100.00),
	('Nikolay', 'Ivanov', 'Housekeeping', 4, 1600.00);
	

	
CREATE TABLE rooms (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`type` VARCHAR(30)
);

INSERT INTO rooms(`type`) VALUES('apartment'), ('single room');

CREATE TABLE clients (
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	room_id INT NOT NULL,

    CONSTRAINT fk_clients_rooms FOREIGN KEY (room_id) REFERENCES rooms(id)
);

INSERT INTO clients(`first_name`,`last_name`,`room_id`) VALUES
('Pesho','Petrov', 1),
('Gosho','Georgiev', 2),
('Mariya','Marieva', 2),
('Katya','Katerinova', 1),
('Nikolay','Nikolaev', 2);

SELECT concat(first_name, ' ',last_name) AS `Full name`, job_title AS `Job title`, id AS `No.`
FROM employees; 

SELECT concat_ws(' ',first_name,last_name) AS `Full name`, job_title AS `Job title`, id AS `No.`
FROM employees;

update employees set last_name = null where id = 1;

select distinct department_id as `distinct departments` from employees;
select department_id from employees;
select last_name, salary from employees where salary <= 2000 order by salary;

create view `View_1` as select concat_ws(' ', first_name, last_name) as `Full name`, salary AS Salary 
from employees where salary > 100 order by salary desc;
drop view View_1;
select `Full name` from View_1; 

create view `v_top_paid_employee` as select * from employees order by salary desc limit 1;
drop view `v_top_paid_employee`;
select * from v_top_paid_employee;

use hotel;
-- 01. Select Employee Information
select id, first_name, last_name, job_title from employees order by id;

-- 02. Select Employees with Filter
select id, concat(first_name, ' ', last_name) as full_name, job_title, salary from employees where salary > 1000.00 order by id;

-- 03. Update Salary and Select
SET SQL_SAFE_UPDATES = 0;
update employees set salary = salary + 100 where job_title = 'Manager';
select salary from employees order by salary;

-- 04. Top Paid Employee
create view `v_top_paid_employee` as select * from employees order by salary desc limit 1;
select * from v_top_paid_employee;

-- 05. Select Employees by Multiple Filters
select * from employees where department_id = 4 and salary >= 1000 order by id;

-- 06. Delete from Table
delete from employees where department_id in (1, 2);
select * from employees;