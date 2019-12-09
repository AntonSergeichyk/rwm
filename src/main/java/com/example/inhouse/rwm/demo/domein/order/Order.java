package com.example.inhouse.rwm.demo.domein.order;

import com.example.inhouse.rwm.demo.domein.BaseEntity;
import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.domein.dictionary.order.PassengerType;
import com.example.inhouse.rwm.demo.domein.dictionary.order.Rate;
import com.example.inhouse.rwm.demo.domein.ticket.Ticket;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.EnumType.STRING;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order", schema = "rwm_storage")
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @Enumerated(STRING)
    @Column(name = "passenger_type", nullable = false)
    private PassengerType passengerType;

    @Enumerated(STRING)
    @Column(name = "rate", nullable = false)
    private Rate rate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
