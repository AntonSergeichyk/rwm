package com.example.inhouse.rwm.demo.service.timetable;

import com.example.inhouse.rwm.demo.domein.timetable.TimeTable;
import com.example.inhouse.rwm.demo.model.timetable.AddOrUpdateTimeTableRequest;
import com.example.inhouse.rwm.demo.model.timetable.FullTimeTableDto;

import java.util.List;

public interface TimeTableService {

    List<FullTimeTableDto> getByStationsAndDate(Long departureStationId, Long arrivalStationId, String date);

//    TODO
//    List<FullTimeTableDto> getByStationsAndDate(Long departureStationId, Long arrivalStationId, LocalDate date, PageRequest pageRequest);

    TimeTable getById(Long id);

    TimeTable add(AddOrUpdateTimeTableRequest request);

    TimeTable update(Long id, AddOrUpdateTimeTableRequest request);
}
