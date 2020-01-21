package com.example.inhouse.rwm.demo.service.timetable.station;


import com.example.inhouse.rwm.demo.domein.timetable.Station;
import com.example.inhouse.rwm.demo.model.PageRequest;
import com.example.inhouse.rwm.demo.model.timetable.AddOrUpdateStationRequest;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface StationService {

    List<Station> getAll();

    Page<Station> getAll(PageRequest pageRequest);

    Station getById(Long id);

    Station getByName(String name);

    Station add(AddOrUpdateStationRequest request);

    Station update(Long id, AddOrUpdateStationRequest request);

    Integer countBetweenStations(Long trainId, LocalDate date, Long stationFirstId, Long stationSecondId);

    Integer countAllStationOnTrip(Long trainId, LocalDate date);
}
