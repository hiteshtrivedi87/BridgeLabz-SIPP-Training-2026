use covid;
-- Question 1

-- Table 1: covid_cases
CREATE TABLE covid_cases (
    case_id INT PRIMARY KEY AUTO_INCREMENT,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases INT NOT NULL,
    recoveries INT DEFAULT 0,
    population BIGINT NOT NULL
);

-- Table 2: covid_deaths
CREATE TABLE covid_deaths (
    death_id INT PRIMARY KEY AUTO_INCREMENT,
    case_id INT,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    deaths INT NOT NULL,
    FOREIGN KEY (case_id) REFERENCES covid_cases(case_id)
);

-- Table 3: covid_vaccines
CREATE TABLE covid_vaccines (
    vaccine_id INT PRIMARY KEY AUTO_INCREMENT,
    case_id INT,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    vaccine_name VARCHAR(100),
    doses_administered BIGINT,
    people_vaccinated BIGINT,
    people_fully_vaccinated BIGINT,
    FOREIGN KEY (case_id) REFERENCES covid_cases(case_id)
);

-- Question 2
INSERT INTO covid_cases
(country, report_date, confirmed_cases, recoveries, population)
VALUES
('India', '2021-01-01', 10340000, 9945000, 1380004385),
('India', '2021-02-01', 10746000, 10420000, 1380004385),
('India', '2021-03-01', 11122000, 10760000, 1380004385),

('USA', '2021-01-01', 20150000, 11900000, 331002651),
('USA', '2021-02-01', 26420000, 16750000, 331002651),
('USA', '2021-03-01', 28790000, 19000000, 331002651),

('UK', '2021-01-01', 2540000, 1800000, 67886011),
('UK', '2021-02-01', 3820000, 2750000, 67886011),
('UK', '2021-03-01', 4200000, 3100000, 67886011);

-- Question 3
UPDATE covid_cases
SET confirmed_cases = 11250000
WHERE country = 'India'
AND report_date = '2021-03-01';

-- Question 4
DELETE FROM covid_cases
WHERE country = 'IN';

-- Question 5
ALTER TABLE covid_cases
ADD vaccination_rate DECIMAL(5,2);

----------------------------------------------------------------------------------------------------


CREATE DATABASE covid_db;
USE covid_db;
-- Question 1
CREATE TABLE covid_cases (
    id INT PRIMARY KEY AUTO_INCREMENT,
    country VARCHAR(50),
    report_date DATE,
    report_time TIME,
    recoveries INT,
    deaths INT,
    confirmed_cases INT
);

-- Question 2
INSERT INTO covid_cases
(country, report_date, report_time, recoveries, deaths, confirmed_cases)
VALUES
('India', '2020-03-15', '10:00:00', 50, 2, 100);

-- Question 3
UPDATE covid_cases
SET confirmed_cases = 120
WHERE country = 'India'
AND report_date = '2020-03-15';

-- Question 4
DELETE FROM covid_cases
WHERE country = 'IN';

-- Question 5
ALTER TABLE covid_cases
ADD vaccination_rate FLOAT;