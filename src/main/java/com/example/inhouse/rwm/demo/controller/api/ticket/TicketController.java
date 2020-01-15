package com.example.inhouse.rwm.demo.controller.api.ticket;

import com.example.inhouse.rwm.demo.model.ticket.AddOrUpdateTicketRequest;
import com.example.inhouse.rwm.demo.model.ticket.TicketDto;
import com.example.inhouse.rwm.demo.service.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService service;

    @GetMapping("/ticketId")
    public TicketDto getById(@PathVariable Long ticketId) {
        return new TicketDto(service.getById(ticketId));
    }

    @PostMapping
    public TicketDto add(@RequestBody AddOrUpdateTicketRequest request) {
        return new TicketDto(service.add(request));
    }
}
