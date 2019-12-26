package com.example.inhouse.rwm.demo.model.order;

import com.example.inhouse.rwm.demo.domein.dictionary.order.PassengerType;
import com.example.inhouse.rwm.demo.domein.dictionary.order.Rate;
import com.example.inhouse.rwm.demo.domein.order.Order;
import com.example.inhouse.rwm.demo.model.ticket.TicketDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private TicketDto ticket;
    private PassengerType passengerType;
    private Rate rate;
    private Long customerId;

    public OrderDto(Order order) {
        if (order == null) {
            return;
        }
        this.id = order.getId();
        this.ticket = new TicketDto(order.getTicket());
        this.passengerType = order.getPassengerType();
        this.rate = order.getRate();
        this.customerId = order.getCustomer().getId();
    }
}
