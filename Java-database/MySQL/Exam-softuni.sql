
CREATE DATABASE soft_uni;

USE soft_uni;

CREATE TABLE towns (
	town_id INT,
	town_name VARCHAR(30) NOT NULL,
	CONSTRAINT PK_towns PRIMARY KEY(town_id)
);

CREATE TABLE airports (
	airport_id INT,
	airport_name VARCHAR(50) NOT NULL,
	town_id INT NOT NULL,
	CONSTRAINT PK_airports PRIMARY KEY(airport_id),
	CONSTRAINT FK_airports_towns FOREIGN KEY(town_id) REFERENCES towns(town_id)
);

CREATE TABLE airlines (
	airline_id INT,
	airline_name VARCHAR(30) NOT NULL,
	nationality VARCHAR(30) NOT NULL,
	rating INT DEFAULT 0,
	CONSTRAINT PK_airlines PRIMARY KEY(airline_id)
);

CREATE TABLE customers (
	customer_id INT,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	date_of_birth DATE NOT NULL,
	gender VARCHAR(1) NOT NULL CHECK (Gender='M' OR Gender='F'),
	home_town_id INT NOT NULL,
	CONSTRAINT PK_customers PRIMARY KEY(customer_id),
	CONSTRAINT FK_customers_towns FOREIGN KEY(home_town_id) REFERENCES towns(town_id)
);


INSERT INTO towns(town_id, town_name)
VALUES
(1, 'Sofia'),
(2, 'Moscow'),
(3, 'Los Angeles'),
(4, 'Athene'),
(5, 'New York');

INSERT INTO airports(airport_id, airport_name, town_id)
VALUES
(1, 'Sofia International Airport', 1),
(2, 'New York Airport', 5),
(3, 'Royals Airport', 1),
(4, 'Moscow Central Airport', 2);

INSERT INTO airlines(airline_id, airline_name, nationality, rating)
VALUES
(1, 'Royal Airline', 'Bulgarian', 200),
(2, 'Russia Airlines', 'Russian', 150),
(3, 'USA Airlines', 'American', 100),
(4, 'Dubai Airlines', 'Arabian', 149),
(5, 'South African Airlines', 'African', 50),
(6, 'Sofia Air', 'Bulgarian', 199),
(7, 'Bad Airlines', 'Bad', 10);

INSERT INTO customers(customer_id, first_name, last_name, date_of_birth, gender, home_town_id)
VALUES
(1, 'Cassidy', 'Isacc', '1997-10-20', 'F', 1),
(2, 'Jonathan', 'Half', '1983-03-22', 'M', 2),
(3, 'Zack', 'Cody', '1989-08-08', 'M', 4),
(4, 'Joseph', 'Priboi', '1950-01-01', 'M', 5),
(5, 'Ivy', 'Indigo', '1993-12-31', 'F', 1);

CREATE TABLE flights(
flight_id INT PRIMARY KEY,
departure_time DATETIME NOT NULL,
arrival_time DATETIME NOT NULL,
`status` ENUM('Departing', 'Delayed', 'Arrived', 'Cancelled'),
origin_airport_id INT,
destination_airport_id INT,
airline_id INT,
CONSTRAINT fk_flights_airports FOREIGN KEY (origin_airport_id) REFERENCES airports (airport_id),
CONSTRAINT fk_flights_airports_2 FOREIGN KEY (destination_airport_id) REFERENCES airports (airport_id),
CONSTRAINT fk_flights_airlines FOREIGN KEY (airline_id) REFERENCES airlines (airline_id)
); 

CREATE TABLE tickets(
ticket_id INT PRIMARY KEY,
price DECIMAL(8,2) NOT NULL,
class ENUM('First', 'Second', 'Third'),
seat VARCHAR(6) NOT NULL,
customer_id INT,
flight_id INT,
CONSTRAINT fk_tickets_customers FOREIGN KEY (customer_id) REFERENCES customers (customer_id),
CONSTRAINT fk_tickets_flights FOREIGN KEY (flight_id) REFERENCES flights (flight_id)
);

INSERT INTO flights
VALUES(1,   '2016-10-13 18:00:00',	'2016-10-13 22:00:00',  'Delayed',   1, 4, 1),
		(2,	'2016-10-12 12:00:00',	'2016-10-12 12:01:00',	'Departing', 1, 3, 2),
		(3,	'2016-10-14 03:00:00',	'2016-10-20 16:00:00',	'Delayed',	 4, 2, 4),
		(4,	'2016-10-12 01:24:00',	'2016-10-12 04:31:00',	'Departing', 3, 1, 3),
		(5,	'2016-10-12 20:11:00',	'2016-10-12 11:22:00',	'Departing', 4, 1, 1),
		(6,	'1995-06-21 12:30:00',	'1995-06-22 08:30:00',	'Arrived',	 2, 3, 5),
		(7,	'2016-10-12 11:34:00',	'2016-10-13 15:00:00',	'Departing', 2, 4, 2),
		(8,	'2016-11-11 01:00:00',	'2016-11-12 10:00:00',	'Delayed',	 4, 3, 1),
		(9,	'2015-10-01 12:00:00',	'2015-12-01 13:00:00',	'Arrived', 	1,	2,	1),
		(10,'2016-10-12 07:30:00',	'2016-10-13 00:30:00',	'Departing',	2,	1,	7); 


