package com.example.inhouse.rwm.demo.domein.train;

import com.example.inhouse.rwm.demo.domein.BaseEntity;
import com.example.inhouse.rwm.demo.domein.dictionary.train.WaggonType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

import static javax.persistence.EnumType.STRING;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "waggon", schema = "rwm_storage")
public class Waggon extends BaseEntity {

    @Column(name = "number", nullable = false)
    private Integer number;

    @Enumerated(value = STRING)
    @Column(name = "waggon_type", nullable = false)
    private WaggonType waggonType;

    @OneToMany(mappedBy = "waggon")
    private Set<Place> places;

    @Column(name = "bought", nullable = false)
    private Boolean bought;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;
}
