package com.example.inhouse.rwm.demo.controller.api.order;

import com.example.inhouse.rwm.demo.model.order.OrderDto;
import com.example.inhouse.rwm.demo.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @GetMapping("/orderId")
    public OrderDto getById(@PathVariable Long orderId) {
        return new OrderDto(service.getById(orderId));
    }
}
