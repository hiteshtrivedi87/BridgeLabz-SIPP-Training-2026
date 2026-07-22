CREATE TABLE covid_cases_uc21 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed INT DEFAULT 0,
    deaths INT DEFAULT 0,
    recovered INT DEFAULT 0
);

INSERT INTO covid_cases_uc21 (country, report_date, confirmed, deaths, recovered) VALUES
('USA', '2023-10-01', 100000, 1500, 90000),
('USA', '2023-10-02', 105000, 1550, 92000),
('India', '2023-10-01', 50000, 500, 48000),
('India', '2023-10-03', 52000, 510, 50000);

CREATE OR REPLACE VIEW vw_latest_covid_data AS
WITH RankedCases AS (
    SELECT 
        country,
        report_date,
        confirmed,
        deaths,
        recovered,
        ROW_NUMBER() OVER (
            PARTITION BY country 
            ORDER BY report_date DESC
        ) AS rn
    FROM covid_cases_uc21
)
SELECT 
    country,
    report_date AS latest_report_date,
    confirmed AS latest_confirmed,
    deaths AS latest_deaths,
    recovered AS latest_recovered
FROM RankedCases
WHERE rn = 1;