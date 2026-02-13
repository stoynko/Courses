/*In this stage, combine everything you have done so far to generate a payroll report. Although you have only been provided
  with the time logs for employees in the City Ethics Commissions department, your procedure should work for any department:
    ┌──────────────────┬──────────────┐
    │ Full names       │ Hours worked │
    ├──────────────────┼──────────────┤
    │ Dixie Herda      │ 2095         │
    ├──────────────────┼──────────────┤
    │ Stephen West     │ 2091         │
    ├──────────────────┼──────────────┤
    │ Philip Wilson    │ 2160         │
    ├──────────────────┼──────────────┤
    │ Robin Walker     │ 2083         │
    ├──────────────────┼──────────────┤
    │ Antoinette Matava│ 2115         │
    ├──────────────────┼──────────────┤
    │ Courtney Walker  │ 2206         │
    ├──────────────────┼──────────────┤
    │ Gladys Bosch     │ 900          │
    └──────────────────┴──────────────┘
Let's discuss the columns. The base pay is the product of the regular hours for a typical work year and the hourly rate.
The total pay is the sum of the base pay and overtime pay. The net income is derived by deducting the tax owed from the total pay.

Your task is to generate the payroll report. You might need to use the previous functions you created to generate overtime pay and tax owed in the earlier stages.
You might also need to create a new function for this stage that will output the total hours worked by an employee.
There are several ways to do it, using the CASE statement inside the function is just one of the ways.

Objectives:
    • Create a procedure called PayrollReport that takes in the name of any department.
    • Output the full_names, base_pay, overtime_pay, total_pay, tax_owed, and net_income.
    • Order the table with the net_income column in descending order.
    • Call the PayrollReport procedure on the City Ethics Commission department. */

DELIMITER $$
CREATE PROCEDURE PayrollReport(IN department_name VARCHAR(45))
BEGIN
    DECLARE normal_hours INT DEFAULT 2080;
    DECLARE max_overtime_pay FLOAT DEFAULT 6000;

    SELECT
        CONCAT(e.first_name, ' ', e.last_name) AS full_names,
        j.hourly_rate * normal_hours AS base_pay,
        ROUND(GREATEST(0, LEAST(HoursWorked(e.first_name, e.last_name) - normal_hours, max_overtime_pay / (j.hourly_rate * 1.5))) * j.hourly_rate * 1.5, 2) AS overtime_pay,
        ROUND(j.hourly_rate * normal_hours + GREATEST(0, LEAST(HoursWorked(e.first_name, e.last_name) - normal_hours, max_overtime_pay / (j.hourly_rate * 1.5))) * j.hourly_rate * 1.5, 2) AS total_pay,
        ROUND(TaxOwed(j.hourly_rate * normal_hours + GREATEST(0, LEAST(HoursWorked(e.first_name, e.last_name) - normal_hours, max_overtime_pay / (j.hourly_rate * 1.5))) * j.hourly_rate * 1.5), 2) AS tax_owed,
        ROUND((j.hourly_rate * normal_hours + GREATEST(0, LEAST(HoursWorked(e.first_name, e.last_name) - normal_hours, max_overtime_pay / (j.hourly_rate * 1.5))) * j.hourly_rate * 1.5 -
               TaxOwed( j.hourly_rate * normal_hours + GREATEST(0, LEAST(HoursWorked(e.first_name, e.last_name) - normal_hours, max_overtime_pay / (j.hourly_rate * 1.5))) * j.hourly_rate * 1.5)), 2) AS net_income
    FROM employees AS e
             JOIN jobs AS j ON e.job_id = j.id
             JOIN departments AS d ON e.department_id = d.id
    WHERE d.name = department_name
    ORDER BY net_income DESC;
END$$


CREATE FUNCTION HoursWorked(first_name VARCHAR(45), last_name VARCHAR(45)) RETURNS INT
    DETERMINISTIC
BEGIN
    RETURN CASE CONCAT(first_name, ' ', last_name)
               WHEN 'Dixie Herda' THEN 2095
               WHEN 'Stephen West' THEN 2091
               WHEN 'Philip Wilson' THEN 2160
               WHEN 'Robin Walker' THEN 2083
               WHEN 'Antoinette Matava' THEN 2115
               WHEN 'Courtney Walker' THEN 2206
               WHEN 'Gladys Bosch' THEN 900
               ELSE 2080
        END;
END$$


CREATE PROCEDURE EmployeeOvertimePay(IN first_name VARCHAR(45),
                                     last_name VARCHAR(45),
                                     total_hours INT,
                                     OUT overtime_pay FLOAT (19, 2))
BEGIN
    DECLARE hourly_rate FLOAT (19, 2);
    DECLARE adjusted_overtime_rate FLOAT (19, 2) DEFAULT 0;
    DECLARE overtime FLOAT(19, 2) DEFAULT 0;

    SELECT j.hourly_rate INTO hourly_rate
    FROM jobs AS j
             JOIN employees AS e ON e.job_id = j.id
    WHERE e.first_name = first_name AND e.last_name = last_name
    LIMIT 1;

    SET adjusted_overtime_rate = hourly_rate * 1.5;

    IF total_hours > 2080 THEN
        SET overtime = (total_hours - 2080) * adjusted_overtime_rate;
    END IF;
    IF overtime > 6000 THEN
        SET overtime = 6000;
    END IF;
    SET overtime_pay = overtime;
END$$
DELIMITER ;

CALL PayrollReport('City Ethics Commission');