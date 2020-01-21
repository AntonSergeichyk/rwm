--TICKET
INSERT INTO rwm_storage.ticket(date_of_arrival, date_of_leave, place_id, station_of_leave_id,
                               station_of_arrival_id)
VALUES ( (SELECT tt.arrival_time
                  FROM rwm_storage.timetable tt
                           INNER JOIN rwm_storage.train t ON t.id = tt.train_id
                           INNER JOIN rwm_storage.station s ON tt.station_id = s.id
                  WHERE t.number = 701
                    AND s.name = 'Minsk'),
        (SELECT tt.arrival_time
         FROM rwm_storage.timetable tt
                  INNER JOIN rwm_storage.train t ON t.id = tt.train_id
                  INNER JOIN rwm_storage.station s ON tt.station_id = s.id
         WHERE t.number = 701
           AND s.name = 'Brest'),
        (SELECT p.id
         FROM rwm_storage.place p
                  INNER JOIN rwm_storage.waggon w ON p.waggon_id = w.id
                  INNER JOIN rwm_storage.train t ON w.train_id = t.id
         WHERE t.number = '701'
           AND w.number = 1
           AND p.number = 1),
        (SELECT s.id
         FROM rwm_storage.station s
         WHERE s.name = 'Minsk'),
        (SELECT s.id
         FROM rwm_storage.station s
         WHERE s.name = 'Brest'));

