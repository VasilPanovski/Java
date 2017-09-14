-- TASK_12
/* SELECT e.employee_id, e.first_name, p.name
  FROM employees AS e
  LEFT OUTER JOIN employees_projects AS ep
    ON e.employee_id = ep.employee_id
 RIGHT OUTER JOIN projects AS p
    ON ep.project_id = p.project_id
  WHERE p.start_date > '2002-08-13'
    AND p.end_date IS NULL
  ORDER BY e.employee_id
  LIMIT 5; 
  
-- TASK_13
 SELECT e.employee_id, e.first_name, p.name AS project_name
  FROM employees AS e
  INNER JOIN employees_projects AS ep
    ON e.employee_id = ep.employee_id
 LEFT OUTER JOIN projects AS p
    ON ep.project_id = p.project_id
   AND YEAR(p.start_date) < 2005
  WHERE e.employee_id = 24 
  
-- TASK_14
SELECT e.employee_id, e.first_name, em.employee_id AS manager_id, em.first_name AS manager_name
  FROM employees AS e
 INNER JOIN employees AS em
    ON em.employee_id = e.manager_id
 WHERE e.manager_id IN (3, 7)
 ORDER BY e.employee_id; 
 
-- TASK_15
SELECT mc.country_code, m.mountain_range, p.peak_name, p.elevation
  FROM peaks AS p
 INNER JOIN mountains AS m
    ON m.id = p.mountain_id
 INNER JOIN mountains_countries AS mc
    ON m.id = mc.mountain_id
 WHERE mc.country_code = 'BG'
   AND p.elevation > 2835
 ORDER BY p.elevation DESC; 
 
-- TASK_16
SELECT mc.country_code, COUNT(m.mountain_range) AS mauntan_ranges
  FROM mountains_countries AS mc
  LEFT OUTER JOIN mountains AS m
    ON mc.mountain_id = m.id
  WHERE mc.country_code IN ('BG', 'RU', 'US')
  GROUP BY mc.country_code */
  
-- TASK_17
SELECT c.country_name, r.river_name
  FROM countries AS c
  JOIN countries_rivers AS cr
    ON c.country_code = cr.country_code
  LEFT JOIN rivers AS r
    ON r.id = cr.river_id 
 WHERE c.continent_code = 'AF'
 ORDER BY c.country_name
 LIMIT 5
  