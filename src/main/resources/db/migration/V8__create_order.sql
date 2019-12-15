--ORDER
INSERT INTO rwm_storage.order(customer_id, passenger_type, rate, ticket_id)
VALUES ((SELECT c.id FROM rwm_storage.customer c WHERE c.birth_date = '1992-03-06'),
        'ADULT', 'FULL', (SELECT ti.id
                          FROM rwm_storage.ticket ti
                                   INNER JOIN rwm_storage.place p ON p.id = ti.place_id
                                   INNER JOIN rwm_storage.waggon w ON w.id = p.waggon_id
                                   INNER JOIN rwm_storage.train t ON t.id = w.train_id
                          WHERE t.number = 701
                            AND w.number = 1
                            AND p.number = 1));