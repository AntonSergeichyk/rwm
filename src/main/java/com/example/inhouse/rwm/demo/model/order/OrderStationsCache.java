package com.example.inhouse.rwm.demo.model.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderStationsCache {

    private Long departureStationId;
    private String departureTime;
    private Long arrivalStationId;
    private String arrivalTime;
}
