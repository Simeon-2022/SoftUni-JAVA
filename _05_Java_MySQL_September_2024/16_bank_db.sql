/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

USE soft_uni;

-- Dumping structure for table bank.accounts
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE IF NOT EXISTS `accounts` (
  `id` int(11) NOT NULL,
  `account_holder_id` int(11) NOT NULL,
  `balance` decimal(19,4) DEFAULT '0.0000',
  PRIMARY KEY (`id`),
  KEY `fk_accounts_account_holders` (`account_holder_id`),
  CONSTRAINT `fk_accounts_account_holders` FOREIGN KEY (`account_holder_id`) REFERENCES `account_holders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bank.accounts: ~18 rows (approximately)
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` (`id`, `account_holder_id`, `balance`) VALUES
	(1, 1, 123.1200),
	(2, 3, 4354.2300),
	(3, 12, 6546543.2300),
	(4, 9, 15345.6400),
	(5, 11, 36521.2000),
	(6, 8, 5436.3400),
	(7, 10, 565649.2000),
	(8, 11, 999453.5000),
	(9, 1, 5349758.2300),
	(10, 2, 543.3000),
	(11, 3, 10.2000),
	(12, 7, 245656.2300),
	(13, 5, 5435.3200),
	(14, 4, 1.2300),
	(15, 6, 0.1900),
	(16, 2, 5345.3400),
	(17, 11, 76653.2000),
	(18, 1, 235469.8900);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;


-- Dumping structure for table bank.account_holders
DROP TABLE IF EXISTS `account_holders`;
CREATE TABLE IF NOT EXISTS `account_holders` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `ssn` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bank.account_holders: ~12 rows (approximately)
/*!40000 ALTER TABLE `account_holders` DISABLE KEYS */;
INSERT INTO `account_holders` (`id`, `first_name`, `last_name`, `ssn`) VALUES
	(1, 'Susan', 'Cane', '1234567890'),
	(2, 'Kim', 'Novac', '1234567890'),
	(3, 'Jimmy', 'Henderson', '1234567890'),
	(4, 'Steve', 'Stevenson', '1234567890'),
	(5, 'Bjorn', 'Sweden', '1234567890'),
	(6, 'Kiril', 'Petrov', '1234567890'),
	(7, 'Petar', 'Kirilov', '1234567890'),
	(8, 'Michka', 'Tsekova', '1234567890'),
	(9, 'Zlatina', 'Pateva', '1234567890'),
	(10, 'Monika', 'Miteva', '1234567890'),
	(11, 'Zlatko', 'Zlatyov', '1234567890'),
	(12, 'Petko', 'Petkov Junior', '1234567890');
/*!40000 ALTER TABLE `account_holders` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

-- 08. Find Full Name

select distinct concat(e.first_name,' ',e.last_name) as full_name from employees e join account_holders a order by full_name;
select distinct concat(e.first_name,' ',e.last_name) as full_name from account_holders e order by full_name;

delimiter $$
create procedure usp_get_holders_full_name()
begin
	select distinct concat(first_name,' ',last_name) as full_name from account_holders order by full_name;
end $$

delimiter ;

call usp_get_holders_full_name();

-- 9. People with Balance Higher Than (not included in final score)
select first_name, last_name
from account_holders ah
where (
		select sum(balance)
		from account_holders aa
		join accounts a on aa.id = a.account_holder_id
        where ah.id = aa.id 
        ) > amount_to_compare;

delimiter $$
create procedure usp_get_holders_with_balance_higher_than(amount_to_compare decimal(12,4))
begin
	select first_name, last_name
	from account_holders ah
	where (
		select sum(balance)
		from account_holders aa
		join accounts a on aa.id = a.account_holder_id
        where ah.id = aa.id 
        ) > amount_to_compare;
end$$
delimiter ;
call usp_get_holders_with_balance_higher_than(1000000);

-- 10. Future Value Function
drop function ufn_calculate_future_value;
delimiter $$
create function ufn_calculate_future_value (initial_sum decimal(20,4),interest_rate decimal(4,4), years int)
returns decimal(20,4)
no sql
begin
	declare future_value decimal(20,4);
    set future_value := round(initial_sum * power((1 + interest_rate), years),4);
    return future_value;
end $$
delimiter ;

select ufn_calculate_future_value (6546543.2300,0.1,5);
select 1000 * power(1.5,5);

-- 11. Calculating Interest
drop function ufn_calculate_future_value;
drop procedure usp_calculate_future_value_for_account;

delimiter $$
create function ufn_calculate_future_value (initial_sum decimal(20,4),interest_rate decimal(4,4), years int)
returns decimal(20,4)
no sql
begin
	declare future_value decimal(20,4);
    set future_value := round(initial_sum * power((1 + interest_rate), years),4);
    return future_value;
end $$ -- ; for Judge
create procedure usp_calculate_future_value_for_account (account_id int, interest_rate decimal(4,4))
begin 
	select  a.id as 'account_id',
			ah.first_name, 
            ah.last_name, 
            a.balance as current_balance,
            ufn_calculate_future_value (a.balance,interest_rate,5) as balance_in_5_years
            from accounts as a
            inner join account_holders as ah
            on ah.id = a.account_holder_id
            where a.id = account_id;
end $$ -- ; for Judge       
delimiter ;

call usp_calculate_future_value_for_account (3,0.1);
select truncate(633333.2300 * power(1.1,5),5);

-- 12. Deposit Money
delimiter $$
create procedure usp_deposit_money(account_id int, money_amount decimal(12,4))
begin
	start transaction;
    if money_amount <= 0 then 
		rollback;
    else
		update accounts set balance = balance + money_amount where id = account_id;
        commit;
    end if;
end $$
delimiter ;
call usp_deposit_money(1, 110); 
select * from accounts where id = 1;

-- 13. Withdraw Money
drop procedure usp_withdraw_money;
delimiter $$
create procedure usp_withdraw_money(account_id int, money_amount decimal(12,4))
begin
	start transaction;
    if money_amount <= 0 or (select balance from accounts where id = account_id) <= money_amount  then 
		rollback;
    else
		update accounts set balance = round(balance - money_amount, 4) where id = account_id;
        commit;
    end if;
end $$
delimiter ;
call usp_withdraw_money(1, -140); 
select * from accounts where id = 1;
delimiter ;

-- 14. Money Transfer
drop procedure usp_transfer_money;
delimiter $$
create procedure usp_transfer_money(from_account_id int, to_account_id int, amount decimal(12, 4))
begin
	start transaction;
    if 	(select id from accounts where id = from_account_id) is null 
		or
		(select id from accounts where id = to_account_id) is null
        or
        amount <= 0
        or
		amount >= (select balance from accounts where id = from_account_id)
        or
        from_account_id = to_account_id
        then
        rollback;
	else
		update accounts set balance = round(balance - amount, 4) where id = from_account_id;
		update accounts set balance = round(balance + amount, 4) where id = to_account_id;
        commit;
	end if;
end $$
    delimiter ;

select id from accounts where id = 20;
select * from accounts where id in (1,2);
call usp_transfer_money(1,2,10);  

-- 15. Log Accounts Trigger (not included in final score)
create table logs(
	log_id int primary key auto_increment,
    account_id int,
    old_sum decimal(12,4), 
    new_sum decimal(12,4)
    );
    
    delimiter $$
    create trigger account_changes_to_log_table
    after update on accounts
    for each row
	begin
		insert into 
        logs (account_id, old_sum, new_sum) 
        values (old.id, old.balance, new.balance);
    end$$
    delimiter ;
call usp_transfer_money(10,12,10);
select * from logs;    

-- 16. Emails Trigger (not included in final score)
create table logs(
	log_id int primary key auto_increment,
    account_id int,
    old_sum decimal(19,4), 
    new_sum decimal(19,4)
    );

create table notification_emails(
	id int auto_increment primary key, 
	recipient int, 
	subject varchar(255), 
	body text
    );

-- drop trigger send_email;
delimiter $$
create trigger send_email
after insert on logs
for each row
begin 
	insert into notification_emails(recipient, subject, body) value  
    (
    new.account_id, 
    concat("Balance change for account:",' ', new.account_id),
    concat("On ",date_format(now(),'%b %d %Y'),' at ',date_format(now(),'%r')," your balance was changed from ",round(new.old_sum,0)," to ",round(new.new_sum, 0), ".")
    );
end $$
delimiter ;
truncate notification_emails;
call usp_transfer_money(1,2,10);
select * from logs;    
select * from notification_emails;
select concat(date_format(now(),'%b %d %Y'),' at ',date_format(now(), '%r'));
