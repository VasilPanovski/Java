/*CREATE TABLE users
(
id 				 BIGINT 		 NOT NULL AUTO_INCREMENT,
username 		 VARCHAR(30) NOT NULL,
`password` 		 VARCHAR(26) NOT NULL,
profile_picture VARBINARY(900),
last_login_time TIME,
is_deleted 		 TINYINT(1),
PRIMARY KEY (id),
UNIQUE KEY (username)
);

INSERT INTO users (username, `password`, profile_picture, last_login_time, is_deleted)
VALUES ('Dimityr', 'dim1225k', NULL, NULL, 1),
		 ('Ivan', 'iv12225k', NULL, NULL, 0),
		 ('Liliq', '1234', NULL, NULL, 1),
		 ('Sammy', 'ssmmii', NULL, NULL, 0),
		 ('nobody', 'nobodyagain', NULL, NULL, 1);


	
-- TASK_13
CREATE TABLE directors
(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
director_name VARCHAR(50),
notes VARCHAR(200) 
); 

CREATE TABLE genres
(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
genre_name VARCHAR(50),
notes VARCHAR(200) 
); 

CREATE TABLE categories
(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
category_name VARCHAR(50),
notes VARCHAR(200)
);

CREATE TABLE movies
(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(50) NOT NULL UNIQUE,
director_id INT NOT NULL,
copyright_year YEAR(4) NOT NULL,
`length` INT NOT NULL,
genre_id INT NOT NULL,
category_id INT NOT NULL,
rating TINYINT UNSIGNED NOT NULL,
notes VARCHAR(200),
FOREIGN KEY (director_id) REFERENCES directors(id),
FOREIGN KEY (genre_id) REFERENCES genres(id),
FOREIGN KEY (category_id) REFERENCES categories(id)
); 

INSERT INTO movies.directors (id, director_name, notes)
	VALUES (1, 'Ivanov', 'vice director'),
			 (2, 'Petrov', 'manager'),
			 (3, 'Ilieva', 'HR manager'),
			 (4, 'Me', NULL),
			 (5, 'Others', NULL); 

INSERT INTO movies.categories (id, category_name, notes)
	VALUES (1, 'Drama', 'long movie'),
			 (2, 'Fantasy', 'good'),
			 (3, 'Triler', 'not good'),
			 (4, 'Documentary', 'very good'),
			 (5, 'Other', NULL); 
			 
INSERT INTO movies.genres (id, genre_name, notes)
	VALUES (1, 'Drama', 'long movie'),
			 (2, 'Fantasy', 'good'),
			 (3, 'Triler', 'not good'),
			 (4, 'Documentary', 'very good'),
			 (5, 'Other', NULL); 
			 
INSERT INTO movies.movies (id, title, director_id, copyright_year, `length`, genre_id, category_id, rating, notes)
	VALUES (1,'Dead dog', 1, 2008, 112, 3, 2, 5, 'nice'),
			 (2,'Live dog', 5, 2016, 112, 1, 3, 4, 'very nice'),
			 (3,'Big dog', 3, 2017, 112, 5, 5, 2, 'not nice'),
			 (4,'Small dog', 2, 1994, 112, 4, 4, 3, 'funny'),
			 (5,'Snoop dog', 4, 2001, 112, 2, 1, 1, NULL)
*/

