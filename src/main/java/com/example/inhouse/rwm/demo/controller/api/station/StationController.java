package com.example.inhouse.rwm.demo.controller.api.station;

import com.example.inhouse.rwm.demo.domein.timetable.Station;
import com.example.inhouse.rwm.demo.model.PageRequest;
import com.example.inhouse.rwm.demo.model.PageResponse;
import com.example.inhouse.rwm.demo.model.timetable.AddOrUpdateStationRequest;
import com.example.inhouse.rwm.demo.model.timetable.StationDto;
import com.example.inhouse.rwm.demo.service.timetable.station.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/station")
@RequiredArgsConstructor
public class StationController {

    private final StationService service;

    @GetMapping("/list")
    public List<StationDto> findAll() {
        return service.getAll().stream().map(StationDto::new).collect(Collectors.toList());
    }

    @GetMapping
    public PageResponse<StationDto> findAll(PageRequest pageRequest) {
        Page<Station> pageStations = service.getAll(pageRequest);
        List<StationDto> stations = pageStations.stream().map(StationDto::new).collect(Collectors.toList());
        return new PageResponse<StationDto>(pageStations.getTotalElements(), stations);
    }

    @GetMapping("/{stationId}")
    public StationDto findById(@PathVariable Long stationId) {
        return new StationDto(service.getById(stationId));
    }

    @GetMapping("/{name}/name")
    public StationDto getByName(@PathVariable String name) {
        return new StationDto(service.getByName(name));
    }

    @PostMapping
    public StationDto add(@RequestBody AddOrUpdateStationRequest request) {
        return new StationDto(service.add(request));
    }

    @PutMapping("/{stationId}")
    public StationDto update(@PathVariable Long stationId,
                             @RequestBody AddOrUpdateStationRequest request) {
        return new StationDto(service.update(stationId, request));
    }
}
