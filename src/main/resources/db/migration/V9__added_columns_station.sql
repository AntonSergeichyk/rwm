ALTER TABLE rwm_storage.ticket
    ADD COLUMN IF NOT EXISTS station_of_leave_id BIGINT NULL REFERENCES rwm_storage.station (id),
    ADD COLUMN IF NOT EXISTS station_of_arrival_id BIGINT NULL REFERENCES rwm_storage.station (id);