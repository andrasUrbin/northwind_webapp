SELECT company_name AS Company
FROM suppliers 
INNER JOIN products
ON suppliers.supplier_id = products.supplier_id
GROUP BY company_name 
HAVING COUNT(products.product_name) = 5
ORDER BY COUNT(products.product_name) DESC;
