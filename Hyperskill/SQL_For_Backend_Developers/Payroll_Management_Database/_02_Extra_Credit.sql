/* Description:
Employees can work in the same department, but their pay may differ.
The daily amount is determined by their hourly rate and total work hours;
A working shift is eight hours, so there are 250 work days a typical year with an additional ten days of paid annual leave.

Sometimes, an employee must work beyond the standard hours to accomplish a task quickly.
Overtime rates are 50 percent above standard. The maximum overtime pay is 6000 annually to encourage a healthy work-life balance.
Employees are not penalized when they exceed this rate; they are not paid more.
Part-time employee work hours do not exceed the standard hours and do not qualify for overtime pay.

You have been tasked with finding a simple way to retrieve an employee's pay information from their time log.
You have been provided with the time log of the following employees:
    ┌───────────────┬──────────────┐
    │ Full names    │ Hours worked │
    ├───────────────┼──────────────┤
    │ Philip Wilson │     2160     │
    ├───────────────┼──────────────┤
    │ Daisy Diamond │     2100     │
    └───────────────┴──────────────┘
Objectives:
• Create the procedure called EmployeeTotalPay that takes in first_name, last_name, total_hours, normal_hours, overtime_rate, max_overtime_pay, and outputs total_pay.
• Output the total pay for Philip Wilson and Daisy Diamond.
HINT: create a function that uses IF-ELSEIF-ELSE to calculate overtime pay for an employee.*/

DELIMITER $$
CREATE PROCEDURE EmployeeTotalPay(IN first_name VARCHAR(45),
                                  last_name VARCHAR(45),
                                  total_hours INT,
                                  normal_hours INT,
                                  overtime_rate FLOAT(19, 2),
                                  max_overtime_pay FLOAT(19, 2),
                                  OUT total_pay FLOAT (19, 2))
BEGIN
    DECLARE yearly_normal_salary FLOAT (19, 2);
    DECLARE hour_rate FLOAT (19, 2);
    DECLARE adjusted_overtime_rate FLOAT (19, 2) DEFAULT 0;
    DECLARE overtime_pay FLOAT (19, 2) DEFAULT 0;

    SELECT j.hourly_rate INTO hour_rate
    FROM jobs AS j
             JOIN employees AS e ON e.job_id = j.id
    WHERE e.first_name = first_name AND e.last_name = last_name
    LIMIT 1;

    SET yearly_normal_salary = normal_hours * hour_rate;

    SET adjusted_overtime_rate = hour_rate * 1.5;

    IF total_hours > normal_hours THEN
        SET overtime_pay = (total_hours - normal_hours) * adjusted_overtime_rate;
    END IF;
    IF overtime_pay > max_overtime_pay THEN
        SET overtime_pay = max_overtime_pay;
    END IF;
    SET total_pay =  yearly_normal_salary + overtime_pay;
END$$
DELIMITER ;

CALL EmployeeTotalPay('Philip', 'Wilson', 2160, 260 * 8, 0, 6000, @resultA);
CALL EmployeeTotalPay('Daisy', 'Diamond', 2100, 260 * 8, 0, 6000, @resultB);
SELECT ROUND(@resultA, 1) AS "Philip Wilson", ROUND(@resultB, 1) AS "Daisy Diamond";