-- TASK_14 
/*CREATE TABLE categories
(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
category VARCHAR(50) NOT NULL UNIQUE,
daily_rate FLOAT NOT NULL,
weekly_rate FLOAT NOT NULL,
montly_rate FLOAT NOT NULL,
weekend_rate FLOAT NOT NULL
); 

CREATE TABLE cars
(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
plate_number VARCHAR(10) NOT NULL UNIQUE,
make DATE,
model VARCHAR(20) NOT NULL,
car_year YEAR(4),
category_id INT NOT NULL,
doors TINYINT NOT NULL,
picture VARBINARY(2048),
`condition` VARCHAR(20),
available TINYINT(1) NOT NULL DEFAULT 0,
FOREIGN KEY (category_id) REFERENCES categories (id)
); 

CREATE TABLE employees
(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
title VARCHAR(50) NOT NULL,
notes VARCHAR(50)
); 

CREATE TABLE customers
(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
driver_licence_number VARCHAR(10) NOT NULL UNIQUE,
full_name VARCHAR(50) NOT NULL UNIQUE,
address VARCHAR(50),
city VARCHAR(20),
zip_code VARCHAR(5),
notes VARCHAR(50)
); 

CREATE TABLE rental_orders
(
id 		  	  		INT				  NOT NULL PRIMARY KEY AUTO_INCREMENT,
employee_id  	   INT				  NOT NULL,
customer_id   		INT				  NOT NULL,
car_id	     		INT				  NOT NULL,
car_condition 		VARCHAR(20)		  NOT NULL,
tank_level 	  		FLOAT				  NOT NULL,
kilometrage_start INT 				  NOT NULL,
kilometrage_end 	INT 				  NOT NULL,
total_kilometrage INT				  NOT NULL,
start_date 			DATE 				  NOT NULL,
end_date 			DATE 				  NOT NULL,
total_days 			TINYINT UNSIGNED NOT NULL,
rate_applied 		DECIMAL  		  NOT NULL,
tax_rate			   DECIMAL  		  NOT NULL,
order_status 		VARCHAR(50) 	  NOT NULL,
notes 				VARCHAR(50),
FOREIGN KEY (employee_id) REFERENCES employees (id),
FOREIGN KEY (customer_id) REFERENCES customers (id),
FOREIGN KEY (car_id) REFERENCES cars (id)
); 

INSERT INTO car_rental.categories (id, category, daily_rate, weekly_rate, montly_rate, weekend_rate)
	VALUES (1, 'car', 100.00, 800.00, 1500.00, 180.00),
			 (2, 'van', 150.00, 900.00, 1700.00, 200.00),
			 (3, 'truck', 200.00, 1200.00, 3000.00, 350.00); 
			 
INSERT INTO car_rental.cars (id, plate_number, make, model, car_year, category_id, doors, picture, `condition`, available)
	VALUES (1, 'CA5555KN', '2005-08-10', 'opel-tigra', 2008, 2, 5, NULL, 'good', true),
			 (2, 'CA3333KN', '2010-05-18', 'opel-mondeo', 2005, 3, 5, NULL, 'good', false),
			 (3, 'CA2551KN', '2015-08-10', 'tesla', 2015, 1, 5, NULL, 'excellent', true); 
			 
INSERT INTO car_rental.employees (id, first_name, last_name, title, notes)
	VALUES (1, 'Vasil', 'Panovski', 'engineer', 'bla bla'),
			 (2, 'Lili', 'Ivanova', 'office-assistant', NULL),
		  	 (3, 'DJ', 'Bobo', 'dj', 'tup tup'); 
		  	 
INSERT INTO car_rental.customers (id, driver_licence_number, full_name, address, city, zip_code, notes)
	VALUES (1, '1526651', 'Liq Totova', NULL, 'Sofia', NULL, NULL),
			 (2, '1526677', 'Liqna Totkova', NULL, 'Sofia', NULL, NULL),
			 (3, '1526612', 'Lili Tonkova', NULL, 'Plovdiv', NULL, 'best employee');
			 
	
INSERT INTO car_rental.rental_orders 
(id, employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, kilometrage_end, 
 total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status, notes)
	VALUES 
	(1, 2, 1, 3, 'good', 10.5, 23150, 23280,kilometrage_end-kilometrage_start, '2016-11-12', '2016-11-15', 
	DATEDIFF(end_date, start_date), 600.00, 120.00, 'Paid', NULL),
	(2, 1, 2, 2, 'very good', 45.00, 1250, 1350,kilometrage_end-kilometrage_start, '2016-10-12', '2016-10-19', 
	DATEDIFF(end_date, start_date), 1000.00, 200.00, 'NOT PAID', NULL),
	(3, 3, 3, 1, 'excellent', 25.00, 1150, 1180,kilometrage_end-kilometrage_start, '2016-05-12', '2016-05-20', 
	DATEDIFF(end_date, start_date), 900.00, 100.00, 'Paid', NULL); */
	

-- TASK_15
-- CREATE DATABASE hotel

