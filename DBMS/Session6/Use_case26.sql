CREATE TABLE covid_cases_uc26 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed INT DEFAULT 0,
    deaths INT DEFAULT 0,
    recovered INT DEFAULT 0
);

INSERT INTO covid_cases_uc26 (country, report_date, confirmed, deaths, recovered) VALUES
('USA', '2023-10-01', 100000, 1500, 90000),
('India', '2023-10-01', 50000, 500, 48000),
('Brazil', '2023-10-01', 40000, 1000, 35000);

CREATE INDEX idx_country_date ON covid_cases_uc26 (country, report_date);

CREATE INDEX idx_report_date ON covid_cases_uc26 (report_date);