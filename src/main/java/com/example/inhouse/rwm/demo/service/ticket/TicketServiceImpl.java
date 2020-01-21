package com.example.inhouse.rwm.demo.service.ticket;

import com.example.inhouse.rwm.demo.common.exception.NotFoundException;
import com.example.inhouse.rwm.demo.domein.ticket.Ticket;
import com.example.inhouse.rwm.demo.domein.timetable.Station;
import com.example.inhouse.rwm.demo.domein.train.Place;
import com.example.inhouse.rwm.demo.model.order.OrderCache;
import com.example.inhouse.rwm.demo.model.ticket.AddOrUpdateTicketRequest;
import com.example.inhouse.rwm.demo.repository.ticket.TicketRepository;
import com.example.inhouse.rwm.demo.service.common.DateManager;
import com.example.inhouse.rwm.demo.service.order.cache.OrderCacheService;
import com.example.inhouse.rwm.demo.service.timetable.station.StationService;
import com.example.inhouse.rwm.demo.service.train.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository repository;
    private final OrderCacheService cacheService;
    private final StationService stationService;
    private final PlaceService placeService;

    @Override
    public Ticket getById(Long ticketId) {
        return repository.findById(ticketId).orElseThrow(() -> new NotFoundException("Ticket is not found with identity: " + ticketId));
    }

    @Transactional
    @Override
    public Ticket add(HttpServletRequest request) {
        OrderCache orderCache = cacheService.getOrderCache(request);
        Station leaveStation = stationService.getById(orderCache.getStationLeaveId());
        Station arrivalStation = stationService.getById(orderCache.getStationArrivalId());
        Place place = placeService.getById(orderCache.getPlaceId());

        Ticket ticket = new Ticket();
        ticket.setDateOfLeave(orderCache.getDateOfLeave());
        ticket.setDateOfArrival(orderCache.getDateOfArrival());
        ticket.setStationLeave(leaveStation);
        ticket.setStationArrival(arrivalStation);
        ticket.setPlace(place);
        return repository.save(ticket);
    }
}
