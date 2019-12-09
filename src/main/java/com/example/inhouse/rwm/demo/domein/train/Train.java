package com.example.inhouse.rwm.demo.domein.train;

import com.example.inhouse.rwm.demo.domein.BaseEntity;
import com.example.inhouse.rwm.demo.domein.dictionary.train.TrainType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import static javax.persistence.EnumType.STRING;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "train", schema = "rwm_storage")
public class Train extends BaseEntity {

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(STRING)
    @Column(name = "train_type", nullable = false)
    private TrainType trainType;

    @Column(name = "bought", nullable = false)
    private Boolean bought;
}
