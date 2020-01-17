package com.example.inhouse.rwm.demo.service.train;

import com.example.inhouse.rwm.demo.common.exception.NotFoundException;
import com.example.inhouse.rwm.demo.common.exception.ReservedException;
import com.example.inhouse.rwm.demo.domein.train.Place;
import com.example.inhouse.rwm.demo.repository.train.PlaceRepository;
import com.example.inhouse.rwm.demo.service.train.cost.CostCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private static final boolean BOUGHT = true;
    private static final boolean RESERVED = true;
    public static final boolean REMOVE_RESERVED = false;

    private final PlaceRepository repository;
    private final CostCalculationService costCalculationService;

    @Override
    public Integer getCountFreeByWaggonId(Long waggonId) {
        return repository.getCountFreeByWaggonId(waggonId);
    }

    @Override
    public List<Place> getByWaggonId(Long waggonId, Boolean bought) {
        return repository.getByWaggonIdAndBought(waggonId, bought);
    }

    @Override
    public List<Place> getByWaggonIdWithCost(Long waggonId, Boolean bought) {
        List<Place> places = repository.getByWaggonIdAndBought(waggonId, bought);
        String cost = costCalculationService.calculate(waggonId);
        places.forEach(it -> it.setCost(cost));
        return places;
    }

    @Override
    public Place getById(Long placeId) {
        return repository.findById(placeId).orElseThrow(() -> new NotFoundException("Place is not found with identity" + placeId));
    }

    @Override
    public Place reserve(Long placeId) {
        Place place = getById(placeId);
        if (place.getReserved().equals(RESERVED) && place.getBought().equals(BOUGHT)) {
            throw new ReservedException("The place " + placeId + " is reserved.");
        }
        place.setReserved(RESERVED);
        return place;
    }

    @Override
    public Place removeReservation(Long placeId) {
        Place place = getById(placeId);
        if (place.getBought().equals(BOUGHT)) {
            throw new ReservedException("The place " + placeId + " was bought.");
        }
        place.setReserved(REMOVE_RESERVED);
        return place;
    }

    @Override
    public Place bay(Long placeId) {
        Place place = getById(placeId);
        if (place.getBought().equals(BOUGHT)) {
            throw new ReservedException("The place " + placeId + " was bought.");
        }
        place.setBought(BOUGHT);
        return place;
    }

    @Override
    public Place giveAway(Long placeId) {
        Place place = getById(placeId);
        if (!place.getBought().equals(BOUGHT)) {
            throw new ReservedException("The place " + placeId + " was not bought.");
        }
        place.setBought(false);
        return place;
    }
}
