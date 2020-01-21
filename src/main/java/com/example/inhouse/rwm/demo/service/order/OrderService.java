package com.example.inhouse.rwm.demo.service.order;

import com.example.inhouse.rwm.demo.domein.order.Order;
import com.example.inhouse.rwm.demo.model.order.AddOrderRequest;

import javax.servlet.http.HttpServletRequest;

public interface OrderService {

    Order getById(Long orderId);

    Order add(HttpServletRequest request, AddOrderRequest orderRequest);
}
