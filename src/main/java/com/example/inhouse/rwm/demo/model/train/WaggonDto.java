package com.example.inhouse.rwm.demo.model.train;

import com.example.inhouse.rwm.demo.domein.dictionary.train.WaggonType;
import com.example.inhouse.rwm.demo.domein.train.Waggon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WaggonDto {

    private Long id;
    private Integer number;
    private WaggonType waggonType;
    private Boolean bought;
    private TrainDto train;

    public WaggonDto(Waggon waggon) {
        if (waggon == null) {
            return;
        }
        this.id = waggon.getId();
        this.number = waggon.getNumber();
        this.waggonType = waggon.getWaggonType();
        this.bought = waggon.getBought();
        this.train = new TrainDto(waggon.getTrain());
    }
}
