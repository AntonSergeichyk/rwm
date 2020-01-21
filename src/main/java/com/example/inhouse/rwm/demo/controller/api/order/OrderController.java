package com.example.inhouse.rwm.demo.controller.api.order;

import com.example.inhouse.rwm.demo.model.common.OperationSuccess;
import com.example.inhouse.rwm.demo.model.order.AddOrderRequest;
import com.example.inhouse.rwm.demo.model.order.OrderDto;
import com.example.inhouse.rwm.demo.model.order.OrderStationsCache;
import com.example.inhouse.rwm.demo.model.order.PlaceCache;
import com.example.inhouse.rwm.demo.service.order.OrderService;
import com.example.inhouse.rwm.demo.service.order.cache.OrderCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;
    private final OrderCacheService cacheOrderService;

    @GetMapping("/orderId")
    public OrderDto getById(@PathVariable Long orderId) {
        return new OrderDto(service.getById(orderId));
    }

    @PostMapping("/create")
    public OrderDto add(HttpServletRequest request,
                           @RequestBody AddOrderRequest orderRequest) {
        return new OrderDto(service.add(request, orderRequest));
    }

    @PostMapping("/station/cache")
    public OperationSuccess cacheArrivalAndDepartureStations(HttpServletRequest request,
                                                             @RequestBody OrderStationsCache orderStationsRequest) {
        return cacheOrderService.addCacheTimeTable(request, orderStationsRequest);
    }

    @PostMapping("/place/cache")
    public OperationSuccess cachePlace(HttpServletRequest request,
                                       @RequestBody PlaceCache placeCache) {
        return cacheOrderService.addCachePlace(request, placeCache);
    }

    @GetMapping("/reset/cache")
    public OperationSuccess resetCache(HttpServletRequest request) {
        return cacheOrderService.clearCache(request);
    }
}
