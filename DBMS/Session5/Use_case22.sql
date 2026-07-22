CREATE TABLE covid_cases_uc22 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed INT DEFAULT 0,
    deaths INT DEFAULT 0,
    recovered INT DEFAULT 0
);

INSERT INTO covid_cases_uc22 (country, report_date, confirmed, deaths, recovered) VALUES
('USA', '2023-10-01', 100000, 2500, 90000),
('Italy', '2023-10-01', 0, 0, 0);

DELIMITER //

CREATE FUNCTION CalculateMortalityRate(
    p_country VARCHAR(100),
    p_date DATE
)
RETURNS DECIMAL(5,2)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_mortality_rate DECIMAL(5,2);

    SELECT 
        CASE 
            WHEN confirmed IS NULL OR confirmed = 0 THEN 0.00
            ELSE ROUND((CAST(deaths AS DECIMAL(10,2)) / confirmed) * 100, 2)
        END INTO v_mortality_rate
    FROM covid_cases_uc22
    WHERE country = p_country AND report_date = p_date;

    RETURN COALESCE(v_mortality_rate, 0.00);
END //

DELIMITER ;