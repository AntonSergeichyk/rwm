CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

ALTER TABLE rwm_storage.customer
    ADD COLUMN IF NOT EXISTS identity UUID UNIQUE;

UPDATE rwm_storage.customer
SET identity = uuid_generate_v4();

ALTER TABLE rwm_storage.customer
    ALTER COLUMN identity SET NOT NULL;