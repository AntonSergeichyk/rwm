package com.example.inhouse.rwm.demo.controller.api.order;

import com.example.inhouse.rwm.demo.model.common.OperationSuccess;
import com.example.inhouse.rwm.demo.model.order.OrderDto;
import com.example.inhouse.rwm.demo.model.order.OrderStationsCache;
import com.example.inhouse.rwm.demo.service.order.OrderService;
import com.example.inhouse.rwm.demo.service.order.cache.OrderCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/station/cache")
    public OperationSuccess cacheArrivalAndDepartureStations(HttpServletRequest request,
                                                             @RequestBody OrderStationsCache orderStationsRequest) {
        return cacheOrderService.addCacheTimeTable(request, orderStationsRequest);
    }

    @GetMapping("/reset/cache")
    public OperationSuccess resetCache(HttpServletRequest request) {
        return cacheOrderService.clearCache(request);
    }
}
