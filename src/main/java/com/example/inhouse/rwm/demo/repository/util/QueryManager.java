package com.example.inhouse.rwm.demo.repository.util;

public final class QueryManager {

    //TIME_TABLE
    public static final String FIND_BY_DEPARTURE_ST_AND_ARRIVAL_ST_AND_DATE = "SELECT " +
            "       sab_table_first.train_id,\n" +
            "       sab_table_first.train_number,\n" +
            "       sab_table_first.train_name,\n" +
            "       sab_table_first.departure_time,\n" +
            "       sab_table_first.departure_station_name,\n" +
            "       sab_table_second.arrival_time,\n" +
            "       sab_table_second.arrival_station_name\n" +
            "FROM (SELECT t.id            AS train_id,\n" +
            "             t.number        AS train_number,\n" +
            "             t.name          AS train_name,\n" +
            "             tt.arrival_time AS departure_time,\n" +
            "             s.name          AS departure_station_name\n" +
            "      FROM rwm_storage.timetable tt\n" +
            "               INNER JOIN rwm_storage.train t ON tt.train_id = t.id\n" +
            "               INNER JOIN rwm_storage.station s ON tt.station_id = s.id\n" +
            "      WHERE s.id = :station1 \n" +
            "        AND date(tt.arrival_time) = :date) sab_table_first\n" +
            "         INNER JOIN (SELECT t.id            AS train_id,\n" +
            "                            t.number        AS train_number,\n" +
            "                            t.name          AS train_name,\n" +
            "                            tt.arrival_time AS arrival_time,\n" +
            "                            s.name          AS arrival_station_name\n" +
            "                     FROM rwm_storage.timetable tt\n" +
            "                              INNER JOIN rwm_storage.train t ON tt.train_id = t.id\n" +
            "                              INNER JOIN rwm_storage.station s ON tt.station_id = s.id\n" +
            "                     WHERE s.id = :station2 \n" +
            "                       AND date(tt.arrival_time) = :date) sab_table_second\n" +
            "                    ON sab_table_first.train_number = sab_table_second.train_number\n" +
            "WHERE sab_table_first.departure_time < sab_table_second.arrival_time;";

    public static final String COUNT_FIND_BY_DEPARTURE_ST_AND_ARRIVAL_ST_AND_DATE = "SELECT  count(*)\n" +
            "            FROM (SELECT t.id            AS train_id,\n" +
            "                         t.number        AS train_number,\n" +
            "                         tt.arrival_time AS departure_time\n" +
            "                  FROM rwm_storage.timetable tt\n" +
            "                           INNER JOIN rwm_storage.train t ON tt.train_id = t.id\n" +
            "                           INNER JOIN rwm_storage.station s ON tt.station_id = s.id\n" +
            "                  WHERE s.id = :station1\n" +
            "                    AND date(tt.arrival_time) = :date) sab_table_first\n" +
            "                     INNER JOIN (SELECT t.id            AS train_id,\n" +
            "                                        t.number        AS train_number,\n" +
            "                                        tt.arrival_time AS arrival_time\n" +
            "                                 FROM rwm_storage.timetable tt\n" +
            "                                          INNER JOIN rwm_storage.train t ON tt.train_id = t.id\n" +
            "                                          INNER JOIN rwm_storage.station s ON tt.station_id = s.id\n" +
            "                                 WHERE s.id = :station2\n" +
            "                                   AND date(tt.arrival_time) = :date) sab_table_second\n" +
            "                                ON sab_table_first.train_number = sab_table_second.train_number\n" +
            "            WHERE sab_table_first.departure_time < sab_table_second.arrival_time;";


}
