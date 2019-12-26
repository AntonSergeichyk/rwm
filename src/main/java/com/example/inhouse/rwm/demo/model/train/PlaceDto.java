package com.example.inhouse.rwm.demo.model.train;

import com.example.inhouse.rwm.demo.domein.dictionary.train.PlaceType;
import com.example.inhouse.rwm.demo.domein.train.Place;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlaceDto {

    private Long id;
    private Integer number;
    private PlaceType placeType;
    private Boolean reserved;
    private Boolean bought;
    private WaggonDto waggon;

    public PlaceDto(Place place) {
        if (place == null) {
            return;
        }
        this.id = place.getId();
        this.number = place.getNumber();
        this.placeType = place.getPlaceType();
        this.reserved = place.getReserved();
        this.bought = place.getBought();
        this.waggon = new WaggonDto(place.getWaggon());
    }
}
