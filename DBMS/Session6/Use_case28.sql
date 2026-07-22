CREATE TABLE country_demographics_uc28 (
    country_id INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(100) NOT NULL,
    population INT NOT NULL
);

CREATE TABLE covid_stats_uc28 (
    stat_id INT AUTO_INCREMENT PRIMARY KEY,
    country_id INT NOT NULL,
    report_date DATE NOT NULL,
    confirmed INT DEFAULT 0
);

INSERT INTO country_demographics_uc28 (country_name, population) VALUES
('USA', 331000000),
('India', 1400000000);

INSERT INTO covid_stats_uc28 (country_id, report_date, confirmed) VALUES
(1, '2023-10-01', 100000),
(2, '2023-10-01', 50000);

EXPLAIN FORMAT=TREE
SELECT d.country_name, d.population, s.report_date, s.confirmed
FROM country_demographics_uc28 d
JOIN covid_stats_uc28 s ON d.country_id = s.country_id
WHERE s.report_date = '2023-10-01';

CREATE INDEX idx_covid_stats_country_date ON covid_stats_uc28 (country_id, report_date);

EXPLAIN FORMAT=TREE
SELECT d.country_name, d.population, s.report_date, s.confirmed
FROM country_demographics_uc28 d
JOIN covid_stats_uc28 s ON d.country_id = s.country_id
WHERE s.report_date = '2023-10-01';