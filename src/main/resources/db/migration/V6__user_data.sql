-- USER
INSERT INTO rwm_storage."user" (first_name, last_name, role)
VALUES ('Ivan', 'Ivanov', 'ADMIN');
INSERT INTO rwm_storage."user" (first_name, last_name, role)
VALUES ('Irina', 'Volkova', 'CONDUCTOR');

-- CUSTOMER
INSERT INTO rwm_storage.customer(birth_date, email, first_name, gender, last_name)
VALUES (03 - 06 - 1992, 'qwerty@gmail.com', 'Max', 'MALE', 'Kaz');
INSERT INTO rwm_storage.customer(birth_date, email, first_name, gender, last_name)
VALUES (03 - 06 - 1990, 'qwert@gmail.com', 'Mai', 'FEMALE', 'Kaz');
INSERT INTO rwm_storage.customer(birth_date, email, first_name, gender, last_name)
VALUES (03 - 06 - 1991, 'qwer@gmail.com', 'Egor', 'MALE', 'Petrov');
INSERT INTO rwm_storage.customer(birth_date, email, first_name, gender, last_name)
VALUES (03 - 06 - 1996, 'qwe@gmail.com', 'Diana', 'FEMALE', 'Petrova');
INSERT INTO rwm_storage.customer(birth_date, email, first_name, gender, last_name)
VALUES (03 - 04 - 1992, 'werty@gmail.com', 'Dmitri', 'MALE', 'Sidorov');
INSERT INTO rwm_storage.customer(birth_date, email, first_name, gender, last_name)
VALUES (03 - 02 - 1992, 'erty@gmail.com', 'Inna', 'FEMALE', 'Sidorova');

-- STATION
INSERT INTO rwm_storage.station (name)
VALUES ('Minsk');
INSERT INTO rwm_storage.station (name)
VALUES ('Brest');
INSERT INTO rwm_storage.station (name)
VALUES ('Berlin');
INSERT INTO rwm_storage.station (name)
VALUES ('Moscow');
INSERT INTO rwm_storage.station (name)
VALUES ('Baranovichy');
INSERT INTO rwm_storage.station (name)
VALUES ('Kommynari');
INSERT INTO rwm_storage.station (name)
VALUES ('Bereza');
INSERT INTO rwm_storage.station (name)
VALUES ('Drogichin');
INSERT INTO rwm_storage.station (name)
VALUES ('Ivacevichy');
INSERT INTO rwm_storage.station (name)
VALUES ('Stolbcy');

-- TRAIN
INSERT INTO rwm_storage.train (bought, name, number, train_type)
VALUES (false, 'Minsk-Brest', 701, 'DIESEL');
INSERT INTO rwm_storage.train (bought, name, number, train_type)
VALUES (false, 'Moscow-Berlin', 702, 'DIESEL');
INSERT INTO rwm_storage.train (bought, name, number, train_type)
VALUES (false, 'Moscow-Brest', 703, 'DIESEL');
INSERT INTO rwm_storage.train (bought, name, number, train_type)
VALUES (false, 'Minsk-Brest', 704, 'DIESEL');
INSERT INTO rwm_storage.train (bought, name, number, train_type)
VALUES (false, 'Baranovichy-Brest', 705, 'ELECTRIC');
INSERT INTO rwm_storage.train (bought, name, number, train_type)
VALUES (false, 'Kommynari-Brest', 706, 'ELECTRIC');

--WAGGON
INSERT INTO rwm_storage.waggon(bought, number, waggon_type, train_id)
VALUES (false, 1, 'COMPARTMENT', (SELECT t.id FROM rwm_storage.train t WHERE t.number = 701));
INSERT INTO rwm_storage.waggon(bought, number, waggon_type, train_id)
VALUES (false, 2, 'PLACKART', (SELECT t.id FROM rwm_storage.train t WHERE t.number = 701));
INSERT INTO rwm_storage.waggon(bought, number, waggon_type, train_id)
VALUES (false, 1, 'SITTING', (SELECT t.id FROM rwm_storage.train t WHERE t.number = 702));
INSERT INTO rwm_storage.waggon(bought, number, waggon_type, train_id)
VALUES (false, 2, 'COMMON', (SELECT t.id FROM rwm_storage.train t WHERE t.number = 702));
INSERT INTO rwm_storage.waggon(bought, number, waggon_type, train_id)
VALUES (false, 1, 'COMPARTMENT', (SELECT t.id FROM rwm_storage.train t WHERE t.number = 703));
INSERT INTO rwm_storage.waggon(bought, number, waggon_type, train_id)
VALUES (false, 2, 'PLACKART', (SELECT t.id FROM rwm_storage.train t WHERE t.number = 703));
INSERT INTO rwm_storage.waggon(bought, number, waggon_type, train_id)
VALUES (false, 1, 'SITTING', (SELECT t.id FROM rwm_storage.train t WHERE t.number = 704));
INSERT INTO rwm_storage.waggon(bought, number, waggon_type, train_id)
VALUES (false, 2, 'COMMON', (SELECT t.id FROM rwm_storage.train t WHERE t.number = 704));
INSERT INTO rwm_storage.waggon(bought, number, waggon_type, train_id)
VALUES (false, 1, 'COMPARTMENT', (SELECT t.id FROM rwm_storage.train t WHERE t.number = 705));
INSERT INTO rwm_storage.waggon(bought, number, waggon_type, train_id)
VALUES (false, 2, 'PLACKART', (SELECT t.id FROM rwm_storage.train t WHERE t.number = 705));
INSERT INTO rwm_storage.waggon(bought, number, waggon_type, train_id)
VALUES (false, 1, 'SITTING', (SELECT t.id FROM rwm_storage.train t WHERE t.number = 706));
INSERT INTO rwm_storage.waggon(bought, number, waggon_type, train_id)
VALUES (false, 2, 'COMMON', (SELECT t.id FROM rwm_storage.train t WHERE t.number = 706));

--PLACE
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false,
        (SELECT w.id
         FROM rwm_storage.waggon w
                  INNER JOIN rwm_storage.train t ON w.train_id = t.id
         WHERE t.number = 701));
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 701));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 701));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 701));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 702));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 702));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 702));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 702));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 703));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 703));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 703));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 703));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 704));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 704));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 704));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 704));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 705));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 705));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 705));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 705));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 706));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 706));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 706));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 706));

--TIME_TABLE
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 701),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Minsk'), 03 - 06 - 1992);
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 701),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Minsk'), 03 - 06 - 1992);