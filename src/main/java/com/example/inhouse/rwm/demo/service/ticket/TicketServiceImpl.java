package com.example.inhouse.rwm.demo.service.ticket;

import com.example.inhouse.rwm.demo.common.exception.NotFoundException;
import com.example.inhouse.rwm.demo.domein.ticket.Ticket;
import com.example.inhouse.rwm.demo.domein.timetable.Station;
import com.example.inhouse.rwm.demo.domein.train.Place;
import com.example.inhouse.rwm.demo.model.ticket.AddOrUpdateTicketRequest;
import com.example.inhouse.rwm.demo.repository.ticket.TicketRepository;
import com.example.inhouse.rwm.demo.service.common.DateManager;
import com.example.inhouse.rwm.demo.service.station.StationService;
import com.example.inhouse.rwm.demo.service.train.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository repository;
    private final StationService stationService;
    private final PlaceService placeService;

    @Override
    public Ticket getById(Long ticketId) {
        return repository.findById(ticketId).orElseThrow(() -> new NotFoundException("Ticket is not found with identity: " + ticketId));
    }

    @Override
    public Ticket add(AddOrUpdateTicketRequest request) {
        Station leaveStation = stationService.getById(request.getStationLeaveId());
        Station arrivalStation = stationService.getById(request.getStationArrivalId());
        Place place = placeService.getById(request.getPlaceId());

        Ticket ticket = new Ticket();
        ticket.setCost(request.getCost());
        ticket.setDateOfLeave(DateManager.parseDateTime(request.getDateOfLeave()));
        ticket.setDateOfArrival(DateManager.parseDateTime(request.getDateOfArrival()));
        ticket.setStationLeave(leaveStation);
        ticket.setStationArrival(arrivalStation);
        ticket.setPlace(place);
        return repository.save(ticket);
    }
}
