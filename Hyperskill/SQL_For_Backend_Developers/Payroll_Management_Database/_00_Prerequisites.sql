USE payroll;

CREATE TABLE departments (
        id INT PRIMARY KEY,
        name VARCHAR(45)
    );
CREATE TABLE jobs (
        id INT PRIMARY KEY,
        title VARCHAR(45),
        type VARCHAR(45),
        hourly_rate FLOAT(5,2)
    );
CREATE TABLE employees (
        id INT PRIMARY KEY,
        first_name VARCHAR(45),
        last_name VARCHAR(45),
        department_id INT,
        job_id INT,
        date_employed DATE,
        FOREIGN KEY (department_id) REFERENCES departments(id),
        FOREIGN KEY (job_id) REFERENCES jobs(id)
    );
CREATE TABLE insurance_benefits (
        id INT PRIMARY KEY,
        job_id INT,
        annual_insurance FLOAT(7,2),
        FOREIGN KEY (job_id) REFERENCES jobs(id)
    );
INSERT INTO departments (id, name) VALUES (100, 'City Ethics Commission'); INSERT INTO departments (id, name) VALUES (200, 'Emergency Management');
INSERT INTO departments (id, name) VALUES (300, 'Office of Finance');

INSERT INTO jobs (id, title, type, hourly_rate) VALUES (10, 'Tax Renewal Assistant I', 'Part Time', 15.05); INSERT INTO jobs (id, title, type, hourly_rate) VALUES (20, 'Administrative Intern', 'Part Time', 18.88);
INSERT INTO jobs (id, title, type, hourly_rate) VALUES (30, 'Project Assistant', 'Part Time', 22.01); INSERT INTO jobs (id, title, type, hourly_rate) VALUES (40, 'Management Assistant', 'Full Time', 32.18);
INSERT INTO jobs (id, title, type, hourly_rate) VALUES (50, 'Management Analyst I', 'Full Time', 35.37); INSERT INTO jobs (id, title, type, hourly_rate) VALUES (60, 'Senior Accountant II', 'Full Time', 42.29);
INSERT INTO jobs (id, title, type, hourly_rate) VALUES (70, 'Management Analyst II', 'Full Time', 42.87); INSERT INTO jobs (id, title, type, hourly_rate) VALUES (80, 'Senior Management Analyst I', 'Full Time', 49.29);
INSERT INTO jobs (id, title, type, hourly_rate) VALUES (90, 'Ethics Officer I', 'Full Time', 50.85); INSERT INTO jobs (id, title, type, hourly_rate) VALUES (100, 'Investment Officer II', 'Full Time', 61.76);
INSERT INTO jobs (id, title, type, hourly_rate) VALUES (110, 'Ethics Officer II', 'Full Time', 63.06);

INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (1, 'Elbert', 'Rich', 300, 100, '2019-10-01');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (2, 'Ray', 'Shipley', 300, 70, '2018-02-10');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (3, 'Daisy', 'Diamond', 300, 60, '2019-03-20');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (4, 'Lee', 'Durrett', 300, 50, '2018-04-15');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (5, 'Carol', 'Brown', 300, 10, '2020-05-09');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (6, 'Cheryl', 'Roman', 200, 80, '2018-01-15');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (7, 'Kevin', 'Byars', 200, 70, '2018-06-07');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (8, 'Andrew', 'Leake', 200, 70, '2019-05-05');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (9, 'Shaun', 'Thompson', 200, 40, '2020-02-17');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (10, 'Brandon', 'Hoffman', 200, 20, '2020-06-20');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (11, 'Philip', 'Wilson', 100, 110, '2020-08-09');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (12, 'Dixie', 'Herda', 100, 90, '2018-05-31');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (13, 'Stephen', 'West', 100, 90, '2019-09-15');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (14, 'Courtney', 'Walker', 100, 70, '2020-07-13');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (15, 'Robin', 'Walker', 100, 50, '2019-11-11');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (16, 'Antoinette', 'Matava', 100, 50, '2019-06-29');
INSERT INTO employees (id, first_name, last_name, department_id, job_id, date_employed) VALUES (17, 'Gladys', 'Bosch', 100, 30, '2020-08-16');
INSERT INTO insurance_benefits (id, job_id, annual_insurance) VALUES (1, 10, 0.0); INSERT INTO insurance_benefits (id, job_id, annual_insurance) VALUES (2, 20, 0.0);
INSERT INTO insurance_benefits (id, job_id, annual_insurance) VALUES (3, 30, 0.0); INSERT INTO insurance_benefits (id, job_id, annual_insurance) VALUES (4, 40, 9135.28);
INSERT INTO insurance_benefits (id, job_id, annual_insurance) VALUES (5, 50, 10385.29); INSERT INTO insurance_benefits (id, job_id, annual_insurance) VALUES (6, 60, 10998.64);
INSERT INTO insurance_benefits (id, job_id, annual_insurance) VALUES (7, 70, 11197.39); INSERT INTO insurance_benefits (id, job_id, annual_insurance) VALUES (8, 80, 11357.65);
INSERT INTO insurance_benefits (id, job_id, annual_insurance) VALUES (9, 90, 11689.54); INSERT INTO insurance_benefits (id, job_id, annual_insurance) VALUES (10, 100, 12368.28);
INSERT INTO insurance_benefits (id, job_id, annual_insurance) VALUES (11, 110, 12368.28);
