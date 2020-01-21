package com.example.inhouse.rwm.demo.service.order;

import com.example.inhouse.rwm.demo.common.exception.NotFoundException;
import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.domein.order.Order;
import com.example.inhouse.rwm.demo.domein.ticket.Ticket;
import com.example.inhouse.rwm.demo.model.order.AddOrderRequest;
import com.example.inhouse.rwm.demo.repository.order.OrderRepository;
import com.example.inhouse.rwm.demo.service.customer.CustomerService;
import com.example.inhouse.rwm.demo.service.ticket.TicketService;
import com.example.inhouse.rwm.demo.service.train.cost.CostCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final TicketService ticketService;
    private final CostCalculationService costCalculationService;
    private final CustomerService customerService;

    @Override
    public Order getById(Long orderId) {
        return repository.findById(orderId).orElseThrow(() -> new NotFoundException("Order is not found with identity: " + orderId));
    }

    @Override
    public Order add(HttpServletRequest request, AddOrderRequest orderRequest) {
        String amount = costCalculationService.amount(request, orderRequest.getPassengerType(), orderRequest.getRate());
        Ticket persistTicket = ticketService.getById(orderRequest.getTicketId());
        Customer persistCustomer = customerService.getByIdentity(orderRequest.getCustomerIdentity());
        return new Order(persistTicket, orderRequest.getPassengerType(), orderRequest.getRate(), amount,persistCustomer);
    }
}