INSERT INTO tickets
VALUES (1,	3000.00,	'First',	'233-A',	3,	8),
	  	(2,	1799.90,	'Second','123-D',	1,	1),
		(3,	1200.50,	'Second','12-Z',	2,	5),
		(4,	410.68,	'Third',	'45-Q',	2,	8),
		(5,	560.00,	'Third',	'201-R',	4,	6),
		(6,	2100.00,	'Second','13-T',	1,	9),
		(7,	5500.00,	'First',	'98-O',	2,	7); 
		
UPDATE flights AS f
   SET f.airline_id= 1
 WHERE f.status = 'Arrived'; 

-- UPDATE TICKETS
UPDATE tickets
   SET price = price * 1.5
 WHERE ticket_id IN (SELECT t.ticket_id
 								FROM tickets AS t
							  INNER JOIN flights AS f
								  ON t.flight_id = f.flight_id 
							  INNER JOIN airlines AS a
							  WHERE a.rating = (SELECT MAX(a.rating)
							  							 FROM airlines AS a)); 
							  							 

CREATE TABLE customer_reviews(
review_id INT PRIMARY KEY,
review_content VARCHAR(255) NOT NULL,
review_grade INT, 
airline_id INT,
customer_id INT, 
CONSTRAINT fk_customer_reviews_airlines FOREIGN KEY (airline_id) REFERENCES airlines (airline_id),
CONSTRAINT fk_customer_reviews_customers FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
); 

CREATE TABLE customer_bank_accounts(
account_id INT PRIMARY KEY,
account_number VARCHAR(10) NOT NULL UNIQUE,
balance DECIMAL(10,2) NOT NULL,
customer_id INT,
CONSTRAINT fk_customer_bank_accounts_customer FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
); 

-- TASK_5 
INSERT INTO customer_reviews
VALUES (1,	'Me is very happy. Me likey this airline. Me good.',				10, 1,	1),
		 (2,	'Ja, Ja, Ja... Ja, Gut, Gut, Ja Gut! Sehr Gut!'	,					10, 1,	4),
		 (3,	'Meh...'	,																		 5, 4,	3),
		 (4,	'Well Ive seen better, but Ive certainly seen a lot worse...',	 7, 3,	5);


INSERT INTO customer_bank_accounts
VALUES (1,	'123456790',	2569.23,			1),
		 (2,	'18ABC23672',	14004568.23,	2),
		 (3,	'F0RG0100N3',	19345.20,		5);



-- QUERING TASK_1
SELECT t.ticket_id, t.price, t.class, t.seat 
  FROM tickets AS t
 ORDER BY t.ticket_id;
-- TASK_2
SELECT c.customer_id, CONCAT(c.first_name, ' ', c.last_name) AS full_name, c.gender
  FROM customers AS c
 ORDER BY full_name, c.customer_id; 
 
-- TASK_3
SELECT f.flight_id, f.departure_time, f.arrival_time
  FROM flights AS f
 WHERE f.`status` = 'Delayed'
 ORDER BY f.flight_id; 
 
 -- TASK_4
SELECT a.airline_id, a.airline_name, a.nationality, a.rating
  FROM airlines AS a
 ORDER BY a.rating DESC, a.airline_id
 LIMIT 5;

-- TASK_5
SELECT t.ticket_id, a.airport_name AS destination,  CONCAT(c.first_name, ' ', c.last_name) AS customer_name
  FROM tickets AS t
 INNER JOIN customers AS c
    ON t.customer_id = c.customer_id
 INNER JOIN flights AS f
    ON t.flight_id = f.flight_id
 INNER JOIN airports AS a
    ON a.airport_id = f.destination_airport_id
 WHERE t.price < 5000
   AND t.class = 'First'
 GROUP BY t.ticket_id; 
 
-- TASK_6
SELECT DISTINCT c.customer_id, CONCAT(c.first_name, ' ', c.last_name) AS full_name ,t.town_name AS home_town
  FROM customers AS c
 INNER JOIN towns AS t
    ON t.town_id = c.home_town_id
 INNER JOIN airports AS a
    ON a.town_id = t.town_id
 INNER JOIN flights AS f
    ON f.origin_airport_id = a.airport_id
   AND f.`status` = 'Departing'
 ORDER BY c.customer_id; 
 
