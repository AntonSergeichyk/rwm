package com.example.inhouse.rwm.demo.controller.api.timetable;

import com.example.inhouse.rwm.demo.model.PageRequest;
import com.example.inhouse.rwm.demo.model.PageResponse;
import com.example.inhouse.rwm.demo.model.timetable.AddOrUpdateTimeTableRequest;
import com.example.inhouse.rwm.demo.model.timetable.FullTimeTableDto;
import com.example.inhouse.rwm.demo.model.timetable.TimeTableDto;
import com.example.inhouse.rwm.demo.service.timetable.TimeTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/timeTable")
@RequiredArgsConstructor
public class TimeTableController {

    private final TimeTableService service;

    @GetMapping("/list")
    public List<FullTimeTableDto> getByStationsAndDate(@RequestParam Long departureStationId,
                                                       @RequestParam Long arrivalStationId,
                                                       @RequestParam String date) {
        return service.getByStationsAndDate(departureStationId, arrivalStationId, date);
    }

    @GetMapping
    public PageResponse<FullTimeTableDto> getByStationsAndDate(@RequestParam Long departureStationId,
                                                       @RequestParam Long arrivalStationId,
                                                       @RequestParam String date,
                                                       PageRequest pageRequest) {
        return new PageResponse<FullTimeTableDto>(service.getByStationsAndDate(departureStationId, arrivalStationId, date, pageRequest));
    }

    @GetMapping("/{timetableId}")
    public TimeTableDto getById(@PathVariable Long timetableId) {
        return new TimeTableDto(service.getById(timetableId));
    }

    @PostMapping
    public TimeTableDto add(@RequestBody AddOrUpdateTimeTableRequest request) {
        return new TimeTableDto(service.add(request));
    }

    @PutMapping("/{timetableId}")
    public TimeTableDto update(@PathVariable Long timetableId,
                               @RequestBody AddOrUpdateTimeTableRequest request) {
        return new TimeTableDto(service.update(timetableId, request));
    }
}
