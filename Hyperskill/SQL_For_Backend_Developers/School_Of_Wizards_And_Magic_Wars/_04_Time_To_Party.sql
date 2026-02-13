/*
    • Description:
We've done it! The attackers vanished. Let's hold a party at the school to commemorate this.
The top winners of the department will be awarded. For this, they need your help again.
You have to find the best students in the departments.

    • Objectives:
You have to find the best students. The course averages of these students are above 4.5 points.
The result should be in ascending order by name, with their names and which department they are in.*/

SELECT s.name, d.department_name
FROM Students AS s
         JOIN Student_Subject AS ss ON s.student_id = ss.student_id
         JOIN Department AS d ON d.department_id = s.department_id
GROUP BY s.student_id
HAVING AVG(ss.result) > 4.5
ORDER BY s.name;
