-- drop schema summer_olympics;
create schema summer_olympics;
use summer_olympics;

create table countries(
	id int primary key auto_increment,
    name varchar(40) not null unique
);

create table sports(
	id int primary key auto_increment,
    name varchar(20) not null unique
);

create table disciplines(
	id int primary key auto_increment,
    name varchar(40) not null unique,
    sport_id int not null,
    
    foreign key(sport_id) references sports(id)
);

create table athletes(
	id int primary key auto_increment,
    first_name varchar(40) not null,
    last_name varchar(40) not null,
    age int not null,
    country_id int not null,
    
    foreign key(country_id) references countries(id)
);

create table medals(
	id int primary key auto_increment,
    type varchar(10) not null unique
);

create table disciplines_athletes_medals(
	discipline_id int not null,
    athlete_id int not null, 
    medal_id int not null,
    
	primary key(discipline_id,athlete_id),
    foreign key(discipline_id) references disciplines(id),
    foreign key(athlete_id) references athletes(id),
    foreign key(medal_id) references medals(id)
);

insert into athletes (first_name, last_name, age, country_id)
select  upper(first_name),
		concat(last_name,' comes from ', c.name ),
        age + country_id,
        country_id
from athletes as a
join countries as c on a.country_id = c.id
where c.name like 'A%';

update disciplines 
set name = replace(name,'weight','');

delete from athletes where age > 35;

select c.id, c.name 
from countries c
left join athletes a on c.id = a.country_id
where a.country_id is null
order by c.name desc
limit 15;

select concat(first_name,' ',last_name) as full_name, age
from athletes a
join disciplines_athletes_medals dam on a.id = dam.athlete_id
where 	age = (select min(age) from athletes)
order by a.id asc;


select a.id, first_name, last_name
from athletes a
left join disciplines_athletes_medals dam on a.id = dam.athlete_id
where dam.athlete_id is null
order by a.id asc;


select a.id, a.first_name , a.last_name, count(dam.medal_id) as medals_count, s.name as sport 
from athletes as a
join disciplines_athletes_medals dam on a.id = dam.athlete_id
join disciplines as d on dam.discipline_id = d.id
join sports as s on d.sport_id = s.id
group by sport,  a.id
order by medals_count desc, a.first_name
limit 10;

select  concat_ws(' ',first_name , last_name) as full_name, 
		(case
			when age <= 18 then 'Teenager'
			when age <= 25 then 'Young adult'
			else 'Adult'
         end) as age_group
from athletes
order by age desc, first_name;
         
delimiter $$         
create function udf_total_medals_count_by_country (name VARCHAR(40))
returns int
deterministic
begin
			return (select count(*) 
					from countries as c
                    join athletes as a on c.id = a.country_id
                    join disciplines_athletes_medals as dam on a.id = athlete_id
                    where c.name = `name`
					);
end $$


create procedure udp_first_name_to_upper_case(letter CHAR(1))
BEGIN
	UPDATE athletes 
    set first_name = upper(first_name)
    where letter = right(first_name, 1);
END $$

drop procedure udp_first_name_to_upper_case;
create procedure udp_first_name_to_upper_case()
BEGIN
	select * from countries;
    select * from athletes;
END$$
delimiter ;
call udp_first_name_to_upper_case;





