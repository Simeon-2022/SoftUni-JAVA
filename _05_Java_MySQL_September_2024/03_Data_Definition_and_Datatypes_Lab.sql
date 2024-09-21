-- USE `gamebar`; 

CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;


CREATE TABLE `categories`(
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL
);

CREATE TABLE `products` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`category_id` INT NOT NULL,
PRIMARY KEY(`id`)
);

SELECT * FROM employees;
TRUNCATE TABLE employees;

INSERT INTO `employees` VALUES
(1,'SQL',"INSERTED"),
(3,"DOUBLE","QUOTES"),
(2,"NEW","LAST");

ALTER TABLE employees ADD COLUMN salary DECIMAL(5,2) NOT NULL DEFAULT 0.0;
ALTER TABLE employees ADD COLUMN middle_name VARCHAR(50);

ALTER TABLE products
ADD CONSTRAINT fk_category_id
FOREIGN KEY (category_id) REFERENCES categories(id);

ALTER TABLE employees
MODIFY COLUMN middle_name VARCHAR(100);

ALTER TABLE products
DROP CONSTRAINT fk_category_id;

CREATE SCHEMA `minions` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE minions.`minions`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50),
`age` INT);

CREATE TABLE minions.`towns`(
`town_id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50)
);

ALTER TABLE towns RENAME COLUMN town_id TO id;

ALTER TABLE minions ADD COLUMN town_id INT;

ALTER TABLE minions ADD CONSTRAINT fk_foreign_key FOREIGN KEY (town_id) REFERENCES towns(id);
INSERT INTO towns VALUES 
(1,"Sofia"),
(2,"Plovdiv"),
(3,"Varna");

INSERT INTO minions VALUES 
(1, "Kevin", 22, 1),
(2, "Bob", 15, 3),
(3,"Steward", NULL, 2);



select * from minions;
UPDATE minions SET `name` = "Kevin" WHERE id = 1;
