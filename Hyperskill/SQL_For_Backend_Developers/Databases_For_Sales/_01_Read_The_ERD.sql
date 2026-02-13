/* Description:
Сreate a database to store manufacturers, products, sales, customers, employees, and inventory data.
With that goal in mind, we will create tables with the appropriate relations, attributes, and data types for our car dealership.

Objectives:
• Kindly review the entity-relationship diagram (ERD) for our sales database.

The manufacturers table contains the information about manufacturers of cars in our dealership.
The attributes of this table are the manufacturer_id, name, and country. The products table contains information describing the cars in our dealership.
You can view information such as the car model, price, horsepower, and fuel_efficiency. Customers want the best deals, and this information helps them decide.
You can find the current car inventory information on the inventory table; information on car sales is on the sales table.
Information about our customers and employees is stored in the customers and employees tables respectively.
Your task is to create the manufacturers, products, and inventory tables with the ERD's required attributes, data types, and relations.

Take note of the following:
    • There is a one-to-many identifying relationship between the products and inventory tables.
    • The product_id attribute in the inventory table is a FOREIGN KEY referenced to the products table.
    • The TINYINT datatype stores boolean values where 0 represents false, and 1 represents true.
    • Restrict the attributes of all the tables to NOT NULL except for attributes set as PRIMARY KEY.
    • AUTO_INCREMENT the attributes set as PRIMARY KEY except in the inventory table.
    • The dealership reorders a car from the manufacturer when the inventory quantity drops to two cars. */

CREATE TABLE IF NOT EXISTS manufacturers (
    manufacturer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    country VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    manufacturer_id INT NOT NULL,
    model VARCHAR(45) NOT NULL,
    price DECIMAL NOT NULL,
    horsepower INT NOT NULL,
    fuel_efficiency INT NOT NULL,
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (manufacturer_id)
);

CREATE TABLE IF NOT EXISTS inventory (
    product_id INT PRIMARY KEY,
    quantity INT NOT NULL,
    reorder_level INT NOT NULL DEFAULT 2,
    last_inventory_date DATE NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

CREATE TABLE IF NOT EXISTS employees (
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    position VARCHAR(45) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    address VARCHAR(45) NOT NULL,
    mobile VARCHAR(45) NOT NULL,
    is_active TINYINT NOT NULL
);

CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    city VARCHAR(45) NOT NULL,
    state VARCHAR(45) NOT NULL
);

CREATE TABLE sales (
    sale_id INT PRIMARY KEY,
    sale_date DATE NOT NULL,
    customer_id INT NOT NULL,
    product_id INT NOT NULL,
    employee_id INT NOT NULL,
    quantity INT NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

INSERT INTO manufacturers (manufacturer_id, name, country) VALUES
  (1, 'Toyota', 'Japan'), (2, 'General Motors', 'United States');

INSERT INTO products (product_id, manufacturer_id, model, price, horsepower, fuel_efficiency) VALUES
  (1, 1, 'Camry', 28000, 203, 70), (2, 1, 'Corrola', 22000, 175, 75),
  (3, 2, 'Silverado', 41250, 285, 73), (4, 2, 'Camaro', 30000, 340, 80);

INSERT INTO employees (employee_id, first_name, last_name, position, salary, address, mobile, is_active) VALUES
  (1, 'Emily', 'Dan', 'Sales Associate', 50000, '789 Maple St', '555-1234', 1),
  (2, 'Janeth', 'Kane', 'Sales Manager',   75000, '321 Elm St',   '555-5678', 1),
  (3, 'Sophia', 'Nguyen', 'Sales Associate',   55000, '21 Oak Ave',   '555-4321', 1);

INSERT INTO customers (customer_id, first_name, last_name, address, city, state) VALUES
  (1, 'John', 'Smith', '123 Main St', 'Anytown', 'CA'),
  (2, 'Sarah', 'Chen', '456 Oak Ave', 'Sometown', 'NY'),
  (3, 'Emma', 'Johnson', '789 Pine St', 'Sometown', 'CA'),
  (4, 'Liam', 'Lee', '234 Oak Ave', 'Anytown', 'NY'),
  (5, 'Ava', 'Garcia', '123 Main St', 'Sometown', 'TX'),
  (6, 'Noah', 'Kim', '456 Maple St', 'Othertown', 'CA'),
  (7, 'Olivia', 'Martinez', '789 Elm St', 'Othertown', 'NY'),
  (8, 'Michael', 'Williams', '567 Elm St', 'Anytown', 'CA'),
  (9, 'Emily', 'Chen', '789 Oak Ave', 'Sometown', 'NY'),
  (10, 'Christopher', 'Gonzalez', '123 Pine St', 'Othertown', 'TX'),
  (11, 'Avery', 'Robinson', '456 Main St', 'Anytown', 'CA'),
  (12, 'Noah', 'Lopez', '789 Maple St', 'Sometown', 'NY'),
  (13, 'Emma', 'Baker', '123 Oak Ave', 'Othertown', 'TX'),
  (14, 'William', 'Garcia', '456 Pine St', 'Sometown', 'CA'),
  (15, 'Sofia', 'Kim', '789 Main St', 'Anytown', 'NY'),
  (16, 'Jacob', 'Nguyen', '123 Elm St', 'Othertown', 'TX'),
  (17, 'Ella', 'Rodriguez', '456 Maple St', 'Sometown', 'CA');

INSERT INTO inventory (product_id, quantity, reorder_level, last_inventory_date) VALUES
  (1, 50, 2, '2023-04-30'), (2, 30, 2, '2023-04-30'),
  (3, 25, 2, '2023-04-30'), (4, 30, 2, '2023-04-30');