-- 00. Create Database
CREATE SCHEMA `minions` DEFAULT CHARACTER SET utf8;

-- 01. Create Tables
CREATE TABLE minions.`minions`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50),
`age` INT);

-- 02. Alter Minions Table
CREATE TABLE minions.`towns`(
`town_id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50)
);

ALTER TABLE towns RENAME COLUMN town_id TO id;

ALTER TABLE minions ADD COLUMN town_id INT;

ALTER TABLE minions 
ADD CONSTRAINT fk_foreign_key 
FOREIGN KEY (town_id) REFERENCES towns(id);

-- 03. Insert Records in Both Tables
INSERT INTO towns(id, name) VALUES 
(1,"Sofia"),
(2,"Plovdiv"),
(3,"Varna");

INSERT INTO minions(id, name, age, town_id) VALUES 
(1, "Kevin", 22, 1),
(2, "Bob", 15, 3),
(3,"Steward", NULL, 2);
 
-- 04. Truncate Table Minions
TRUNCATE minions;

-- 05. Drop All Tables
DROP TABLE minions;
DROP TABLE towns;

-- 06. Create Table People

CREATE TABLE minions.people (
`id` int auto_increment unique primary key not null, 
`name` varchar(200) not null,
`picture` text,
`height` decimal(3,2),
`weight` decimal(5,2),
`gender` char(1) not null,
`birthdate` date not null,
`biography` text
);

INSERT INTO minions.people (name, picture, height, weight, gender, birthdate, biography) VALUES
("Gosho", "Test_0", 2.88,109.22,'m','2000-07-22',"ksdjlasdlkasdlkasjdlasjdlkaslwiowimsmm,a,,a,wjwddjkljkalsjdlakjdlajds"),
("Pesho", "Test_1", 2.00,209.22,'m','2001-02-22',"ksdjlasdlkasdlkasjdlasjdlkaslwiowimsmm,a,,a,wjwddjkljkalsjdlakjdlajds"),
("Simo", "Test_2", 1.88,89.22,'m','1985-07-24',"ksdjlasdlkasdlkasjdlasjdlkaslwiowimsmm,a,,a,wjwddjkljkalsjdlakjdlajds"),
("Tanya", "Test_3", 1.68,59.22,'f','2000-12-22',"ksdjlasdlkasdlkasjdlasjdlkaslwiowimsmm,a,,a,wjwddjkljkalsjdlakjdlajds"),
("Misho", "Test_4", 2.88,209.22,'m','1945-07-22',"ksdjlasdlkasdlkasjdlasjdlkaslwiowimsmm,a,,a,wjwddjkljkalsjdlakjdlajds");

-- 07. Create Table Users
CREATE TABLE users (
`id` INT UNIQUE PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) UNIQUE NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` TEXT,
`last_login_time` DATETIME,
`is_deleted` BOOLEAN
);

INSERT INTO users(`username`, `password`, `profile_picture`, `last_login_time`, `is_deleted`) VALUES
("Simo1", "pasSSsd239@ksaj", "Profile_Picture", "2000-07-22 10:10:55",FALSE),
("Simo2", "pasSSsd239@ksaj", "Profile_Picture", "2000-07-22 10:10:55",FALSE),
("Simo3", "pasSSsd239@ksaj", "Profile_Picture", "2000-07-22 10:10:55",FALSE),
("Simo4", "pasSSsd239@ksaj", "Profile_Picture", "2000-07-22 10:10:55",FALSE),
("Simo5", "pasSSsd239@ksaj", "Profile_Picture", "2000-07-22 10:10:55",FALSE);

-- 08. Change Primary Key
ALTER TABLE users 
DROP PRIMARY KEY, 
ADD CONSTRAINT pk_users PRIMARY KEY (id, username);

-- 09. Set Default Value of a Field 
ALTER TABLE users
MODIFY COLUMN last_login_time DATETIME DEFAULT NOW();

-- 10. Set Unique Field
ALTER TABLE users
DROP PRIMARY KEY,
ADD PRIMARY KEY (id);

ALTER TABLE users
modify username VARCHAR(30) NOT NULL unique;

-- 11. Movies Database

CREATE SCHEMA movies DEFAULT CHARSET utf8;
USE movies;
CREATE TABLE directors (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT UNIQUE,
director_name VARCHAR(100) NOT NULL,
notes TEXT
);

CREATE TABLE genres (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT UNIQUE,
genre_name VARCHAR(100) NOT NULL,
notes TEXT
);

CREATE TABLE categories (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT UNIQUE,
category_name VARCHAR(100) NOT NULL,
notes TEXT
);

