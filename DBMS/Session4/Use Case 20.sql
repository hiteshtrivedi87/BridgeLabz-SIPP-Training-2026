SELECT DISTINCT country
FROM covid_deaths
WHERE country NOT IN (
    SELECT DISTINCT country
    FROM covid_cases
    WHERE country IS NOT NOT NULL
);