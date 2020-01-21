package com.example.inhouse.rwm.demo.model.train;

import com.example.inhouse.rwm.demo.domein.dictionary.train.PlaceType;
import com.example.inhouse.rwm.demo.domein.train.Place;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class PlaceDto {

    private Long id;
    private Integer number;
    private String cost;
    private PlaceType placeType;
    private Boolean reserved;
    private Boolean bought;
    private String cost;
    private WaggonDto waggon;

    public PlaceDto(Place place) {
        if (place == null) {
            return;
        }
        this.id = place.getId();
        this.number = place.getNumber();
        this.cost = place.getCost();
        this.placeType = place.getPlaceType();
        this.reserved = place.getReserved();
        this.bought = place.getBought();
        this.cost = place.getCost();
        this.waggon = new WaggonDto(place.getWaggon());
    }
}
