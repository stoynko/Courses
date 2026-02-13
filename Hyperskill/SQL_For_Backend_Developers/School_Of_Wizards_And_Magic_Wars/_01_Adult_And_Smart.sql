/*
    • Description:
We need students to help defend the school.
In this stage, find the 3rd-year students who have passed the courses of the semester with the best grades.

    • Objectives:
Find students who are in 3rd grade and have 5 points for all their courses.
  The output should consist of the student names only in alphabetical order. */

SELECT s.name
FROM Students AS s
         JOIN Student_Subject AS ss ON s.student_id = ss.student_id
WHERE s.grade = 3
GROUP BY name
HAVING AVG(result) = 5
ORDER BY name;