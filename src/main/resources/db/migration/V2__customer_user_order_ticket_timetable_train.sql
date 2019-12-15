CREATE SCHEMA rwm_storage;

CREATE TABLE rwm_storage.customer
(
    id           BIGSERIAL PRIMARY KEY,
    changed_at   TIMESTAMP WITHOUT TIME ZONE NULL NULL DEFAULT now(),
    changed_by   BIGINT                      NULL,
    created_at   TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    created_by   BIGINT                      NULL,
    birth_date   date                        NOT NULL,
    email        VARCHAR(255)                NOT NULL,
    first_name   VARCHAR(255)                NOT NULL,
    gender       VARCHAR(255)                NOT NULL,
    identity     uuid                        NOT NULL DEFAULT uuid_generate_v4(),
    last_name    VARCHAR(255)                NOT NULL,
    phone_number VARCHAR(255)                NULL
);

CREATE TABLE rwm_storage.customer_advanced_details
(
    id          BIGSERIAL PRIMARY KEY,
    changed_at  TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    changed_by  BIGINT                      NULL,
    created_at  TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    created_by  BIGINT                      NULL,
    customer_id BIGINT                      NOT NULL REFERENCES rwm_storage.customer (id)
);

CREATE TABLE rwm_storage.customer_bank_details
(
    id                  BIGSERIAL PRIMARY KEY,
    changed_at          TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    changed_by          BIGINT                      NULL,
    created_at          TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    created_by          BIGINT                      NULL,
    customer_id         BIGINT                      NOT NULL REFERENCES rwm_storage.customer (id),
    bank_account_number VARCHAR(255)                NULL,
    payment_account_id  VARCHAR(255)                NULL,
    tin                 VARCHAR(255)                NULL
);

CREATE TABLE rwm_storage.customer_sensitive_details
(
    id                   BIGSERIAL PRIMARY KEY,
    changed_at           TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    changed_by           BIGINT                      NULL,
    created_at           TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    created_by           BIGINT                      NULL,
    customer_id          BIGINT                      NOT NULL REFERENCES rwm_storage.customer (id),
    citizenship          VARCHAR(255)                NULL,
    first_name_rus       VARCHAR(255)                NULL,
    last_name_rus        VARCHAR(255)                NULL,
    middle_name_rus      VARCHAR(255)                NULL,
    passport_expire_date date                        NULL,
    passport_id          VARCHAR(255)                NULL,
    passport_issued_date date                        NULL,
    passport_issuer      VARCHAR(255)                NULL
);

CREATE TABLE rwm_storage.train
(
    id         BIGSERIAL PRIMARY KEY,
    changed_at TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    changed_by BIGINT                      NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    created_by BIGINT                      NULL,
    bought     BOOLEAN                     NOT NULL,
    name       VARCHAR(255)                NOT NULL,
    number     INTEGER                     NOT NULL,
    train_type VARCHAR(255)                NOT NULL
);

CREATE TABLE rwm_storage.user
(
    id         BIGSERIAL PRIMARY KEY,
    changed_at TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    changed_by BIGINT                      NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    created_by BIGINT                      NULL,
    first_name VARCHAR(255)                NOT NULL,
    last_name  VARCHAR(255)                NOT NULL,
    role       VARCHAR(255)                NOT NULL
);

CREATE TABLE rwm_storage.station
(
    id         BIGSERIAL PRIMARY KEY,
    changed_at TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    changed_by BIGINT                      NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    created_by BIGINT                      NULL,
    name       VARCHAR(255)                NULL
);

CREATE TABLE rwm_storage.waggon
(
    id          BIGSERIAL PRIMARY KEY,
    changed_at  TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    changed_by  BIGINT                      NULL,
    created_at  TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    created_by  BIGINT                      NULL,
    bought      BOOLEAN                     NOT NULL,
    number      INTEGER                     NOT NULL,
    waggon_type VARCHAR(255)                NOT NULL,
    train_id    BIGINT                      NOT NULL REFERENCES rwm_storage.train (id)
);

CREATE TABLE rwm_storage.place
(
    id         BIGSERIAL PRIMARY KEY,
    changed_at TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    changed_by BIGINT                      NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    created_by BIGINT                      NULL,
    bought     BOOLEAN                     NULL NULL,
    number     INTEGER                     NULL NULL,
    place_type VARCHAR(255)                NULL NULL,
    reserved   BOOLEAN                     NULL NULL,
    waggon_id  BIGINT                      NULL NULL REFERENCES rwm_storage.waggon (id)
);

CREATE TABLE rwm_storage.ticket
(
    id              BIGSERIAL PRIMARY KEY,
    changed_at      TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    changed_by      BIGINT                      NULL,
    created_at      TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    created_by      BIGINT                      NULL,
    cost            VARCHAR(255)                NOT NULL,
    date_of_arrival TIMESTAMP                   NOT NULL,
    date_of_leave   TIMESTAMP                   NOT NULL,
    place_id        BIGINT                      NOT NULL REFERENCES rwm_storage.place (id)
);

CREATE TABLE rwm_storage.order
(
    id             BIGSERIAL PRIMARY KEY,
    changed_at     TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    changed_by     BIGINT                      NULL,
    created_at     TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    created_by     BIGINT                      NULL,
    customer_id    BIGINT                      NULL REFERENCES rwm_storage.customer (id),
    passenger_type VARCHAR(255)                NOT NULL,
    rate           VARCHAR(255)                NOT NULL,
    ticket_id      BIGINT                      NOT NULL REFERENCES rwm_storage.ticket (id)
);

CREATE TABLE rwm_storage.timetable
(
    id           BIGSERIAL PRIMARY KEY,
    changed_at   TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    changed_by   BIGINT                      NULL,
    created_at   TIMESTAMP WITHOUT TIME ZONE NULL NULL,
    created_by   BIGINT                      NULL,
    train_id     BIGINT                      NULL REFERENCES rwm_storage.train (id),
    station_id   BIGINT                      NULL REFERENCES rwm_storage.station (id),
    arrival_time TIMESTAMP                   NULL
);