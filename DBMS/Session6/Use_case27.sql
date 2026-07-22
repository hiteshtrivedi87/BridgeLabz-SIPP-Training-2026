CREATE TABLE covid_cases_uc27 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    population INT NOT NULL,
    confirmed INT NOT NULL,
    infection_rate DECIMAL(7,4) GENERATED ALWAYS AS ((confirmed / population) * 100) STORED
);

INSERT INTO covid_cases_uc27 (country, population, confirmed) VALUES
('USA', 331000000, 10000000),
('India', 1400000000, 12000000),
('Brazil', 214000000, 5000000),
('France', 67000000, 3000000),
('Germany', 83000000, 2500000),
('UK', 67000000, 2800000),
('Italy', 59000000, 2100000),
('Spain', 47000000, 1800000),
('Japan', 125000000, 1500000),
('South Korea', 51000000, 1200000),
('Canada', 38000000, 900000);

CREATE INDEX idx_covering_infection_rate ON covid_cases_uc27 (infection_rate DESC, country);

SELECT country, infection_rate 
FROM covid_cases_uc27 
ORDER BY infection_rate DESC 
LIMIT 10;