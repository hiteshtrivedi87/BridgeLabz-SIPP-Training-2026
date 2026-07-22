CREATE TABLE vaccine_batches_uc29 (
    batch_id INT PRIMARY KEY,
    vaccine_name VARCHAR(50) NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0)
);

CREATE TABLE vaccine_allocations_uc29 (
    allocation_id INT AUTO_INCREMENT PRIMARY KEY,
    batch_id INT NOT NULL,
    country VARCHAR(100) NOT NULL,
    allocated_doses INT NOT NULL,
    FOREIGN KEY (batch_id) REFERENCES vaccine_batches_uc29(batch_id)
);

DELIMITER //

CREATE PROCEDURE DistributeVaccinesAtomic(
    IN p_batch_id INT,
    IN p_vaccine_name VARCHAR(50),
    IN p_batch_quantity INT,
    IN p_country VARCHAR(100),
    IN p_allocated_doses INT
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;

    START TRANSACTION;

    INSERT INTO vaccine_batches_uc29 (batch_id, vaccine_name, quantity)
    VALUES (p_batch_id, p_vaccine_name, p_batch_quantity);

    INSERT INTO vaccine_allocations_uc29 (batch_id, country, allocated_doses)
    VALUES (p_batch_id, p_country, p_allocated_doses);

    COMMIT;
END //

DELIMITER ;

CALL DistributeVaccinesAtomic(101, 'Pfizer', 500000, 'USA', 100000);

CALL DistributeVaccinesAtomic(102, 'Moderna', -50, 'Canada', 20000);