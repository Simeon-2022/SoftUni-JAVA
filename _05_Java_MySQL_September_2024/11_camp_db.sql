CREATE DATABASE camp;
use camp;

CREATE TABLE rooms(
	id INT PRIMARY KEY,
	occupation VARCHAR(20) not null,
	beds_count int not null
);

CREATE TABLE vehicles(
	id int primary key auto_increment not null,
	driver_id int not null,
	vehicle_type varchar(30) not null,
	passengers int not null
);

CREATE TABLE campers(
	id INT PRIMARY KEY auto_increment,
	first_name varchar(20) not null,
	last_name varchar(20) not null,
	age int not null,
	room int,
	vehicle_id int,
	CONSTRAINT fk_room_id FOREIGN KEY(room) REFERENCES rooms(id),
  	CONSTRAINT fk_vehicle_id FOREIGN KEY(vehicle_id) REFERENCES vehicles(id) on delete cascade
);

CREATE TABLE routes(
	id INT PRIMARY KEY auto_increment,
	starting_point varchar(30) not null,
	end_point varchar(30) not null,
	leader_id int not null,
	route_time TIME NOT NULL,	
	CONSTRAINT fk_leader_id FOREIGN KEY(leader_id) REFERENCES campers(id)
);

insert into rooms(id,occupation,beds_count) values(101,"occupied",3),
(102,"free",3),
(103,"free",3),
(104,"free",2),
(105,"free",2),
(201,"free",3),
(202,"free",3),
(203,"free",2),
(204,"free",3),
(205,"free",3),
(301,"free",2),
(302,"free",2),
(303,"free",2),
(304,"free",3),
(305,"free",3);

insert into campers(first_name, last_name, age,room) values
("Simo", "Sheytanov", 20,101),
("Roli", "Dimitrova", 27,102),
("RoYaL", "Yonkov", 25,301),
("Ivan", "Ivanov", 28,301),
("Alisa", "Terzieva", 25,102),
("Asya", "Ivanova", 26,102),
("Dimitar", "Verbov", 21,301),
("Iskren", "Ivanov", 28,302),
("Bojo", "Gevechanov", 28,302);

insert into vehicles(driver_id,vehicle_type,passengers) values
(1,"bus",20),
(2,"van",10),
(1,"van",10),
(4,"car",5),
(5,"car",5),
(6,"car",4),
(7,"car",3),
(8,"bus",3);

insert into routes(starting_point,end_point,leader_id,route_time) values
("Hotel Malyovitsa", "Malyovitsa Peak", 3, '02:00:00'),
("Hotel Malyovitsa", "Malyovitsa Hut", 3, '00:40:00'),
("Ribni Ezera Hut", "Rila Monastery", 3, '06:00:00'),
("Borovets", "Musala Peak", 4, '03:30:00');

-- 1. Mountains and Peaks
CREATE TABLE mountains (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE peaks (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    mountain_id int,
    
    CONSTRAINT fk_peaks_mountain_id FOREIGN KEY(mountain_id) REFERENCES mountains(id)
);

-- 2. Trip Organization
select * from campers;
SELECT driver_id, vehicle_type,
CONCAT(first_name, ' ', last_name) as driver_name 
FROM vehicles AS v
JOIN campers AS c 
-- ON v.id = c.vehicle_id;
ON v.driver_id = c.id;

-- 3. SoftUni Hiking
select starting_point as route_starting_point, end_point as route_ending_point, leader_id, concat(first_name, ' ', last_name) as leader_name
from routes as r
join campers as c
on r.leader_id = c.id;

-- 4. Delete Mountains
CREATE TABLE mountains (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE peaks (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    mountain_id int,
    
    CONSTRAINT fk_peaks_mountain_id FOREIGN KEY(mountain_id) REFERENCES mountains(id)
	ON DELETE CASCADE
);


INSERT INTO mountains(name) VALUES
('Mountain1'),
('Mountain2'),
('Mountain3');

INSERT INTO peaks (name, mountain_id) VALUES
('Peak1',1),
('Peak2',2),
('Peak3',3);

select * from mountains m 
join peaks p
on m.id = p.mountain_id;

delete from mountains where id = 2;

-- 5.
CREATE SCHEMA Project_Management;
USE Project_Management;

CREATE TABLE clients(
	id INT(11) NOT NULL auto_increment,
    client_name VARCHAR(100)
);

CREATE TABLE employees (
	id INT(11) NOT NULL auto_increment,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    project_id INT(11)
);

CREATE TABLE projects (
	id INT(11) NOT NULL auto_increment,
    client_id INT(11),
    project_lead_id INT(11)
);



