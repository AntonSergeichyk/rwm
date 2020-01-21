package com.example.inhouse.rwm.demo.model.ticket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddOrUpdateTicketRequest {

    private String dateOfLeave;
    private Long stationLeaveId;
    private String dateOfArrival;
    private Long stationArrivalId;
    private Long placeId;
}
