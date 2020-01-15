package com.example.inhouse.rwm.demo.service.order;

import com.example.inhouse.rwm.demo.common.exception.NotFoundException;
import com.example.inhouse.rwm.demo.domein.order.Order;
import com.example.inhouse.rwm.demo.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Override
    public Order getById(Long orderId) {
        return repository.findById(orderId).orElseThrow(() -> new NotFoundException("Order is not found with identity: " + orderId));
    }
}
