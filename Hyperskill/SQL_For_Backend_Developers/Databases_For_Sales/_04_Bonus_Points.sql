/*The sales manager is satisfied with sales; 24 were sold in the last couple of days.
To appreciate the commitment, the manager intends to implement a sales incentive program based on the total sales of each associate in comparison to the total sales for the month:
 ┌─────────────────┬───────────────┐
 │ percent_revenue │ employee_bonus│
 ├─────────────────┼───────────────┤
 │ Less than 5     │ 0             │
 ├─────────────────┼───────────────┤
 │ 5 – 10          │ 2,000         │
 ├─────────────────┼───────────────┤
 │ 10 – 20         │ 5,000         │
 ├─────────────────┼───────────────┤
 │ 20 – 30         │ 10,000        │
 ├─────────────────┼───────────────┤
 │ 30 – 40         │ 15,000        │
 ├─────────────────┼───────────────┤
 │ Greater than 40 │ 25,000        │
 └─────────────────┴───────────────┘
Objectives:
    • Generate a table that shows the employee_name, position, month_year, and employee_bonus. */

DELIMITER $$
CREATE FUNCTION calculate_bonus(employee_id INT, month VARCHAR(10)) RETURNS INT
    DETERMINISTIC
    BEGIN
        DECLARE monthly_revenue FLOAT (19, 2) DEFAULT 0;
        DECLARE associate_revenue_percentage FLOAT (19, 2) DEFAULT 0;
        DECLARE bonus_amount INT DEFAULT 0;

        SELECT SUM(s.total_price) INTO monthly_revenue
            FROM sales AS s
        WHERE DATE_FORMAT(s.sale_date, '%M') = month;

        IF monthly_revenue IS NULL OR monthly_revenue = 0 THEN
            SET associate_revenue_percentage = 0;
        ELSE
            SELECT (SUM(s.total_price) / monthly_revenue) * 100
            INTO associate_revenue_percentage
            FROM sales AS s
            WHERE s.employee_id = employee_id AND DATE_FORMAT(s.sale_date,'%M') = month;
        END IF;

        IF associate_revenue_percentage < 5 THEN
            SET bonus_amount = 0;
        ELSEIF associate_revenue_percentage BETWEEN 5 AND 10 THEN
            SET bonus_amount = 2000;
        ELSEIF associate_revenue_percentage BETWEEN 10 AND 20 THEN
            SET bonus_amount = 5000;
        ELSEIF associate_revenue_percentage BETWEEN 20 AND 30 THEN
            SET bonus_amount = 10000;
        ELSEIF associate_revenue_percentage BETWEEN 30 AND 40 THEN
            SET bonus_amount = 15000;
        ELSE
            SET bonus_amount = 25000;
        END IF;
        RETURN bonus_amount;
    END$$

DELIMITER ;

WITH bonus_overview AS (
SELECT CONCAT(e.first_name, ' ', e.last_name) AS 'employee_name',
       e.position AS 'position',
       CONCAT(DATE_FORMAT(s.sale_date, '%M'), ' ', DATE_FORMAT(s.sale_date, '%Y')) AS 'month_year',
        calculate_bonus(e.employee_id, 'May') AS 'employee_bonus'
FROM employees AS e
JOIN sales AS s on e.employee_id = s.employee_id
GROUP BY employee_name, position, month_year, employee_bonus
HAVING e.position = 'Sales Associate'
) SELECT * FROM bonus_overview;

-- Variation 02

WITH emp_monthly AS (
    SELECT
        s.employee_id,
        DATE_FORMAT(s.sale_date, '%Y-%m') AS month_year,
        SUM(s.total_price) AS emp_sales
    FROM
        sales AS s
    GROUP BY
        s.employee_id,
        DATE_FORMAT(s.sale_date, '%Y-%m')
),
     total_monthly AS (
         SELECT
             DATE_FORMAT(s.sale_date, '%Y-%m') AS month_year,
             SUM(s.total_price) AS total_sales
         FROM
             sales AS s
         GROUP BY
             DATE_FORMAT(s.sale_date, '%Y-%m')
     )
SELECT
    CONCAT(e.first_name, ' ', e.last_name) AS 'employee_name',
    e.position,
    DATE_FORMAT(STR_TO_DATE(CONCAT(em.month_year, '-01'), '%Y-%m-%d'),'%M %Y') AS 'month_year',
    CASE
        WHEN (em.emp_sales * 100.0 / tm.total_sales) < 5 THEN 0
        WHEN (em.emp_sales * 100.0 / tm.total_sales) BETWEEN 5 AND 10 THEN 2000
        WHEN (em.emp_sales * 100.0 / tm.total_sales) BETWEEN 10 AND 20 THEN 5000
        WHEN (em.emp_sales * 100.0 / tm.total_sales) BETWEEN 20 AND 30 THEN 10000
        WHEN (em.emp_sales * 100.0 / tm.total_sales) BETWEEN 30 AND 40 THEN 15000
        WHEN (em.emp_sales * 100.0 / tm.total_sales) > 40 THEN 25000
        ELSE 0
        END AS employee_bonus
FROM
    emp_monthly AS em
        JOIN total_monthly AS tm
             ON em.month_year = tm.month_year
        JOIN employees AS e
             ON em.employee_id = e.employee_id
WHERE
    e.position = 'Sales Associate'
ORDER BY
    em.month_year,
    employee_name;