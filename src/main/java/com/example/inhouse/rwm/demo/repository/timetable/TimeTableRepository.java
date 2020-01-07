package com.example.inhouse.rwm.demo.repository.timetable;

import com.example.inhouse.rwm.demo.domein.timetable.TimeTable;
import com.example.inhouse.rwm.demo.model.PageRequest;
import com.example.inhouse.rwm.demo.model.timetable.FullTimeTableDto;
import com.example.inhouse.rwm.demo.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.example.inhouse.rwm.demo.repository.util.QueryManager.FIND_BY_DEPARTURE_ST_AND_ARRIVAL_ST_AND_DATE;

@Repository
public interface TimeTableRepository extends BaseRepository<TimeTable> {

    @Query(nativeQuery = true, value = FIND_BY_DEPARTURE_ST_AND_ARRIVAL_ST_AND_DATE)
    <T> List<T> findByDepartureStAndArrivalStAddDate(@Param("station1") Long departureStationId,
                                                     @Param("station2") Long arrivalStationId,
                                                     @Param("date") LocalDate date);

//    @Query(nativeQuery = true, value = FIND_BY_DEPARTURE_ST_AND_ARRIVAL_ST_AND_DATE,
//            countQuery = FIND_BY_DEPARTURE_ST_AND_ARRIVAL_ST_AND_DATE)
//    Page<FullTimeTableDto> findByDepartureStAndArrivalStAddDate(@Param("station1") Long departureStationId,
//                                                                @Param("station2") Long arrivalStationId,
//                                                                @Param("date") LocalDate date,
//                                                                PageRequest pageRequest);
}