-- TASK_7
SELECT DISTINCT c.customer_id, CONCAT(c.first_name, ' ', c.last_name) AS full_name, YEAR(CURDATE()) - YEAR(c.date_of_birth) as age
  FROM customers AS c
 INNER JOIN tickets AS t
    ON c.customer_id = t.customer_id
 INNER JOIN flights AS f
    ON f.flight_id = t.flight_id
   AND f.`status` = 'Departing'; 
   
-- TASK_8
SELECT c.customer_id, CONCAT(c.first_name, ' ', c.last_name) AS full_name, t.price AS ticket_price, a.airport_name AS destination
  FROM customers AS c
 INNER JOIN tickets AS t
    ON c.customer_id = t.customer_id
 INNER JOIN flights AS f
    ON f.flight_id = t.flight_id
   AND f.`status` = 'Delayed'
 INNER JOIN airports AS a
    ON a.airport_id = f.destination_airport_id
 ORDER BY t.price DESC, c.customer_id
 LIMIT 3; 

-- TASK_9
SELECT f.flight_id, f.departure_time, f.arrival_time, a.airport_name AS origin, ap.airport_name AS destination
  FROM flights AS f
  INNER JOIN airports AS a
     ON a.airport_id = f.origin_airport_id
  INNER JOIN airports AS ap
     ON ap.airport_id = f.destination_airport_id
  WHERE f.`status` = 'Departing'
  ORDER BY f.departure_time, f.flight_id 
  
-- TASK_10
SELECT c.customer_id, CONCAT(c.first_name, ' ', c.last_name) AS full_name, 2016 - YEAR(c.date_of_birth) AS age
  FROM customers AS c 
 INNER JOIN tickets AS t
    ON t.customer_id = c.customer_id
 INNER JOIN flights AS f
    ON f.flight_id = t.flight_id
   AND f.`status` = 'Arrived'
 WHERE 2016 - YEAR(c.date_of_birth) < 21 
 
-- TASK_11
SELECT a.airport_id, a.airport_name, COUNT(*) AS passengers
  FROM airports AS a
 INNER JOIN flights AS f
    ON a.airport_id = f.origin_airport_id
    OR a.airport_id = f.destination_airport_id
  RIGHT OUTER JOIN tickets AS t
    ON t.flight_id = f.flight_id
 WHERE f.`status` = 'Departing'
 GROUP BY a.airport_id;
 
-- PROGRAMMABILITY

-- TASK_1
DELIMITER $$
CREATE PROCEDURE usp_submit_review(customer_id INT, review_content VARCHAR(255), review_grade INT, airline_name VARCHAR(30))
BEGIN 
	DECLARE reviews_id INT;
	DECLARE airline_id INT;
	SET reviews_id := (SELECT MAX(cr.review_id) FROM customer_reviews AS cr);
	SET reviews_id := reviews_id + 1;
	SET airline_id := (SELECT a.airline_id FROM airlines AS a WHERE a.airline_name = airline_name);
	
	START TRANSACTION;
	
	INSERT INTO customer_reviews 
	VALUES (reviews_id, review_content, review_grade, airline_id, customer_id);
	
	IF (airline_id < 0) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Airline does not exist';
		ROLLBACK;
	ELSE COMMIT;
	END IF;
END $$

DELIMITER ; 

-- TASK_2

DELIMITER $$
CREATE PROCEDURE usp_purchase_ticket(customer_id INT, 
													flight_id INT, 
													ticket_price DECIMAL(8,2), 	
													class ENUM('First', 'Second', 'Third'), 
													seat VARCHAR(6))
proc_tickets:BEGIN
DECLARE next_ticket_id INT;
DECLARE customer_current_amount DECIMAL(8, 2);
DECLARE new_customer_amount DECIMAL(10,2);
SET next_ticket_id := (SELECT MAX(t.ticket_id) FROM tickets AS t) + 1;
SET customer_current_amount := (SELECT ca.balance
											 FROM customer_bank_accounts AS ca
											WHERE ca.customer_id = customer_id);

IF (next_ticket_id > customer_current_amount) THEN
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Insufficient bank account balance for ticket purchase.';
	LEAVE proc_tickets;
END IF;

INSERT INTO tickets 
VALUES (next_ticket_id, ticket_price, class, seat, customer_id, flight_id);

SET new_customer_amount := customer_current_amount - ticket_price;

UPDATE customer_bank_accounts AS cba
   SET cba.balance = new_customer_amount
 WHERE cba.customer_id = customer_id;
 
END $$

CALL usp_purchase_ticket(3, 8, 1000, 'First', '233-A') */