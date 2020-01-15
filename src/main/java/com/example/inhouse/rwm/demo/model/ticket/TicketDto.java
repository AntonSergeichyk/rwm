package com.example.inhouse.rwm.demo.model.ticket;

import com.example.inhouse.rwm.demo.domein.ticket.Ticket;
import com.example.inhouse.rwm.demo.domein.timetable.Station;
import com.example.inhouse.rwm.demo.model.train.PlaceDto;
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
public class TicketDto {

    private Long id;
    private LocalDateTime dateOfLeave;
    private LocalDateTime dateOfArrival;
    private Station stationLeave;
    private Station stationArrival;
    private String cost;
    private PlaceDto place;

    public TicketDto(Ticket ticket) {
        if (ticket == null) {
            return;
        }
        this.id = ticket.getId();
        this.dateOfLeave = ticket.getDateOfLeave();
        this.dateOfArrival = ticket.getDateOfArrival();
        this.stationLeave = ticket.getStationLeave();
        this.stationArrival = ticket.getStationArrival();
        this.cost = ticket.getCost();
        this.place = new PlaceDto(ticket.getPlace());

    }
}
