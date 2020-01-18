package com.example.inhouse.rwm.demo.service.timetable;

import com.example.inhouse.rwm.demo.domein.timetable.TimeTable;
import com.example.inhouse.rwm.demo.model.PageRequest;
import com.example.inhouse.rwm.demo.model.timetable.AddOrUpdateTimeTableRequest;
import com.example.inhouse.rwm.demo.model.timetable.FullTimeTableDto;
import org.springframework.data.domain.Page;

import javax.naming.OperationNotSupportedException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TimeTableService {

    List<FullTimeTableDto> getByStationsAndDate(Long departureStationId, Long arrivalStationId, String date);

    Page<FullTimeTableDto> getByStationsAndDate(Long departureStationId, Long arrivalStationId, String date, PageRequest pageRequest) throws OperationNotSupportedException;

    TimeTable getById(Long id);

    TimeTable add(AddOrUpdateTimeTableRequest request);

    TimeTable update(Long id, AddOrUpdateTimeTableRequest request);
}
