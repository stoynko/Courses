/*
    • Description:
We've successfully repelled the attack, but the second wave is coming, and the students are tired.
We need new students! Of course, it is you who must find these students.

    • Objectives:
If the student's average is over 3.5 points for courses, output above average in the best column.
Otherwise, print below average. Order the results in alphabetical order by name. */

SELECT s.name, CASE
            WHEN AVG(result) > 3.5 THEN 'above average'
            ELSE 'below average'
            END AS 'best'
FROM Students AS s
    JOIN Student_Subject AS ss ON s.student_id = ss.student_id

GROUP BY s.name
ORDER BY s.name;

