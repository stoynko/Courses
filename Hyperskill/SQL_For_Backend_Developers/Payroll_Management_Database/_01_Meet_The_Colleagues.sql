/* The departments table contains information about the various departments. The jobs table includes job titles, types, and hourly rate information.
The employees table contains information about the employees, and the insurance_benefits table contains information about the benefits associated with the jobs.

One of the most common operations on the database is to get a list of employees in a particular department.
Write the query to get this information from scratch whenever needed. As the number of departments in the database grows, this will take more time and effort.
You have been tasked to develop a more efficient way to retrieve this information from the database.

Objectives
• Create a procedure called GetEmployeesByDept that returns the first_name, last_name, and job_title for all employees in a given department.
• The output of the procedure is ordered by their first_name.
• Call the procedure for the "Office of Finance" department.*/

DELIMITER $$

CREATE PROCEDURE GetEmployeesByDept(IN department_name VARCHAR(45))
BEGIN
    SELECT e.first_name, e.last_name, j.title AS 'job_title'
    FROM employees AS e
             JOIN jobs AS j ON j.id = e.job_id
             JOIN departments AS d ON d.id = e.department_id
    WHERE d.name = department_name
    ORDER BY e.first_name;
END $$

DELIMITER ;

CALL GetEmployeesByDept('Office of Finance');