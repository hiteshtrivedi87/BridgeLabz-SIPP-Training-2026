SELECT country, vaccinated_count AS population_count, 'Vaccinated' AS category
FROM covid_vaccinations
UNION
SELECT country, unvaccinated_count AS population_count, 'Unvaccinated' AS category
FROM covid_vaccinations;