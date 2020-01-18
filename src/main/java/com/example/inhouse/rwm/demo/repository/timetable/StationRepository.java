package com.example.inhouse.rwm.demo.repository.timetable;

import com.example.inhouse.rwm.demo.domein.timetable.Station;
import com.example.inhouse.rwm.demo.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import static com.example.inhouse.rwm.demo.repository.util.QueryManager.COUNT_ALL_STATION_ON_ROUT;
import static com.example.inhouse.rwm.demo.repository.util.QueryManager.COUNT_STATION_BETWEEN_TWO_STATIONS;

@Repository
public interface StationRepository extends BaseRepository<Station> {

    Station getByNameContainingIgnoreCase(String name);

    @Query(nativeQuery = true, value = COUNT_STATION_BETWEEN_TWO_STATIONS)
    Integer countBetweenStations(@Param("trainId") Long trainId,
                                 @Param("date") LocalDate date,
                                 @Param("station1") Long stationFirstId,
                                 @Param("station2") Long stationSecondId);

    @Query(nativeQuery = true, value = COUNT_ALL_STATION_ON_ROUT)
    Integer countAllStationOnRout(@Param("trainId") Long trainId,
                                  @Param("date") LocalDate date);
}
