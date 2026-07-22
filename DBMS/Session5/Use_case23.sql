CREATE TABLE covid_cases_uc23 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed INT DEFAULT 0,
    deaths INT DEFAULT 0,
    recovered INT DEFAULT 0,
    CONSTRAINT unique_country_date UNIQUE (country, report_date)
);

INSERT INTO covid_cases_uc23 (country, report_date, confirmed, deaths, recovered) VALUES
('Brazil', '2023-10-01', 40000, 1000, 35000);

DELIMITER //

CREATE PROCEDURE UpdateCovidStats(
    IN p_country VARCHAR(100),
    IN p_date DATE,
    IN p_confirmed INT,
    IN p_deaths INT,
    IN p_recovered INT
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;

    START TRANSACTION;

    UPDATE covid_cases_uc23
    SET 
        confirmed = p_confirmed,
        deaths = p_deaths,
        recovered = p_recovered
    WHERE country = p_country AND report_date = p_date;

    IF ROW_COUNT() = 0 THEN
        INSERT INTO covid_cases_uc23 (country, report_date, confirmed, deaths, recovered)
        VALUES (p_country, p_date, p_confirmed, p_deaths, p_recovered);
    END IF;

    COMMIT;
END //

DELIMITER ;