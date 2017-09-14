-- TASK_2
/*SELECT *
  FROM departments; 
  

-- TASK_4
SELECT first_name, last_name, salary
  FROM employees; 

-- TASK_3
SELECT name
  FROM departments;
  
-- TASK_5
SELECT first_name, middle_name, last_name
  FROM employees;
  
-- TASK_6
SELECT CONCAT(first_name, '.', last_name, '@softuni.bg') AS Full_email_address
  FROM employees;
  
-- TASK_7
SELECT DISTINCT salary
  FROM employees; 
  
-- TASK_8
SELECT *
  FROM employees AS e
 WHERE e.job_title = 'Sales Representative'; 
 
-- TASK_9
SELECT first_name, last_name, job_title
  FROM employees AS e
 WHERE e.salary BETWEEN 20000 AND 30000; 
 
-- TASK-10
SELECT CONCAT(first_name, ' ', middle_name, ' ', last_name) AS full_name
  FROM employees AS e
 WHERE e.salary = 25000 
    OR e.salary = 14000 
	 OR e.salary = 12500 
	 OR e.salary = 23600; 
	 
-- TASK_11
SELECT first_name, last_name
  FROM employees AS e
 WHERE e.manager_id is NULL; 
 
-- TASK_12
SELECT first_name, last_name, salary
  FROM employees AS e
 WHERE e.salary > 50000
 ORDER BY e.salary DESC; 
 
-- TASK_13
SELECT first_name, last_name
  FROM employees AS e
 ORDER BY e.salary DESC
 LIMIT 5; 

-- TASK_14
SELECT first_name, last_name
  FROM employees AS e
 WHERE department_id != 4; 
 
-- TASK_15
SELECT *
  FROM employees AS e
  ORDER BY e.salary DESC,
  			  e.first_name,
           e.last_name DESC,
  			  e.middle_name; 
  			  
-- TASK_16
CREATE VIEW v_employees_salaries AS
SELECT first_name, last_name, salary
  FROM employees; 
  
-- TASK_17
CREATE VIEW v_employees_job_titles AS
SELECT CONCAT(first_name, ' ', IFNULL(CONCAT(middle_name, ' '), ' '), last_name) AS full_name, job_title
  FROM employees; 
  
-- TASK_18
SELECT DISTINCT job_title
  FROM employees; 
  
-- TASK_19
SELECT *
  FROM projects AS pr
  ORDER BY start_date,
  			  name
  LIMIT 10; 
  
-- TASK_20
SELECT first_name, last_name, hire_date
  FROM employees AS e
  ORDER BY hire_date DESC
  LIMIT 7; 
  
-- TASK_21
UPDATE employees AS e
   SET e.salary = e.salary + e.salary * 0.12
  WHERE e.department_id = 1
     OR e.department_id = 2
     OR e.department_id = 4
     OR e.department_id = 11; 
    
SELECT salary
  FROM employees; 
  
-- TASK_22
SELECT peak_name
  FROM peaks
  ORDER BY peak_name; 
  
-- TASK_23
SELECT country_name, population
  FROM countries AS c
 WHERE c.continent_code = 'EU'
 ORDER BY population DESC
 LIMIT 30; 
 
-- TASK_24
SELECT country_name, country_code, 
  (CASE WHEN (c.currency_code != 'EUR' OR c.currency_code IS NULL) THEN 'Not Euro'
       ELSE 'Euro'
  END) AS currency
  FROM countries AS c
  ORDER BY country_name; 
  
-- TASK_25
SELECT name
  FROM characters
  ORDER BY name */