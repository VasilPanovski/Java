
-- Data Aggregation
/*SELECT e.department_id, YEAR(e.hire_date) AS 'hire_year', SUM(e.salary) AS 'total_salary' 
  FROM employees AS e
 GROUP BY e.department_id, YEAR(e.hire_date)
 ORDER BY e.department_id, 'hire_year'
 
SELECT e.department_id, YEAR(e.hire_date) AS HireYear, SUM(e.salary) AS 'total_salary'
  FROM employees AS e
 GROUP BY e.department_id, YEAR(e.hire_date)
 ORDER BY e.department_id, YEAR(e.hire_date)
 
SELECT e.department_id, SUM(e.salary) AS total_salary
  FROM employees AS e
 GROUP BY e.department_id
 ORDER BY total_salary DESC
 LIMIT 5
 
SELECT e.department_id, e.employee_id, e.first_name, e.salary 
  FROM employees AS e
  JOIN 
(SELECT e.department_id, MAX(e.salary) AS max_salary
  FROM employees AS e
 GROUP BY e.department_id) AS max_salaries
    ON e.department_id = max_salaries.department_id
   AND e.salary = max_salaries.max_salary
 ORDER BY e.department_id
 
SELECT AVG(world_wide_profit) AS average_profit, 
       SUM(world_wide_profit)/COUNT(*) AS average_profit_final
  FROM movies
 WHERE rank <= 5
 
 
SELECT COUNT(m.rank) AS new_column
  FROM movies AS m
  
-- Comment 1
/*Comment 2 
#Comment 3\


SELECT m.year, MAX(overseas_profit) AS max_overseas_profit 
  FROM movies AS m
 WHERE m.studio NOT LIKE 'F%'
 GROUP BY m.year
HAVING MAX(overseas_profit) > 500000
   AND MIN(overseas_profit) > 100000
 ORDER BY max_overseas_profit
 LIMIT 5

 

 
-- Data Funtions - EXERSISES!!

USE soft_uni;

SELECT town_id
      ,name
  FROM towns
 WHERE name LIKE 'M%'
    OR name LIKE 'K%'
    OR name LIKE 'B%'
    OR name LIKE 'E%'
 ORDER BY name ASC
 
 -- 
 
 USE geography;
 
 SELECT country_name, iso_code
  FROM countries
 WHERE LENGTH(country_name) - LENGTH(REPLACE(country_name, 'a','')) >= 3
 -- CountryName LIKE '%a%a%a%'
 ORDER BY iso_code ASC
 
 -- 12
 SELECT name, DATE_FORMAT(start, '%Y-%m-%d') AS new_date
  FROM games
 WHERE YEAR(start) IN (2011, 2012)
 ORDER BY start, name
 LIMIT 50
 
 -- 13
SELECT user_name, substr(email,locate('@', email) + 1,length(email)) AS email_provider
  FROM users 
 ORDER BY email_provider, user_name


 -- Data Aggregations
  SELECT CASE
			WHEN age <= 10 THEN '[0-10]'
			WHEN age <= 20 THEN '[11-20]'
			WHEN age <= 30 THEN '[21-30]'
			WHEN age <= 40 THEN '[31-40]'
			WHEN age <= 50 THEN '[41-50]'
			WHEN age <= 60 THEN '[51-60]'
			ELSE '[61+]'
		END AS age_group,
        COUNT(*) AS wizzard_count
   FROM wizzard_deposits
  GROUP BY CASE
			WHEN age <= 10 THEN '[0-10]'
			WHEN age <= 20 THEN '[11-20]'
			WHEN age <= 30 THEN '[21-30]'
			WHEN age <= 40 THEN '[31-40]'
			WHEN age <= 50 THEN '[41-50]'
			WHEN age <= 60 THEN '[51-60]'
			ELSE '[61+]'
	END
	
-- 04
  SELECT deposit_group FROM
(SELECT deposit_group, AVG(magic_wand_size) AS avrage_magic_wand_size
   FROM wizzard_deposits
  GROUP BY deposit_group) as avgm
  WHERE avrage_magic_wand_size = ( SELECT MIN(avrage_magic_wand_size) min_average_magic_wand_size 
								   FROM
								(SELECT deposit_group, AVG(magic_wand_size) AS avrage_magic_wand_size
								   FROM wizzard_deposits
								  GROUP BY deposit_group) AS av)
								  
-- 17

-- 1. MAX Salary
-- 2. Salaries < Max Salary = Second Highest Salary
-- 3. Salaries < Second Highest Salary = Third Highest Salary
SELECT e.department_id, MAX(salary) AS third_max_salary
 FROM employees AS e
 JOIN
(SELECT e.department_id, MAX(salary) as second_max_salary 
  FROM employees AS e
JOIN
(SELECT department_id, MAX(salary) as max_salary 
   FROM employees
  GROUP BY department_id) AS max_salary
    ON e.department_id = max_salary.department_id
   AND e.salary < max_salary.max_salary
 GROUP BY e.department_id) second_max_salary
    ON e.department_id = second_max_salary.department_id
   AND e.salary < second_max_salary.second_max_salary
GROUP BY e.department_id 


-- TASK_5
SELECT deposit_group, SUM(deposit_amount) 
    AS total_sum
  FROM wizzard_deposits
  GROUP BY deposit_group; 
  
-- TASK_6
SELECT deposit_group, SUM(deposit_amount) 
    AS total_sum
  FROM wizzard_deposits
  WHERE magic_wand_creator = 'Ollivander family'
  GROUP BY deposit_group; 
  
-- TASK_7
SELECT deposit_group, SUM(deposit_amount)
    AS total_sum
  FROM wizzard_deposits AS wd
 WHERE magic_wand_creator = 'Ollivander family'
 GROUP BY deposit_group DESC
 HAVING SUM(deposit_amount) < 150000; 
 
-- TASK_8
SELECT deposit_group, magic_wand_creator, MIN(wd.deposit_charge) AS min_deposit_charge
  FROM wizzard_deposits AS wd
 GROUP BY deposit_group, magic_wand_creator
 ORDER BY magic_wand_creator, deposit_group; 
 
-- TASK_9
SELECT 
  CASE 
     WHEN age BETWEEN 0 AND 10 THEN '[0-10]'
     WHEN age BETWEEN 11 AND 20 THEN '[11-20]'
     WHEN age BETWEEN 21 AND 30 THEN '[21-30]'
     WHEN age BETWEEN 31 AND 40 THEN '[31-40]'
     WHEN age BETWEEN 41 AND 50 THEN '[41-50]'
     WHEN age BETWEEN 51 AND 60 THEN '[51-60]'
     ELSE '[61+]'
   END AS age_group,
COUNT(wd.id) AS wizzard_count
  FROM wizzard_deposits AS wd
 GROUP BY age_group; 
 
-- TASK_10
SELECT LEFT(wd.first_name, 1) AS first_letter
  FROM wizzard_deposits AS wd
 WHERE wd.deposit_group = 'Troll Chest'
 GROUP BY first_letter
 ORDER BY first_letter; 
 
-- TASK_11
SELECT wd.deposit_group, wd.is_deposit_expired, AVG(wd.deposit_interest) AS average_interest
  FROM wizzard_deposits AS wd
 WHERE wd.deposit_start_date > '1985-01-01'
 GROUP BY wd.deposit_group, wd.is_deposit_expired
 ORDER BY wd.deposit_group DESC, wd.is_deposit_expired; 
 
-- TASK_12
SELECT SUM(wd_virtual.deposit_amount - wd.deposit_amount) AS sum_difference
  FROM wizzard_deposits AS wd
 INNER JOIN wizzard_deposits AS wd_virtual
    ON wd.id = wd_virtual.id + 1 

-- TASK_13
SELECT department_id, MIN(e.salary) AS minimum_salary
  FROM employees AS e
  WHERE hire_date > '2000-01-01'
 GROUP BY department_id
HAVING e.department_id IN (2,5,7); 

-- TASK_14
CREATE TABLE rich_employees AS
SELECT * 
  FROM employees AS e
 WHERE e.salary > 30000;
 
DELETE FROM rich_employees
 WHERE manager_id = 42;
 
UPDATE rich_employees
  SET salary = salary + 5000
WHERE department_id = 1;

SELECT department_id, AVG(re.salary)
  FROM rich_employees AS re
 GROUP BY department_id; 
 
-- TASK_15
SELECT e.department_id, MAX(salary) AS max_salary
  FROM employees AS e
 GROUP BY e.department_id
 HAVING MAX(salary) NOT BETWEEN 30000 AND 70000 
 
-- TASK_16
SELECT COUNT(e.salary) AS `count`
  FROM employees AS e
 WHERE e.manager_id IS NULL
HAVING COUNT(e.salary); 

-- TASK_17
SELECT e.department_id, MAX(e.salary) AS third_max_salary
  FROM employees AS e
  JOIN
		(SELECT e.department_id, MAX(e.salary) AS max_salary
		  FROM employees AS e
		  JOIN
			  (SELECT department_id, MAX(salary) AS max_salary
			     FROM employees 
			    GROUP BY department_id) AS max_salary
			       ON e.department_id = max_salary.department_id
			      AND e.salary < max_salary.max_salary
		  GROUP BY e.department_id) AS second_max_salary
		    ON e.department_id = second_max_salary.department_id
		   AND e.salary < second_max_salary.max_salary
 GROUP BY e.department_id 
 
-- TASK_18
SELECT e.first_name, e.last_name, e.department_id
  FROM employees AS e
  JOIN
		(SELECT em.department_id, AVG(em.salary) AS avg_salary
		  FROM employees AS em
		 GROUP BY em.department_id) AS avg_salaries
	 ON e.department_id = avg_salaries.department_id
 WHERE e.salary > avg_salaries.avg_salary
 ORDER BY e.department_id 
 LIMIT 10 */
 
 