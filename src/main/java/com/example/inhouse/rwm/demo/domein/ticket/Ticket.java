package com.example.inhouse.rwm.demo.domein.ticket;

import com.example.inhouse.rwm.demo.domein.BaseEntity;
import com.example.inhouse.rwm.demo.domein.train.Place;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket", schema = "rwm_storage")
public class Ticket extends BaseEntity {

    @Column(name = "date_of_leave", nullable = false)
    private LocalDateTime dateOfLeave;

    @Column(name = "date_of_arrival", nullable = false)
    private LocalDateTime dateOfArrival;

    @Column(name = "cost", nullable = false)
    private String cost;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;
}
