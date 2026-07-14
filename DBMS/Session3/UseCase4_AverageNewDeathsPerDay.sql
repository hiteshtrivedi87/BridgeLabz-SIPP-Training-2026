-- Average new deaths per day
SELECT report_date,
       AVG(new_deaths) AS avg_new_deaths
FROM covid_cases
GROUP BY report_date
ORDER BY report_date;
