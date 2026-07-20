USE covid;

-- UseCase 1
ALTER TABLE covid_cases
ADD PRIMARY KEY (Country, Date);

-- UseCase 2
CREATE TABLE countries (
    Country VARCHAR(100) PRIMARY KEY
);

INSERT INTO countries (Country)
SELECT DISTINCT Country
FROM covid_cases;

ALTER TABLE covid_cases
ADD CONSTRAINT fk_country
FOREIGN KEY (Country)
REFERENCES countries(Country);

-- UseCase 3
ALTER TABLE covid_cases
MODIFY Country VARCHAR(100) NOT NULL;

ALTER TABLE covid_cases
MODIFY Date DATE NOT NULL;

ALTER TABLE covid_cases
MODIFY Confirmed_Cases INT NOT NULL;

ALTER TABLE covid_cases
ADD CONSTRAINT chk_deaths
CHECK (Deaths <= Confirmed_Cases);

-- UseCase 4
ALTER TABLE covid_cases
MODIFY Recoveries INT DEFAULT 0;

ALTER TABLE covid_cases
MODIFY Last_Updated TIMESTAMP
DEFAULT CURRENT_TIMESTAMP;

-- UseCase 5
ALTER TABLE covid_cases
ADD CONSTRAINT uq_country_date
UNIQUE (Country, Date);