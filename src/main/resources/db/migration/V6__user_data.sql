-- USER
INSERT INTO rwm_storage."user" (first_name, last_name, role)
VALUES ('Ivan', 'Ivanov', 'ADMIN');
INSERT INTO rwm_storage."user" (first_name, last_name, role)
VALUES ('Irina', 'Volkova', 'CONDUCTOR');

-- CUSTOMER
INSERT INTO rwm_storage.customer(birth_date, email, first_name, gender, last_name)
VALUES ('1992-03-06', 'qwerty@gmail.com', 'Max', 'MALE', 'Kaz');
INSERT INTO rwm_storage.customer(birth_date, email, first_name, gender, last_name)
VALUES ('1990-03-06', 'qwert@gmail.com', 'Mai', 'FEMALE', 'Kaz');
INSERT INTO rwm_storage.customer(birth_date, email, first_name, gender, last_name)
VALUES ('1991-03-06', 'qwer@gmail.com', 'Egor', 'MALE', 'Petrov');
INSERT INTO rwm_storage.customer(birth_date, email, first_name, gender, last_name)
VALUES ('1996-03-06', 'qwe@gmail.com', 'Diana', 'FEMALE', 'Petrova');
INSERT INTO rwm_storage.customer(birth_date, email, first_name, gender, last_name)
VALUES ('1992-03-04', 'werty@gmail.com', 'Dmitri', 'MALE', 'Sidorov');
INSERT INTO rwm_storage.customer(birth_date, email, first_name, gender, last_name)
VALUES ('1992-03-02', 'erty@gmail.com', 'Inna', 'FEMALE', 'Sidorova');

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
VALUES ('Zabinka');
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
         WHERE t.number = 701
           AND w.number = 1));
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 701
                                         AND w.number = 1));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 701
                                             AND w.number = 2));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 701
                                         AND w.number = 2));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 702
                                             AND w.number = 1));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 702
                                         AND w.number = 1));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 702
                                             AND w.number = 2));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 702
                                         AND w.number = 2));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 703
                                             AND w.number = 1));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 703
                                         AND w.number = 1));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 703
                                             AND w.number = 2));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 703
                                         AND w.number = 2));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 704
                                             AND w.number = 1));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 704
                                         AND w.number = 1));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 704
                                             AND w.number = 2));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 704
                                         AND w.number = 2));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 705
                                             AND w.number = 1));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 705
                                         AND w.number = 1));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 705
                                             AND w.number = 2));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 705
                                         AND w.number = 2));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 706
                                             AND w.number = 1));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 706
                                         AND w.number = 1));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 1, 'ORDINARY_SEAT', false, (SELECT w.id
                                           FROM rwm_storage.waggon w
                                                    INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                           WHERE t.number = 706
                                             AND w.number = 2));
INSERT INTO rwm_storage.place(bought, number, place_type, reserved, waggon_id)
VALUES (false, 2, 'SIDE_SEAT', false, (SELECT w.id
                                       FROM rwm_storage.waggon w
                                                INNER JOIN rwm_storage.train t ON w.train_id = t.id
                                       WHERE t.number = 706
                                         AND w.number = 2));

--TIME_TABLE
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 701),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Minsk'), '2019-12-20 09:33:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 701),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Stolbcy'), '2019-12-20 10:30:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 701),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Baranovichy'), '2019-12-20 11:15:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 701),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Ivacevichy'), '2019-12-20 11:40:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 701),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Bereza'), '2019-12-20 12:00:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 701),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Zabinka'), '2019-12-20 12:35:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 701),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Brest'), '2019-12-20 13:10:00');

INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 702),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Moscow'), '2019-12-20 12:40:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 702),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Minsk'), '2019-12-20 17:10:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 702),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Baranovichy'), '2019-12-20 19:30:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 702),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Brest'), '2019-12-20 21:10:00');

INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 703),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Moscow'), '2019-12-20 01:10:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 703),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Minsk'), '2019-12-20 05:30:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 703),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Baranovichy'), '2019-12-20 09:15:00');

INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 704),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Minsk'), '2019-12-20 17:40:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 704),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Baranovichy'), '2019-12-20 19:20:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 704),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Brest'), '2019-12-20 21:40:00');

INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 705),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Baranovichy'), '2019-12-20 10:15:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 705),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Ivacevichy'), '2019-12-20 11:40:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 705),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Bereza'), '2019-12-20 12:30:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 705),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Zabinka'), '2019-12-20 16:35:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 705),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Stolbcy'), '2019-12-20 17:10:00');

INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 706),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Kommynari'), '2019-12-20 03:30:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 706),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Minsk'), '2019-12-20 03:30:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 706),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Minsk'), '2019-12-20 04:13:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 706),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Stolbcy'), '2019-12-20 05:30:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 706),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Baranovichy'), '2019-12-20 06:15:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 706),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Ivacevichy'), '2019-12-20 07:40:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 706),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Bereza'), '2019-12-20 08:00:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 706),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Zabinka'), '2019-12-20 09:35:00');
INSERT INTO rwm_storage.timetable(train_id, station_id, arrival_time)
VALUES ((SELECT t.id FROM rwm_storage.train t WHERE t.number = 706),
        (SELECT s.id FROM rwm_storage.station s WHERE s.name = 'Stolbcy'), '2019-12-20 11:10:00');
