package com.example.inhouse.rwm.demo.model.order;

import com.example.inhouse.rwm.demo.domein.dictionary.order.PassengerType;
import com.example.inhouse.rwm.demo.domein.dictionary.order.Rate;
import com.example.inhouse.rwm.demo.domein.order.Order;
import com.example.inhouse.rwm.demo.model.ticket.TicketDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class OrderDto {

    private Long id;
    private TicketDto ticket;
    private PassengerType passengerType;
    private Rate rate;
    private String amount;
    private Long customerId;

    public OrderDto(Order order) {
        if (order == null) {
            return;
        }
        this.id = order.getId();
        this.ticket = new TicketDto(order.getTicket());
        this.passengerType = order.getPassengerType();
        this.rate = order.getRate();
        this.amount = order.getAmount();
        this.customerId = order.getCustomer().getId();
    }
}
