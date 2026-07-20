-- Total COVID deaths by continent
SELECT ct.continent_name,
       SUM(cc.total_deaths) AS total_deaths
FROM covid_cases cc
INNER JOIN continents ct
    ON cc.continent_id = ct.continent_id
GROUP BY ct.continent_name
ORDER BY total_deaths DESC;