CREATE TABLE movies (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT UNIQUE,
title VARCHAR(100) NOT NULL,
director_id INT NOT NULL,
copyright_year YEAR,
length TIME, 
genre_id INT NOT NULL, 
category_id INT NOT NULL,
rating DOUBLE(5,2),
notes TEXT
);

INSERT INTO directors (director_name, notes) VALUES 
("Steven A","Some notes..."), 
("Steven B","Some notes..."),
("Steven C","Some notes..."),
("Steven D","Some notes..."),
("Steven E","Some notes...");

INSERT INTO genres (genre_name, notes) VALUES
("Action", "Some notes..."),
("Mystery", "Some notes..."),
("Sci-Fi", "Some notes..."),
("Comedy", "Some notes..."),
("Drama", "Some notes..."); 

INSERT INTO categories (category_name, notes) VALUES
("Adults", "Some notes..."),
("Children", "Some notes..."),
("Adolescents", "Some notes..."),
("Women", "Some notes..."),
("Teens", "Some notes...");

INSERT INTO movies (title, director_id, copyright_year, length, genre_id, category_id, rating, notes) VALUES
("The Red Sonia", 1, 1995, "01:20:00", 2, 1, 5.3, "Some notes..."),
("The Terminator I", 2, 1995, "01:20:00", 1, 2, 5.3, "Some notes..."),
("The Terminator II", 4, 1995, "01:20:00", 3, 3, 5.3, "Some notes..."),
("The Terminator III", 5, 1995, "01:20:00", 5, 4, 5.3, "Some notes..."),
("The Terminator IV", 3, 1995, "01:20:00", 4, 5, 5.3, "Some notes...");

-- 12. Car Rental Database
DROP SCHEMA car_rental;
CREATE SCHEMA car_rental DEFAULT CHARSET utf8;
USE car_rental;

CREATE TABLE categories(
id INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
category VARCHAR(100),
daily_rate DOUBLE(10,2) NOT NULL,
weekly_rate DOUBLE(10,2) NOT NULL,
monthly_rate DOUBLE(10,2) NOT NULL,
weekend_rate DOUBLE(10,2) NOT NULL
);

CREATE TABLE cars(
id INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT, 
plate_number VARCHAR(30) NOT NULL UNIQUE, 
make VARCHAR(50) NOT NULL, 
model VARCHAR(50) NOT NULL, 
car_year YEAR NOT NULL, 
category_id INT NOT NULL, 
doors INT NOT NULL, 
picture BLOB, 
car_condition VARCHAR(50), 
available BOOLEAN
);

CREATE TABLE employees(
id INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT, 
first_name VARCHAR(50) NOT NULL, 
last_name VARCHAR(50), 
title VARCHAR(50), 
notes TEXT
);

CREATE TABLE customers (
id INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT, 
driver_licence_number VARCHAR(50) NOT NULL UNIQUE, 
full_name VARCHAR(50) NOT NULL, 
address VARCHAR(150) NOT NULL, 
city VARCHAR(150) NOT NULL, 
zip_code INT NOT NULL, 
notes TEXT
);

CREATE TABLE rental_orders (
id INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT, 
employee_id INT NOT NULL, 
customer_id INT NOT NULL, 
car_id INT NOT NULL, 
car_condition TEXT, 
tank_level DOUBLE(5,2) NOT NULL, 
kilometrage_start INT NOT NULL,
kilometrage_end INT NOT NULL, 
total_kilometrage INT NOT NULL, 
start_date DATE, 
end_date DATE, 
total_days INT,
rate_applied DOUBLE(10,2), 
tax_rate DOUBLE(10,2), 
order_status VARCHAR(20), 
notes TEXT);

INSERT INTO categories (category, daily_rate, weekly_rate, monthly_rate, weekend_rate) VALUES
('category1', 50.40, 50.40, 50.40, 50.40),
('category1', 50.40, 50.40, 50.40, 50.40),
('category1', 50.40, 50.40, 50.40, 50.40);

INSERT INTO cars (plate_number, make, model, car_year, category_id, doors, picture, car_condition, available) VALUES
('plate_number1', 'make', 'model', 1955, 1, 3, 'picture', 'car_condition', true),
('plate_number2', 'make', 'model', 1955, 2, 3, 'picture', 'car_condition', true),
('plate_number3', 'make', 'model', 1955, 3, 3, 'picture', 'car_condition', true);

INSERT INTO employees (first_name, last_name, title, notes) VALUES
('first_name', 'last_name', 'title', 'notes'),
('first_name', 'last_name', 'title', 'notes'),
('first_name', 'last_name', 'title', 'notes');

