package com.example.inhouse.rwm.demo.model.timetable;

import com.example.inhouse.rwm.demo.domein.timetable.Station;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(NON_NULL)
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
