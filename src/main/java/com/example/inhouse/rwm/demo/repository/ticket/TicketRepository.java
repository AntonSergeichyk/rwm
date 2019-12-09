package com.example.inhouse.rwm.demo.repository.ticket;

import com.example.inhouse.rwm.demo.domein.ticket.Ticket;
import com.example.inhouse.rwm.demo.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends BaseRepository<Ticket> {
}
