CREATE TABLE covid_cases_uc25 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed INT DEFAULT 0,
    deaths INT DEFAULT 0,
    recovered INT DEFAULT 0
);

CREATE TABLE covid_cases_audit (
    audit_id INT AUTO_INCREMENT PRIMARY KEY,
    case_id INT,
    country VARCHAR(100),
    report_date DATE,
    old_confirmed INT,
    new_confirmed INT,
    old_deaths INT,
    new_deaths INT,
    old_recovered INT,
    new_recovered INT,
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    changed_by VARCHAR(100) DEFAULT (CURRENT_USER())
);

INSERT INTO covid_cases_uc25 (country, report_date, confirmed, deaths, recovered) VALUES
('Canada', '2023-10-01', 30000, 300, 28000);

DELIMITER //

CREATE TRIGGER trg_covid_cases_before_update
BEFORE UPDATE ON covid_cases_uc25
FOR EACH ROW
BEGIN
    INSERT INTO covid_cases_audit (
        case_id,
        country,
        report_date,
        old_confirmed,
        new_confirmed,
        old_deaths,
        new_deaths,
        old_recovered,
        new_recovered
    )
    VALUES (
        OLD.id,
        OLD.country,
        OLD.report_date,
        OLD.confirmed,
        NEW.confirmed,
        OLD.deaths,
        NEW.deaths,
        OLD.recovered,
        NEW.recovered
    );
END //

DELIMITER ;