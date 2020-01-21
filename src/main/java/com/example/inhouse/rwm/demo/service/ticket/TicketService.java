package com.example.inhouse.rwm.demo.service.ticket;

import com.example.inhouse.rwm.demo.domein.ticket.Ticket;

import javax.servlet.http.HttpServletRequest;

public interface TicketService {

    Ticket getById(Long ticketId);

    Ticket add(HttpServletRequest request);
}
