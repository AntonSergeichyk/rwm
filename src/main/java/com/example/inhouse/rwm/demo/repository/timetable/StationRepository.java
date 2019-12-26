package com.example.inhouse.rwm.demo.repository.timetable;

import com.example.inhouse.rwm.demo.domein.timetable.Station;
import com.example.inhouse.rwm.demo.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends BaseRepository<Station> {

    Station getByNameContainingIgnoreCase(String name);
}
