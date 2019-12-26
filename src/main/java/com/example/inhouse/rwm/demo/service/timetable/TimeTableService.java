package com.example.inhouse.rwm.demo.service.timetable;

import com.example.inhouse.rwm.demo.domein.timetable.Station;
import com.example.inhouse.rwm.demo.domein.timetable.TimeTable;
import com.example.inhouse.rwm.demo.model.PageRequest;
import com.example.inhouse.rwm.demo.model.timetable.AddOrUpdateTimeTableRequest;
import com.example.inhouse.rwm.demo.model.timetable.TimeTableDto;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TimeTableService {

    Page<TimeTableDto> getByStationsAddDate(Long departureStationId, Long arrivalStationId,
                                            LocalDate date, PageRequest pageRequest);

    List<TimeTableDto> getByStationsAddDate(Long departureStationId, Long arrivalStationId, LocalDate date);

    Optional<TimeTable> getById(Long id);

    TimeTable add(AddOrUpdateTimeTableRequest request);

    TimeTable update(Long id, AddOrUpdateTimeTableRequest request);
}
