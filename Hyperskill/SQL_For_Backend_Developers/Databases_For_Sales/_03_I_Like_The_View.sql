/*Description:
Since the opening of the car dealership, the sales team has performed impressively, and in anticipation of increased sales,
the sales manager has hired a new sales associate. Recently, the team has sold more cars, and as a result,
the sales manager is interested in optimizing the product mix of the dealership.
The sales manager requires data on the number of cars sold for each brand to achieve this.

As our database grows, the time to execute the query that outputs this information to the sales manager increases.
The sales manager also finds it frustrating to connect the tables required to get this information over the ERD.
Since it is a query the sales manager runs very often, the manager would like this process to be simplified.

Objectives
    • Create the composite index, customer_sales_product, which will speed up the query execution
    • Create a view, sales_summary, which outputs the model and total_sold attributes
    • Run the sales_summary view to output its table */

CREATE INDEX customer_sales_product ON sales (customer_id, product_id);

CREATE VIEW sales_summary AS
    SELECT p.model AS 'model', SUM(s.quantity) AS 'total_sold' FROM sales AS s
    JOIN products AS p ON p.product_id = s.product_id
GROUP BY model
ORDER BY total_sold DESC;

SELECT * FROM sales_summary;