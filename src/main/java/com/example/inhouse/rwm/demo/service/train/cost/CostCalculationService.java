package com.example.inhouse.rwm.demo.service.train.cost;

import com.example.inhouse.rwm.demo.domein.dictionary.order.PassengerType;
import com.example.inhouse.rwm.demo.domein.dictionary.order.Rate;
import com.example.inhouse.rwm.demo.domein.train.Place;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CostCalculationService {

    List<Place> cost(List<Place> places, HttpServletRequest request);

    String amount(HttpServletRequest request, PassengerType passengerType, Rate rate);
}
