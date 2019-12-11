ALTER TABLE rwm_storage.customer
DROP COLUMN IF EXISTS phone_number;

CREATE TABLE rwm_storage.customer_phone_number
(
phone_number VARCHAR(32)  NULL,
customer_id BIGINT REFERENCES rwm_storage.customer(id)
);

