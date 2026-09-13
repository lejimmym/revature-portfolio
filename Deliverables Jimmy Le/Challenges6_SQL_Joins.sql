--Part 1 Joins

SELECT i.invoice_id,
       c.first_name,
       c.last_name,
       i.total
FROM invoice i
JOIN customer c ON i.customer_id = c.customer_id;

--Part 2 Joins

SELECT i.invoice_id,
       c.first_name,
       i.total
FROM invoice i
JOIN customer c ON i.customer_id = c.customer_id
WHERE i.total > 30;

--The most expensive invoice is 25.89 There will be no results above 30
--Part 3 CTE
WITH usa_invoices AS
    (SELECT i.invoice_id,
            i.customer_id,
            i.invoice_date,
            i.total
     FROM invoice i
     JOIN customer c ON i.customer_id = c.customer_id
     WHERE c.country = 'USA'
         AND i.invoice_date >= CURRENT_DATE - INTERVAL '6 months')
SELECT *
FROM usa_invoices;

--Same result here there are no invoices here after 2025-12
 --Part 4 Table

CREATE TABLE record_logs (log_id SERIAL PRIMARY KEY,
                                        record_id INTEGER, field_changed VARCHAR(100),
                                                                         last_update TIMESTAMP, old_value TEXT, new_value TEXT);

--Part 5 Trigger
--A bit confused here.