package com.example.inhouse.rwm.demo.service.ticket;

import com.example.inhouse.rwm.demo.domein.ticket.Ticket;
import com.example.inhouse.rwm.demo.model.ticket.AddOrUpdateTicketRequest;

public interface TicketService {

    Ticket getById(Long ticketId);

    Ticket add(AddOrUpdateTicketRequest request);
}
