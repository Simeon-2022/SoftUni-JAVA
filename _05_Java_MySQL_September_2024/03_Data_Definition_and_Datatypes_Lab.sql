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