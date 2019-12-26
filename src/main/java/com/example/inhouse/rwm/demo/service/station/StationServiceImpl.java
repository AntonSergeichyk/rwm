package com.example.inhouse.rwm.demo.service.station;

import com.example.inhouse.rwm.demo.domein.timetable.Station;
import com.example.inhouse.rwm.demo.model.PageRequest;
import com.example.inhouse.rwm.demo.model.timetable.AddOrUpdateStationRequest;
import com.example.inhouse.rwm.demo.repository.timetable.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StationServiceImpl implements StationService {

    private final StationRepository repository;

    @Override
    public Page<Station> getAll(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

    @Override
    public List<Station> getAll() {
        return repository.findAll();
    }

    @Override
    public Station getByName(String name) {
        return repository.getByNameContainingIgnoreCase(name);
    }

    @Transactional
    @Override
    public Station add(AddOrUpdateStationRequest request) {
        return repository.save(new Station(request.getName()));
    }

    @Transactional
    @Override
    public Station update(Long id, AddOrUpdateStationRequest request) {
        Station station = repository.getOne(id);
        station.setName(request.getName());
        return station;
    }
}
