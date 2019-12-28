package com.example.inhouse.rwm.demo.model.train;

import com.example.inhouse.rwm.demo.domein.dictionary.train.TrainType;
import com.example.inhouse.rwm.demo.domein.train.Train;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class TrainDto {

    private Long id;
    private Integer number;
    private String name;
    private TrainType trainType;
    private Boolean bought;


    public TrainDto(Train train) {
        if (train == null) {
            return;
        }
        this.id = train.getId();
        this.number = train.getNumber();
        this.name = train.getName();
        this.trainType = train.getTrainType();
        this.bought = train.getBought();
    }
}
