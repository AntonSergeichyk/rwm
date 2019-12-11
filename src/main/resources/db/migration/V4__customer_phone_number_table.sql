ALTER TABLE rwm_storage.customer_phone_number
    ALTER COLUMN customer_id SET NOT NULL;

ALTER TABLE rwm_storage.customer_phone_number
    ALTER COLUMN phone_number SET NOT NULL;

ALTER TABLE rwm_storage.customer_phone_number
    ADD CONSTRAINT customer_id_phone_number UNIQUE (phone_number, customer_id);