/*CREATE TABLE employees
(
id 		  INT 		  NOT NULL PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(10) NOT NULL,
last_name  VARCHAR(10) NOT NULL,
title 	  VARCHAR(50) NOT NULL,
notes 	  VARCHAR(50)
); 

CREATE TABLE customers
(
account_number   VARCHAR(20) NOT NULL PRIMARY KEY UNIQUE,
first_name 		  VARCHAR(10) NOT NULL,
last_name  		  VARCHAR(10) NOT NULL,
phone_number 	  VARCHAR(50) NOT NULL UNIQUE,
emergency_name   VARCHAR(10) NOT NULL,
emergency_number VARCHAR(15) NOT NULL,
notes 			  VARCHAR(50)
); 

CREATE TABLE room_status
(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
room_status VARCHAR(10) NOT NULL,
notes VARCHAR(50)
);

CREATE TABLE bed_types
(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
bed_type VARCHAR(20) NOT NULL,
notes VARCHAR(50)
); 

CREATE TABLE room_types
(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
room_type VARCHAR(20) NOT NULL,
notes VARCHAR(50)
); 

CREATE TABLE rooms
(
room_number   MIDDLEINT UNSIGNED NOT NULL PRIMARY KEY UNIQUE,
room_type 	  INT	   		      NOT NULL,
bed_type 	  INT 					NOT NULL,
rate     	  DECIMAL(10,2) 		NOT NULL,
`room_status` INT		   			NOT NULL,
notes 		  VARCHAR(50),
FOREIGN KEY (room_type) REFERENCES hotel.room_types (id),
FOREIGN KEY (bed_type) REFERENCES hotel.bed_types (id),
FOREIGN KEY (`room_status`) REFERENCES hotel.room_status (id)
); 

CREATE TABLE payments
(
id 					  INT 		   NOT NULL PRIMARY KEY AUTO_INCREMENT,
employee_id 		  INT 			NOT NULL,
payment_date		  DATE		   NOT NULL,
account_number 	  VARCHAR(20)  NOT NULL UNIQUE,
first_date_occupied DATE 			NOT NULL,
last_date_occupied  DATE 			NOT NULL,
total_days 			  INT 			NOT NULL DEFAULT 0,
amount_charged 	  DECIMAL(10,2)NOT NULL DEFAULT 0.00,
tax_rate				  TINYINT 		NOT NULL,
tax_amount 	  		  DECIMAL(10,2)NOT NULL,
payment_total 		  DECIMAL(10,2)NOT NULL DEFAULT 0.00,
notes 				  VARCHAR(50),
FOREIGN KEY (employee_id) 	 	   REFERENCES hotel.employees (id),
FOREIGN KEY (account_number) 		REFERENCES hotel.customers (account_number)
); 

CREATE TABLE occupancies 
(
id 				INT 					 NOT NULL PRIMARY KEY AUTO_INCREMENT, 
employee_id 	INT 					 NOT NULL, 
date_occupied  DATE 					 NOT NULL, 
account_number VARCHAR(20) 		 NOT NULL, 
room_number 	MIDDLEINT UNSIGNED NOT NULL UNIQUE, 
rate_applied   DECIMAL(10,2) 		 NOT NULL DEFAULT 0.00, 
phone_charge   DECIMAL (10,2)		 NOT NULL DEFAULT 0.00, 
notes			   VARCHAR(50),
FOREIGN KEY (employee_id) REFERENCES hotel.employees (id),
FOREIGN KEY (account_number) REFERENCES hotel.customers (account_number),
FOREIGN KEY (room_number) REFERENCES hotel.rooms (room_number)
); 

/*INSERT INTO employees (id, first_name, last_name, title, notes)
	VALUES (1, 'Ivan', 'Georgiev', 'Manager', NULL),
			 (2, 'Mia', 'Hristova', 'HR', NULL),
			 (3, 'Eva', 'Nikolova', 'DOT NET Developer', NULL); 
			 
INSERT INTO customers (account_number, first_name, last_name, phone_number, emergency_name, emergency_number, notes)
	VALUES ('FIB12-1225-5545-2325', 'Evan', 'Bloom', '+359886332331', 'Hospital', '+359232233', NULL),
			 ('RFB20-1565-8645-1538', 'Lusie', 'Hamer', '+359886332553', 'Police', '+359215335', NULL),
			 ('PSB13-1003-0526-2563', 'Kevin', 'Brum', '+359886132558', 'Hospital', '+359225663', NULL); 
			 
INSERT INTO room_status (id, `room_status`, notes)
	VALUES (1, 'available', NULL),
			 (2, 'unvailable', NULL),
		  	 (3, 'cleaning', 'for long time'); 
		  	 
INSERT INTO room_types (id, room_type, notes)
	VALUES (1, 'double persons', NULL),
			 (2, 'one persons', NULL),
		  	 (3, 'president room', NULL); 
		  	 
INSERT INTO bed_types (id, bed_type, notes)
	VALUES (1, 'single', NULL),
			 (2, 'double', NULL),
		 	 (3, 'huge', NULL); 
		 	 
INSERT INTO rooms (room_number, room_type, bed_type, rate, `room_status`, notes)
	VALUES (101, 1, 2, 100.00, 3, NULL),
			 (102, 3, 1, 200.00, 1, NULL),
			 (107, 2, 2, 150.00, 1, NULL); 
			 
INSERT INTO payments (id, employee_id, payment_date, account_number, first_date_occupied, 
last_date_occupied, total_days, amount_charged, tax_rate, tax_amount, payment_total, notes)
	VALUES (1, 1, '2016-09-01', 'FIB12-1225-5545-2325', '2016-08-10', '2016-08-17', 
			 DATEDIFF(last_date_occupied, first_date_occupied), 500.00, 20, 100.00, amount_charged + tax_amount, NULL),
			 (2, 1, '2016-07-19', 'RFB20-1565-8645-1538', '2016-07-11', '2016-07-18', 
			 DATEDIFF(last_date_occupied, first_date_occupied), 800.00, 20, 160.00, amount_charged + tax_amount, NULL),
			 (3, 3, '2016-06-15', 'PSB13-1003-0526-2563', '2016-06-20', '2016-06-30', 
			 DATEDIFF(last_date_occupied, first_date_occupied), 1000.00, 20, 200.00, amount_charged + tax_amount, NULL); 
			 
INSERT INTO occupancies (id, employee_id, date_occupied, account_number, room_number, rate_applied, phone_charge, notes)
	VALUES (1, 1, '2016-08-01', 'FIB12-1225-5545-2325', 107, 820.50, 0.00, NULL),
			 (2, 3, '2016-08-01', 'RFB20-1565-8645-1538', 102, 560.50, 10.00, NULL),
			 (3, 2, '2016-08-01', 'PSB13-1003-0526-2563', 101, 1020.00, 3.25, NULL); */
			   

