package com.example.inhouse.rwm.demo.service.order;

import com.example.inhouse.rwm.demo.domein.order.Order;

public interface OrderService {

    Order getById(Long orderId);
}
