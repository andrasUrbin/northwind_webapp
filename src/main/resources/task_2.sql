SELECT company_name AS Company, 
COUNT(*) AS NumberOfProducts 
FROM suppliers 
INNER JOIN products
ON suppliers.supplier_id = products.supplier_id
GROUP BY company_name 
ORDER BY numberofproducts DESC;
