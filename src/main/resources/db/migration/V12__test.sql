DELIMITER $$

CREATE PROCEDURE findProductsByPrice(
    IN p_minPrice DECIMAL(10,2),
    IN p_maxPrice DECIMAL(10,2)
)
BEGIN
SELECT id, name,price, category_id
FROM products
WHERE price BETWEEN p_minPrice AND p_maxPrice
ORDER BY name;
END $$

DELIMITER ;