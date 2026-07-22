CREATE TABLE vaccine_inventory_uc30 (
    id INT PRIMARY KEY,
    region VARCHAR(50) NOT NULL,
    available_doses INT NOT NULL
);

INSERT INTO vaccine_inventory_uc30 (id, region, available_doses) VALUES
(1, 'North', 5000),
(2, 'South', 3000);

-- Session 1: Cause Non-Repeatable Read under READ COMMITTED
SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
START TRANSACTION;

SELECT available_doses FROM vaccine_inventory_uc30 WHERE id = 1;

-- Session 2 (Concurrent execution simulated inline):
UPDATE vaccine_inventory_uc30 SET available_doses = 4000 WHERE id = 1;

-- Session 1: Re-query inside same transaction returns a modified value
SELECT available_doses FROM vaccine_inventory_uc30 WHERE id = 1;
COMMIT;

-- Prevention: Use REPEATABLE READ to guarantee row stability
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
START TRANSACTION;

SELECT available_doses FROM vaccine_inventory_uc30 WHERE id = 1;

-- Session 2 (Concurrent execution):
UPDATE vaccine_inventory_uc30 SET available_doses = 2000 WHERE id = 1;

-- Session 1: Snapshot isolation maintains original read state
SELECT available_doses FROM vaccine_inventory_uc30 WHERE id = 1;
COMMIT;