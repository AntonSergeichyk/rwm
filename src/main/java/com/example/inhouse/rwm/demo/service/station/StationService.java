package com.example.inhouse.rwm.demo.service.station;


import com.example.inhouse.rwm.demo.domein.timetable.Station;
import com.example.inhouse.rwm.demo.model.PageRequest;
import com.example.inhouse.rwm.demo.model.timetable.AddOrUpdateStationRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StationService {

    Page<Station> getAll(PageRequest pageRequest);

    List<Station> getAll();

    Station getByName(String name);

    Station add(AddOrUpdateStationRequest request);

    Station update(Long id,AddOrUpdateStationRequest request);
}
