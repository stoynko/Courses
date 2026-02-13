/*Description
The car dealership is a capital-intensive business requiring substantial inventory investment. The sales manager can use this knowledge to make
definable choices regarding the quantities of cars to carry for each car model and the level at which to restock them. Following the implementation
of the sales incentive program, the sales manager wants to continue the innovations to secure the product mix and maximize profits.

Suppose we have equivalent profit margins for each car model and similar levels of customer satisfaction.
In this scenario, the sales manager intends to use the sales inventory ratio to determine which car models to select.
The sales inventory ratio is calculated by dividing the total sales per car model by its corresponding inventory.
The manager will raise the percentage of models with a high sales inventory ratio and their reorder level.

Objectives
    • Generate a table that shows the model, price, total_sales_per_model, inventory_per_model, and sales_inventory_ratio */

SELECT p.model, p.price, SUM(total_price) AS 'total_sale_per_model',
       i.quantity AS 'inventory_per_model',
       SUM(total_price) / i.quantity AS 'sales_inventory_ratio'
FROM products AS p
JOIN sales AS s on p.product_id = s.product_id
JOIN inventory AS i on p.product_id = i.product_id
GROUP BY p.model, p.price, i.quantity
ORDER BY sales_inventory_ratio DESC;