INSERT INTO customers (driver_licence_number, full_name, address, city, zip_code, notes) VALUES
('driver_licence_number1', 'full_name', 'address', 'city', 1222, 'notes'),
('driver_licence_number2', 'full_name', 'address', 'city', 1222, 'notes'),
('driver_licence_number3', 'full_name', 'address', 'city', 1222, 'notes');

INSERT INTO rental_orders (employee_id, customer_id, car_id, car_condition, tank_level, 
kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date, total_days,
 rate_applied, tax_rate, order_status, notes) VALUES
 (1, 1, 1, 'car_condition', 50.05, 10000, 20000, kilometrage_end - kilometrage_start, '2024-01-01', '2024-01-23', DATEDIFF(end_date, start_date),
 13.2, 15.5, 'order_status', 'notes'),
 (2, 2, 2, 'car_condition', 50.05, 10000, 20000, kilometrage_end - kilometrage_start, '2024-01-01', '2024-01-23', DATEDIFF(end_date, start_date),
 13.2, 15.5, 'order_status', 'notes'),
 (3, 4, 4, 'car_condition', 50.05, 10000, 20000, kilometrage_end - kilometrage_start, '2024-01-01', '2024-01-23', DATEDIFF(end_date, start_date),
 13.2, 15.5, 'order_status', 'notes');
 
SELECT * FROM rental_orders;
 
DELETE FROM rental_orders
WHERE id between 6 AND 11; 

INSERT INTO rental_orders (employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status, notes) VALUES
  (3, 4, 4, 'car_condition', 50.05, 10000, 20000, kilometrage_end - kilometrage_start, '2024-01-01', '2024-03-23', DATEDIFF(end_date, start_date), 13.2, 15.5, 'order_status', 'notes');
  
  -- 13. Basic Insert
  CREATE SCHEMA soft_uni DEFAULT CHARSET utf8mb4;
  USE soft_uni;
  
  CREATE TABLE towns (
	id INT PRIMARY KEY not null auto_increment,
    name varchar(50)
  );
  
  CREATE TABLE addresses (
	id INT PRIMARY KEY not null auto_increment,
	address_text text,
	town_id int,
    
    FOREIGN KEY (town_id) REFERENCES towns(id)
  );  
  
  
  CREATE TABLE departments (
	id INT PRIMARY KEY not null auto_increment,
    name varchar(50)
  );
  TRUNCATE TABLE employees;
  CREATE TABLE employees (
	id INT PRIMARY KEY not null auto_increment, 
    first_name varchar(50) NOT NULL, 
    middle_name varchar(50) NOT NULL, 
    last_name varchar(50) NOT NULL, 
    job_title varchar(50) NOT NULL, 
    department_id INT, 
    hire_date DATE NOT NULL, 
    salary DOUBLE(10,2) NOT NULL, 
    address_id INT,
    
    FOREIGN KEY (department_id) REFERENCES departments(id),
    FOREIGN KEY (address_id) REFERENCES addresses(id) 
    );
    
-- ALTER TABLE employees DROP FOREIGN KEY fk_foreignKeyDep;
  
-- ALTER TABLE addresses ADD CONSTRAINT fk_foreign_key FOREIGN KEY (town_id) REFERENCES towns(id);  

-- ALTER TABLE employees ADD CONSTRAINT fk_foreignKeyDep FOREIGN KEY (department_id) REFERENCES departments(id);

-- ALTER TABLE employees ADD CONSTRAINT fk_foreignKeyAddress FOREIGN KEY (address_id) REFERENCES addresses (id);

INSERT INTO towns (name) VALUES 
('Sofia'),   
('Plovdiv'),   
('Varna'),   
('Burgas');
   
INSERT INTO departments (name) VALUES 
('Engineering'), -- 1 
('Sales'), -- 2
('Marketing'), -- 3
('Software Development'), -- 4   
('Quality Assurance'); -- 5

INSERT INTO employees (first_name, middle_name, last_name, job_title, department_id, hire_date, salary) values
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);

-- 14. Basic Select All Fields
SELECT * FROM towns;
SELECT * FROM departments;
SELECT * FROM employees;
 
 -- 15. Basic Select All Fields and Order Them
SELECT * FROM towns ORDER BY name;
SELECT * FROM departments ORDER BY name;
SELECT * FROM employees  ORDER BY salary desc;
 
 -- 16. Basic Select Some Fields
SELECT name FROM towns ORDER BY name;
SELECT name FROM departments ORDER BY name;
SELECT first_name, last_name, job_title, salary FROM employees  ORDER BY salary desc;

-- 17. Increase Employees Salary

UPDATE employees SET `salary` = `salary` * 1.1 WHERE id in (1,2,3,4,5);
SELECT salary FROM employees;

  
  