SELECT country, MAX(deaths) AS total_deaths
FROM covid_deaths
GROUP BY country
HAVING MAX(deaths) > (
    SELECT AVG(deaths)
    FROM covid_deaths
);