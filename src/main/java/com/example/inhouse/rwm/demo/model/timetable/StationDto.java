package com.example.inhouse.rwm.demo.model.timetable;

import com.example.inhouse.rwm.demo.domein.timetable.Station;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StationDto {

    private Long id;
    private String name;

    public StationDto(Station station) {
        if (station == null){
            return;
        }
        this.id = station.getId();
        this.name = station.getName();
    }
}
