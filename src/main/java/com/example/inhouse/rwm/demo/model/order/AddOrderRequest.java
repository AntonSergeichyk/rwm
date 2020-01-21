package com.example.inhouse.rwm.demo.model.order;

import com.example.inhouse.rwm.demo.domein.dictionary.order.PassengerType;
import com.example.inhouse.rwm.demo.domein.dictionary.order.Rate;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AddOrderRequest {

    private Long ticketId;
    private PassengerType passengerType;
    private Rate rate;
    private UUID customerIdentity;
}
