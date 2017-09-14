-- SELECT SUBSTRING(name, 2, CHAR_LENGTH(name)) FROM games

-- SELECT LOCATE('b', name, 3) FROM games -- give me the index of symbol b and start looking from position 3 to right

-- SELECT CHAR_LENGTH(REPLACE(name, 'a', '')) FROM games

-- SELECT PI()

-- SELECT ABS(-220)

-- SELECT FLOOR(2.33)

-- SELECT POW(2, 3)

-- SELECT RAND(2) * 100 -- give me the random number between 1 and 100

-- SELECT ROUND(3.1415, 6)

-- SELECT SIGN(-10) -- RETURN -1

-- SELECT DATE_ADD(NOW(), INTERVAL 56 days)

-- SELECT CONVERT(date, 'yy/mm/dd', 103)

-- SELECT DATEDIFF('2015-10-30', '2015-12-30') -- RETURNS DIFFERENCES IN DAYS, THERE IS NO OTHER FUNCTIONALITY

-- SELECT DAYNAME('2015-10-30') -- RETURNS DAY OF WEEK IN WHANTED DATE

-- SELECT IFNULL(middle_name, 'Nqma takuv') FROM employees -- if the value of the column is NULL replace it with Nqma takuv

-- HOMEWORK
-- TASK_1
/* SELECT first_name, last_name FROM employees
	WHERE LEFT(first_name, 2) = 'SA' 
	
-- TASK_2
SELECT first_name, last_name
  FROM employees
 WHERE last_name LIKE '%ei%'; 
 
-- TASK_3
SELECT first_name
  FROM employees
 WHERE department_id = 3
    OR department_id = 10
   AND YEAR(hire_date) BETWEEN 1995 AND 2005; 
   
-- TASK_4
SELECT first_name, last_name
  FROM employees AS e
 WHERE e.job_title NOT LIKE '%engineer%'; 
 
-- TASK_5
SELECT name
  FROM towns
 WHERE CHAR_LENGTH(name) BETWEEN 5 AND 6
 ORDER BY name; 
 
-- TASK_6
SELECT *
  FROM towns
 WHERE towns.name LIKE 'm%' 
    OR towns.name LIKE 'k%' 
	 OR towns.name LIKE 'b%' 
	 OR towns.name LIKE 'e%'
 ORDER BY name; 
 
-- TASK_7
SELECT *
  FROM towns
 WHERE towns.name NOT LIKE 'R%' 
   AND towns.name NOT LIKE 'B%' 
	AND towns.name NOT LIKE 'D%'
 ORDER BY name; 
 
-- TASK_8
CREATE VIEW v_employees_hired_after_2000 AS
SELECT first_name, last_name
  FROM employees AS e
 WHERE YEAR(e.hire_date) > 2000; 
 
-- TASK_9
SELECT first_name, last_name
  FROM employees 
 WHERE CHAR_LENGTH(last_name) = 5; 
 
-- TASK_10
SELECT country_name, iso_code
  FROM countries
 WHERE country_name LIKE ('%a%a%a%')
 ORDER BY iso_code; 
 
-- TASK_11
SELECT peak_name, river_name, LOWER(CONCAT(peak_name, SUBSTRING(river_name, 2))) AS mix
  FROM peaks, rivers
 WHERE STRCMP(RIGHT(peaks.peak_name, 1), LEFT(rivers.river_name, 1)) = 0
 ORDER BY mix; 
 
-- TASK_12
SELECT name, DATE_FORMAT(`start`, '%Y-%m-%d') AS`start`
  FROM games
 WHERE YEAR(`start`) IN (2011, 2012)
 ORDER BY `start`, 
 			  name
 LIMIT 50; 
 
-- TASK_13
SELECT user_name, SUBSTRING(email, LOCATE('@', email) + 1, CHAR_LENGTH(email)) AS email_provider
  FROM users
  ORDER BY email_provider, user_name;
  
-- TASK_14
SELECT user_name, ip_address
  FROM users
 WHERE ip_address LIKE '___.1%.%.___'
 ORDER BY user_name; 
 
-- TASK_15
SELECT name, 
  CASE
  		WHEN HOUR(`start`) < 12 THEN 'Morning'
  		WHEN HOUR(`start`) >= 18 THEN 'Evening'
  		ELSE 'Afternoon'
  	END AS part_of_the_day,
  CASE
  		WHEN duration <= 3 THEN 'Extra short'
  		WHEN duration BETWEEN 4 AND 6 THEN 'Short'
  		WHEN duration > 6 THEN 'Long'
  		ELSE 'Extra long'
  	END AS duration
  FROM games
  ORDER BY name, 
   CASE
  		WHEN duration <= 3 THEN 'Extra short'
  		WHEN duration BETWEEN 4 AND 6 THEN 'Short'
  		WHEN duration > 6 THEN 'Long'
  		ELSE 'Extra long'
	 END, 
	CASE
  	WHEN HOUR(`start`) < 12 THEN 'Morning'
  		WHEN HOUR(`start`) >= 18 THEN 'Evening'
  		ELSE 'Afternoon'
  	END; */
  	
-- TASK_16


	
	
	

	
