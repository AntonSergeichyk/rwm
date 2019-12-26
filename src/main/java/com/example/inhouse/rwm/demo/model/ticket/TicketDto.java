package com.example.inhouse.rwm.demo.model.ticket;

import com.example.inhouse.rwm.demo.domein.ticket.Ticket;
import com.example.inhouse.rwm.demo.model.train.PlaceDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TicketDto {

    private Long id;
    private LocalDateTime dateOfLeave;
    private LocalDateTime dateOfArrival;
    private String cost;
    private PlaceDto place;

    public TicketDto(Ticket ticket) {
        if (ticket == null) {
            return;
        }
        this.id = ticket.getId();
        this.dateOfLeave = ticket.getDateOfLeave();
        this.dateOfArrival = ticket.getDateOfArrival();
        this.cost = ticket.getCost();
        this.place = new PlaceDto(ticket.getPlace());

    }
}
