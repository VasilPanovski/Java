-- Functions

/* USE soft_uni;

SELECT * FROM projects;

DELIMITER $$
CREATE FUNCTION udf_project_weeks(start_date DATE, end_date DATE)
RETURNS INT
BEGIN
	DECLARE projectWeeks INT;
	
	IF(end_date IS NULL) THEN
		SET end_date := now();
	ELSE IF (end_date = '2016-10-07') THEN
   	SET end_date := now();
	ELSE
	-- 
	END IF;
	
	SET projectWeeks := DATEDIFF(end_date, start_date)/7;
	RETURN projectWeeks;
END $$

DELIMITER ;

SELECT p.project_id,p.start_date, p.end_date,
       udf_project_weeks(p.start_date,p.end_date)
  FROM projects as p
  
-- Transactions
CREATE DATABASE Trans;

USE Trans;

CREATE TABLE employees(
	employee_id INT,
	employee_name VARCHAR(50)
);

INSERT INTO employees(employee_id, employee_name)
VALUES (1, 'Pesho');

SELECT * FROM employees;

SET autocommit=0;
START TRANSACTION;
INSERT INTO employees(employee_id, employee_name)
VALUES (3, 'Teo');

COMMIT;

SELECT * FROM employees;

-- Procedures
SELECT * FROM employees_projects;

DELIMITER \\
CREATE PROCEDURE udp_assing_project (employee_id INT, project_id INT)
BEGIN
	DECLARE maxProjects INT;
	DECLARE currentProjects INT;
	SET maxProjects := 3;
	SET currentProjects := (SELECT COUNT(*) AS total_projects
  									 FROM employees_projects AS ep
 									WHERE ep.employee_id = employee_id);
 									
 	START TRANSACTION;
 	
 	INSERT INTO employees_projects(employee_id, project_id)
 	VALUES (employee_id, project_id);
 	
 	IF (currentProjects >= maxProjects) THEN
 		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Too many projects';
 		ROLLBACK;
 	ELSE
 		COMMIT;
 	END IF;

END \\

DELIMTER ;

CALL udp_assing_project(227, 5)

SELECT * FROM employees_projects
WHERE employee_id = 227

SELECT employee_id,COUNT(*)
  FROM employees_projects
GROUP BY employee_id
HAVING COUNT(*) = 2

DELETE FROM employees_projects
WHERE employee_id = 227

-- Loops
DELIMITER $$
CREATE PROCEDURE udp_loop_test()
BEGIN
	DECLARE startValue INT;
	DECLARE maxValueVariable INT;
	SET startValue := 0;
	SET maxValueVariable := 10;
	
	WHILE (startValue < maxValueVariable) DO
		SELECT startValue;
		SET startValue := startValue + 1;	
	END WHILE;

END $$


CALL udp_loop_test()

-- Triggers
	CREATE TABLE IF NOT EXISTS employees_projects_history(
	employee_id INT,
	project_id INT
	);

DELIMITER $$
CREATE TRIGGER tr_log_records
AFTER DELETE
ON employees_projects
FOR EACH ROW
BEGIN

	INSERT INTO employees_projects_history(employee_id, project_id)
	VALUES(old.employee_id, old.project_id);
	
END $$

DELIMITER ;

DELETE FROM employees_projects
WHERE employee_id = 1;


SELECT * FROM employees_projects_history 

USE soft_uni;
-- TASK_1
DELIMITER $$

CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN 
    SELECT first_name, last_name
      FROM employees AS e
     WHERE e.salary > 35000;
END $$;

CALL usp_get_employees_salary_above_35000() 

-- TASK_2
DELIMITER $$

CREATE PROCEDURE usp_get_employees_salary_above(salary_above DECIMAL(10,2)) 
BEGIN
	 SELECT first_name, last_name
      FROM employees AS e
     WHERE e.salary >= salary_above;
END;
$$ 

CALL usp_get_employees_salary_above(35000) 

-- TASK_3
DELIMITER ;

DELIMITER $$

CREATE PROCEDURE usp_get_towns_starting_with(starting_with VARCHAR(50)) 
BEGIN
	 SELECT t.name
	   FROM towns AS t
	  WHERE t.name LIKE CONCAT(starting_with, '%');
END
$$

DELIMITER ;

CALL usp_get_towns_starting_with('b') 
-- TASK_4
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(50)) 
BEGIN
	 SELECT e.first_name, e.last_name
	   FROM employees AS e
	   JOIN addresses AS a
	     ON e.address_id = a.address_id
	   JOIN towns AS t
	     ON a.town_id = t.town_id
	  WHERE t.name = town_name;
END 
$$

CALL usp_get_employees_from_town('Sofia') 

-- TASK_5
DELIMITER ;
DELIMITER $$
CREATE PROCEDURE ufn_get_salary_level(given_salary DECIMAL(10,2))
BEGIN 
	 SELECT given_salary AS salary, 
	   CASE 
		WHEN given_salary < 30000 THEN 'Low'
		WHEN given_salary BETWEEN 30000 AND 50000 THEN 'Average'
		ELSE 'High'
		 END AS salary_level;
END;
$$

CALL ufn_get_salary_level(13500); 

-- TASK_6
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(8))
BEGIN
	 SELECT e.first_name, e.last_name
	   FROM employees AS e
	  WHERE 
	   CASE 
		WHEN salary_level = 'Low' THEN e.salary < 30000
		WHEN salary_level = 'Average' THEN e.salary BETWEEN 3000 AND 50000
		WHEN salary_level = 'High' THEN e.salary > 50000
		 END;
END;
$$

CALL usp_get_employees_by_salary_level('high') */

-- TASK_7
DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50)) 
RETURNS TINYINT
BEGIN 
  		DECLARE current_index INT;
  		DECLARE charset_length INT;
  		DECLARE current_letter CHAR;
  		SET current_index := 0;
  		SET charset_length := CHAR_LENGTH(set_of_letters);
  		
  		WHILE current_index < charset_length DO
  			SET current_letter := SUBSTRING(word, current_index, 1);
  			IF (LOCATE(current_letter, set_of_letters) = 0) THEN
	  			RETURN 0;
  			END IF;
			
			SET current_index := current_index + 1;
		
  		END WHILE;
  		
  		RETURN 1;
  END $$
  
SELECT ufn_is_word_comprised('pppp', 'Guy') AS result
	   