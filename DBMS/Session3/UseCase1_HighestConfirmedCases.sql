-- Find country with highest confirmed cases on a specific date
SELECT c.country_name,
       cc.report_date,
       cc.confirmed_cases
FROM covid_cases cc
INNER JOIN countries c
    ON cc.country_id = c.country_id
WHERE cc.report_date = '2021-01-01'
ORDER BY cc.confirmed_cases DESC
LIMIT 1;
