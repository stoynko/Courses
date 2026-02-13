CREATE TABLE "Department" (
	department_id INTEGER,
	department_name text,
	PRIMARY KEY ("department_id")
);

CREATE TABLE "Subject" (
	subject_id INTEGER,
	subject_name TEXT,
	required NUMERIC,
	PRIMARY KEY ("subject_id")
);

CREATE TABLE "Department_Subject" (
	dep_sub_id INTEGER,
	department_id INTEGER,
	subject_id INTEGER,
	PRIMARY KEY ("dep_sub_id")
);

CREATE TABLE "Student_Subject" (
	enr_sub_id INTEGER,
	student_id INTEGER,
	subject_id INTEGER,
	semester INTEGER,
	result REAL,
	PRIMARY KEY ("enr_sub_id")
);

CREATE TABLE "Students" (
	student_id INTEGER,
	name TEXT,
	grade INTEGER,
	department_id INTEGER,
	PRIMARY KEY("student_id")
);

CREATE TABLE "Achievement" (
	achievement_id INTEGER,
	achievement_name TEXT,
	bonus INTEGER,
	PRIMARY KEY("achievement_id")
);

CREATE TABLE "Student_Achievement" (
	student_ach_id INTEGER,
	student_id INTEGER,
	achievement_id INTEGER,
	PRIMARY KEY("student_ach_id")
);

