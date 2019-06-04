SELECT company_name, ARRAY_AGG(orders.order_id)
FROM customers
FULL JOIN orders
ON customers.customer_id = orders.customer_id
GROUP BY company_name
ORDER BY company_name ASC;
