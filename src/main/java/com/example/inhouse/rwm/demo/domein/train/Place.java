package com.example.inhouse.rwm.demo.domein.train;

import com.example.inhouse.rwm.demo.domein.BaseEntity;
import com.example.inhouse.rwm.demo.domein.dictionary.train.PlaceType;
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
@Table(name = "place", schema = "rwm_storage")
public class Place extends BaseEntity {

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "cost", nullable = false)
    private String cost;

    @Enumerated(STRING)
    @Column(name = "place_type", nullable = false)
    private PlaceType placeType;

    @Column(name = "reserved", nullable = false)
    private Boolean reserved;

    @Column(name = "bought", nullable = false)
    private Boolean bought;

    @Column(name = "bought", nullable = false)
    private String cost;

    @ManyToOne
    @JoinColumn(name = "waggon_id", nullable = false)
    private Waggon waggon;
}
