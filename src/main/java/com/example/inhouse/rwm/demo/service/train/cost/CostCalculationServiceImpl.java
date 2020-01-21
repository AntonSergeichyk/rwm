package com.example.inhouse.rwm.demo.service.train.cost;

import com.example.inhouse.rwm.demo.domein.dictionary.order.PassengerType;
import com.example.inhouse.rwm.demo.domein.dictionary.order.Rate;
import com.example.inhouse.rwm.demo.domein.train.Place;
import com.example.inhouse.rwm.demo.model.order.OrderCache;
import com.example.inhouse.rwm.demo.service.common.DateManager;
import com.example.inhouse.rwm.demo.service.order.cache.OrderCacheService;
import com.example.inhouse.rwm.demo.service.timetable.station.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CostCalculationServiceImpl implements CostCalculationService {

    private final StationService stationService;
    private final OrderCacheService cacheService;

    @Override
    public List<Place> cost(List<Place> places, HttpServletRequest request) {
        if (places.isEmpty()) {
            return new ArrayList<>();
        }
        Place place = places.get(0);
        OrderCache order = cacheService.getOrderCache(request);
        Integer countStationsPerTrip = stationService.countBetweenStations(
                place.getWaggon().getTrain().getId(),
                DateManager.getDate(order.getDateOfLeave()),
                order.getStationLeaveId(),
                order.getStationArrivalId());
        Integer countAllStationOnRout = stationService.countAllStationOnTrip(
                place.getWaggon().getTrain().getId(),
                DateManager.getDate(order.getDateOfLeave()));
        double costFactor = (double) countAllStationOnRout / countStationsPerTrip;

        return places.stream()
                .peek((it -> it.setCost(getCost(costFactor, it))))
                .collect(Collectors.toList());
    }

    @Override
    public String amount(HttpServletRequest request, PassengerType passengerType, Rate rate) {
        OrderCache orderCache = cacheService.getOrderCache(request);
        return getAmount(orderCache, passengerType.getVal(), rate.getVal());
    }

    private String getCost(double costFactor, Place it) {
        double prevCost = Double.parseDouble(it.getCost()) * costFactor;
        double cost = new BigDecimal(prevCost).setScale(3, RoundingMode.UP).doubleValue();
        return String.valueOf(cost);
    }

    private String getAmount(OrderCache orderCache, double passengerType, double rate) {
        double prevAmount = Double.parseDouble(orderCache.getCost()) * passengerType * rate;
        double amount = new BigDecimal(prevAmount).setScale(3, RoundingMode.UP).doubleValue();
        return String.valueOf(amount);
    }
}
