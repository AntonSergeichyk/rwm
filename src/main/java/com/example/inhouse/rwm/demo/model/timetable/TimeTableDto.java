package com.example.inhouse.rwm.demo.model.timetable;

import com.example.inhouse.rwm.demo.domein.timetable.TimeTable;
import com.example.inhouse.rwm.demo.model.train.TrainDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class TimeTableDto {

    private Long id;
    private TrainDto train;
    private StationDto station;
    private LocalDateTime arrivalTime;

    public TimeTableDto(TimeTable timeTable) {
        if (timeTable == null) {
            return;
        }
        this.id = timeTable.getId();
        this.train = new TrainDto(timeTable.getTrain());
        this.station = new StationDto(timeTable.getStation());
        this.arrivalTime = timeTable.getArrivalTime();
    }
}
