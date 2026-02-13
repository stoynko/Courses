/*
    • Description:
The student efforts were insufficient to defend the school, so we need more students.
  To find them, you need to consider the student achievements. They need you to calculate them!

    • Objectives:
Find four students with the most achievement points and list their names in alphabetical order with their scores.
The student's year is not critical. The output should have only the name and the bonus point column.
The output should be in descending order of the bonus point column. */

SELECT s.name AS name, SUM(a.bonus) AS bonus_points
FROM Students AS s
    JOIN Student_Achievement AS sa ON s.student_id = sa.student_id
    JOIN Achievement AS a ON sa.achievement_id = a.achievement_id
GROUP BY s.name
ORDER BY SUM(a.bonus) DESC
    LIMIT 4;