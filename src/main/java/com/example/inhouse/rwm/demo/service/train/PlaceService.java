package com.example.inhouse.rwm.demo.service.train;

import com.example.inhouse.rwm.demo.domein.train.Place;

import java.util.List;

public interface PlaceService {

    Integer getCountFreeByWaggonId(Long waggonId);

    List<Place> getByWaggonId(Long waggonId, Boolean bought);

    List<Place> getByWaggonIdWithCost(Long waggonId, Boolean bought);

    Place getById(Long placeId);

    Place reserve(Long placeId);

    Place removeReservation(Long placeId);

    Place bay(Long placeId);

    Place giveAway(Long placeId);
}
