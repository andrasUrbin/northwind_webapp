SELECT products.product_name AS Product, 
suppliers.company_name AS Company 
FROM products 
inner JOIN suppliers 
	ON products.supplier_id=suppliers.supplier_id 
ORDER BY 1, 2;
