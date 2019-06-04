SELECT suppliers.company_name, products.product_name, ROUND(products.unit_price::NUMERIC, 1)
FROM products
JOIN suppliers
	ON suppliers.supplier_id = products.supplier_id
JOIN (SELECT products.supplier_id, MAX(products.unit_price) AS max_unit FROM products
GROUP BY products.supplier_id) AS temp_values ON products.supplier_id = temp_values.supplier_id AND products.unit_price = temp_values.max_unit
ORDER BY unit_price DESC;
