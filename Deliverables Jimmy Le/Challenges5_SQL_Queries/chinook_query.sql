--1 Query all customers
SELECT *
FROM customer;

--2 Query customers from Arizona
SELECT *
FROM customer
WHERE state = 'AZ';

--3 Query all invoices older than 6 months
SELECT *
FROM invoice
WHERE invoice_date < CURRENT_DATE - INTERVAL '6 months';

--4 Update invalid phone no.
UPDATE customer
SET phone = NULL
WHERE phone !~ '^\+1 [0-9]{3} [0-9]{3}-[0-9]{4}$';
--Note it seems like EVERY phone number is in the wrong format

--5 Query long tracks
SELECT *
FROM track
WHERE milliseconds > 180000;

--6 Update countries
UPDATE customer
SET country = 'USA', address = NULL, city = NULL, state = NULL
WHERE country != 'USA';

--7 Function customers total spending by id
CREATE OR REPLACE FUNCTION get_customer_total_spending(
    p_customer_id INT
)
RETURNS NUMERIC
LANGUAGE plpgsql
AS $$
DECLARE
    total_spending NUMERIC;
BEGIN
    SELECT COALESCE(SUM(total), 0)
    INTO total_spending
    FROM invoice
    WHERE customer_id = p_customer_id;

    RETURN total_spending;
END;
$$;

SELECT get_customer_total_spending(1);

--8 Procedure Manager and Hierarchy
CREATE OR REPLACE PROCEDURE update_employee_manager(
    p_employee_id INT, 
    p_manager_id INT
)
LANGUAGE plpgsql
AS $$
DECLARE
    manager_exist BOOLEAN;
    creates_cycle BOOLEAN;
BEGIN
    --Prevent self management
    if p_employee_id = p_manager_id THEN 
        RAISE EXCEPTION
            'An employee cannot be their own manager';
    END IF;
    --Ensure manager's existance
    SELECT EXISTS (
        SELECT 1
        FROM employee
        WHERE employee_id = p_manager_id
    )
    INTO manager_exist;
    IF NOT manager_exist THEN
        RAISE EXCEPTION
            'Employee with id number % does not exist', p_manager_id;
    END IF;
    --Prevent circular management
    WITH RECURSIVE management_chain AS (
        SELECT employee_id, reports_to
        FROM employee
        WHERE employee_id = p_manager_id

        UNION ALL

        SELECT e.employee_id, e.reports_to
        FROM employee e
        JOIN management_chain mc
            ON e.employee_id = mc.reports_to
    )
    SELECT EXISTS (
        SELECT 1
        FROM management_chain
        WHERE employee_id = p_employee_id
    )
    INTO creates_cycle;
    IF creates_cycle THEN
        RAISE EXCEPTION
            'Circular management';
    END IF;
    UPDATE employee
    SET reports_to = p_employee_id
    WHERE employee_id = p_employee_id;
END;
$$;

--9 Schema Pets
CREATE SCHEMA pets;
CREATE TABLE pets.customer
(
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL
);
CREATE TABLE pets.pet
(
    pet_id INT PRIMARY KEY,
    customer_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    species VARCHAR(50),
    FOREIGN KEY (customer_id)
        REFERENCES pets.customer(customer_id)
);
--Test out new schema
INSERT INTO pets.customer 
    (customer_id, first_name, last_name)
VALUES
    (1, 'Jimmy', 'Le');
INSERT INTO pets.pet 
    (pet_id, customer_id, name, species)
VALUES
    (1, 1, 'Sammy', 'Dog'),
    (2, 1, 'Mina', 'Dog'),
    (3, 1, 'Light Grenade', 'Cat');

SELECT *
FROM pets.pet;