INSERT INTO Department (department_id, department_name) VALUES (1, 'Tigers'); INSERT INTO Department (department_id, department_name) VALUES (2, 'Eagles');
INSERT INTO Department (department_id, department_name) VALUES (3, 'Sharks'); INSERT INTO Department (department_id, department_name) VALUES (4, 'Snakes');
INSERT INTO Subject (subject_id, subject_name, required) VALUES (1, 'Transfiguration', 1); INSERT INTO Subject (subject_id, subject_name, required) VALUES (2, 'Defence Against the Dark Arts', 1);
INSERT INTO Subject (subject_id, subject_name, required) VALUES (3, 'Charms', 1); INSERT INTO Subject (subject_id, subject_name, required) VALUES (4, 'Potions', 1);
INSERT INTO Subject (subject_id, subject_name, required) VALUES (5, 'Astronomy', 1); INSERT INTO Subject (subject_id, subject_name, required) VALUES (6, 'Flying', 1);
INSERT INTO Subject (subject_id, subject_name, required) VALUES (7, 'History of Magic', 1); INSERT INTO Subject (subject_id, subject_name, required) VALUES (8, 'Herbology', 1);
INSERT INTO Subject (subject_id, subject_name, required) VALUES (9, 'Arithmancy', 0); INSERT INTO Subject (subject_id, subject_name, required) VALUES (10, 'Divination', 0);
INSERT INTO Subject (subject_id, subject_name, required) VALUES (11, 'Study of Ancient Runes', 0); INSERT INTO Subject (subject_id, subject_name, required) VALUES (12, 'Muggle Studies', 0);
INSERT INTO Subject (subject_id, subject_name, required) VALUES (13, 'Alchemy', 0); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (1, 1, 1);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (2, 1, 2); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (3, 1, 3);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (4, 1, 4); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (5, 1, 5);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (6, 1, 6); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (7, 1, 7);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (8, 1, 9); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (9, 1, 10);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (10, 1, 11); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (11, 1, 12);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (12, 1, 13); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (13, 2, 1);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (14, 2, 2); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (15, 2, 3);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (16, 2, 4); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (17, 2, 5);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (18, 2, 6); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (19, 2, 7);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (20, 2, 8); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (21, 2, 10);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (22, 2, 11); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (23, 2, 12);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (24, 2, 13); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (25, 3, 1);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (26, 3, 2); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (27, 3, 3);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (28, 3, 4); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (29, 3, 5);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (30, 3, 6); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (31, 3, 7);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (32, 3, 8); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (33, 3, 9);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (34, 3, 10); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (35, 3, 12);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (36, 3, 13); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (37, 4, 1);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (38, 4, 2); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (39, 4, 3);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (40, 4, 4); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (41, 4, 5);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (42, 4, 6); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (43, 4, 7);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (44, 4, 9); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (45, 4, 10);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (46, 4, 11); INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (47, 4, 12);
INSERT INTO Department_Subject (dep_sub_id, department_id, subject_id) VALUES (48, 4, 13); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (1, 1, 1, 1, 3.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (2, 1, 2, 1, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (3, 1, 3, 1, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (4, 1, 4, 1, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (5, 2, 3, 2, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (6, 2, 4, 2, 3.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (7, 2, 5, 2, 3.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (8, 3, 3, 2, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (9, 3, 4, 2, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (10, 3, 5, 2, 3.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (11, 3, 6, 2, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (12, 4, 3, 2, 3.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (13, 4, 4, 2, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (14, 4, 5, 2, 3.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (15, 5, 3, 2, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (16, 5, 4, 2, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (17, 5, 5, 2, 3.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (18, 6, 6, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (19, 6, 7, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (20, 6, 9, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (21, 6, 12, 3, 3.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (22, 7, 6, 3, 5.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (23, 7, 7, 3, 5.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (24, 7, 9, 3, 5.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (25, 8, 6, 3, 5.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (26, 8, 7, 3, 5.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (27, 8, 9, 3, 5.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (28, 8, 12, 3, 5.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (29, 9, 6, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (30, 9, 7, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (31, 9, 9, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (32, 10, 6, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (33, 10, 7, 3, 5.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (34, 11, 6, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (35, 11, 7, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (36, 11, 9, 3, 3.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (37, 12, 6, 3, 5.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (38, 12, 7, 3, 5.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (39, 12, 9, 3, 5.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (40, 12, 12, 3, 5.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (41, 13, 6, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (42, 13, 7, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (43, 13, 9, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (44, 14, 6, 3, 5.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (45, 14, 7, 3, 5.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (46, 14, 9, 3, 5.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (47, 15, 6, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (48, 15, 7, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (49, 15, 10, 3, 3.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (50, 16, 6, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (51, 16, 7, 3, 5.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (52, 16, 10, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (53, 17, 6, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (54, 17, 7, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (55, 17, 10, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (56, 18, 6, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (57, 18, 7, 3, 5.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (58, 18, 10, 3, 5.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (59, 19, 6, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (60, 19, 7, 3, 3.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (61, 19, 10, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (62, 20, 6, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (63, 20, 7, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (64, 20, 10, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (65, 21, 6, 3, 3.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (66, 21, 8, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (67, 22, 6, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (68, 22, 8, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (69, 22, 10, 3, 3.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (70, 23, 6, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (71, 23, 7, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (72, 23, 9, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (73, 24, 6, 3, 5.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (74, 24, 7, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (75, 24, 9, 3, 5.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (76, 25, 6, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (77, 25, 7, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (78, 25, 9, 3, 5.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (79, 26, 6, 3, 3.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (80, 26, 7, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (81, 26, 9, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (82, 27, 6, 3, 5.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (83, 27, 7, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (84, 27, 9, 3, 3.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (85, 28, 6, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (86, 28, 7, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (87, 28, 9, 3, 3.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (88, 29, 6, 3, 5.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (89, 29, 7, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (90, 29, 9, 3, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (91, 30, 6, 3, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (92, 30, 7, 3, 3.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (93, 30, 9, 3, 3.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (94, 31, 6, 4, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (95, 31, 7, 4, 5.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (96, 31, 11, 4, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (97, 31, 12, 4, 5.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (98, 32, 6, 4, 5.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (99, 32, 7, 4, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (100, 32, 11, 4, 4.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (101, 33, 12, 4, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (102, 34, 11, 6, 3.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (103, 34, 13, 6, 4.0);
INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (104, 35, 12, 7, 3.0); INSERT INTO Student_Subject (enr_sub_id, student_id, subject_id, semester, result) VALUES (105, 35, 13, 7, 4.0);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (1, 'Dolli Wilcher', 1, 1); INSERT INTO Students (student_id, name, grade, department_id) VALUES (2, 'Anne-corinne Ellsom', 2, 1);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (3, 'Caterina Siemens', 2, 1); INSERT INTO Students (student_id, name, grade, department_id) VALUES (4, 'Lisa Rosander', 2, 3);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (5, 'Tawsha MacLeod', 2, 4); INSERT INTO Students (student_id, name, grade, department_id) VALUES (6, 'Derward Sallery', 3, 1);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (7, 'Nessa Bonallick', 3, 1); INSERT INTO Students (student_id, name, grade, department_id) VALUES (8, 'Tallulah Oliveto', 3, 1);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (9, 'Tessi Braddick', 3, 1); INSERT INTO Students (student_id, name, grade, department_id) VALUES (10, 'Raffaello Asche', 3, 1);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (11, 'Barrett Orteaux', 3, 1); INSERT INTO Students (student_id, name, grade, department_id) VALUES (12, 'Lee Fedorchenko', 3, 1);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (13, 'Cindy Ackers', 3, 1); INSERT INTO Students (student_id, name, grade, department_id) VALUES (14, 'Kendricks Stoven', 3, 1);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (15, 'Creigh De Leek', 3, 2); INSERT INTO Students (student_id, name, grade, department_id) VALUES (16, 'Eolanda Haslewood', 3, 2);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (17, 'Virgina Brokenshire', 3, 2); INSERT INTO Students (student_id, name, grade, department_id) VALUES (18, 'Wally Griffe', 3, 2);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (19, 'Verene Reeveley', 3, 2); INSERT INTO Students (student_id, name, grade, department_id) VALUES (20, 'Lev Membry', 3, 3);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (21, 'Egan de Amaya', 3, 3); INSERT INTO Students (student_id, name, grade, department_id) VALUES (22, 'Sharl Farrants', 3, 3);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (23, 'Ddene Hukin', 3, 4); INSERT INTO Students (student_id, name, grade, department_id) VALUES (24, 'Saudra Ducker', 3, 4);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (25, 'Karie Wytchard', 3, 4); INSERT INTO Students (student_id, name, grade, department_id) VALUES (26, 'Wylma Bisiker', 3, 4);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (27, 'Theda Nigh', 3, 4); INSERT INTO Students (student_id, name, grade, department_id) VALUES (28, 'Harrie Laird-Craig', 3, 4);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (29, 'Natale Bellas', 3, 4); INSERT INTO Students (student_id, name, grade, department_id) VALUES (30, 'Leanor Atterley', 3, 4);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (31, 'Thoma Altofts', 4, 1); INSERT INTO Students (student_id, name, grade, department_id) VALUES (32, 'Scarlet Bohman', 4, 1);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (33, 'Stanislas Yurocjhin', 4, 2); INSERT INTO Students (student_id, name, grade, department_id) VALUES (34, 'Tobe Antonoczyk', 6, 2);
INSERT INTO Students (student_id, name, grade, department_id) VALUES (35, 'Berna Mille', 7, 3); INSERT INTO Achievement (achievement_id, achievement_name, bonus) VALUES (1, 'Ball Catch Awards', 4);
INSERT INTO Achievement (achievement_id, achievement_name, bonus) VALUES (2, 'Distance Awards', 1); INSERT INTO Achievement (achievement_id, achievement_name, bonus) VALUES (3, 'Special Award for Services to the School', 5);
INSERT INTO Achievement (achievement_id, achievement_name, bonus) VALUES (4, 'First Place Award', 2); INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (1, 1, 2);
INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (2, 2, 2); INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (3, 3, 2);
INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (4, 4, 2); INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (5, 9, 2);
INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (6, 11, 1); INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (7, 11, 2);
INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (8, 12, 1); INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (9, 12, 4);
INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (10, 14, 2); INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (11, 18, 2);
INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (12, 24, 4); INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (13, 25, 4);
INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (14, 28, 2); INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (15, 29, 2);
INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (16, 32, 1); INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (17, 33, 3);
INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (18, 35, 4); INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (19, 25, 2);
INSERT INTO Student_Achievement (student_ach_id, student_id, achievement_id) VALUES (20, 11, 4);
