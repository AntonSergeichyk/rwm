package com.example.inhouse.rwm.demo.service.station;


import com.example.inhouse.rwm.demo.domein.timetable.Station;
import com.example.inhouse.rwm.demo.model.PageRequest;
import com.example.inhouse.rwm.demo.model.timetable.AddOrUpdateStationRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StationService {

    List<Station> getAll();

    Page<Station> getAll(PageRequest pageRequest);

    Station getById(Long id);

    Station getByName(String name);

    Station add(AddOrUpdateStationRequest request);

    Station update(Long id, AddOrUpdateStationRequest request);
}