-- TASK_16
-- CREATE DATABASE softuni

/*CREATE TABLE towns (
id   INT 		  NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
); 

CREATE TABLE addresses (
id 			 INT 			 NOT NULL AUTO_INCREMENT,
address_text VARCHAR(50) NOT NULL DEFAULT ' ',
town_id 		 INT 			 NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (town_id) REFERENCES towns (id)
); 

CREATE TABLE departments (
id   INT 		NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL UNIQUE,
PRIMARY KEY (id)
); 

CREATE TABLE employees (
id 		  	  INT 			 NOT NULL AUTO_INCREMENT, 
first_name    VARCHAR(20)   NOT NULL, 
middle_name   VARCHAR(20), 
last_name 	  VARCHAR(20)   NOT NULL, 
job_title 	  VARCHAR(50)   NOT NULL, 
department_id INT 			 NOT NULL, 
hire_date 	  DATE 			 NOT NULL, 
salary 		  DECIMAL(10,2) NOT NULL, 
PRIMARY KEY (id),
FOREIGN KEY (department_id) REFERENCES departments (id)
-- FOREIGN KEY (address_id) REFERENCES addresses (id)
); 

INSERT INTO towns (name)
VALUES ('Sofia'), ('Plovdiv'), ('Varna'), ('Burgas'); 

INSERT INTO departments (name)
VALUES ('Engineering'), ('Sales'), ('Marketing'), ('Software Development'), ('Quality Assurance'); 


INSERT INTO employees (first_name, middle_name, last_name, job_title, department_id, hire_date, salary)
VALUES ('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
		 ('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
		 ('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
		 ('Georgi', 'Teziev', 'Ivanov', 'CEO', 2, '2007-12-07', 3000.00),
		 ('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88); 
		 
SELECT * FROM towns; 

SELECT * FROM departments; 

SELECT * FROM employees; 

SELECT * FROM towns
ORDER BY name; 

SELECT * FROM departments
ORDER BY name; 

SELECT * FROM employees
ORDER by salary DESC;

SELECT name FROM towns
ORDER BY name;

SELECT name FROM departments
ORDER BY name;

SELECT first_name, last_name, job_title, salary FROM employees
ORDER BY salary DESC;

SELECT (salary + (salary * 0.1)) FROM employees; 


SELECT tax_rate - (tax_rate * 0.03) FROM hotel.payments

TRUNCATE hotel.occupancies*/
