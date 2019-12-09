package com.example.inhouse.rwm.demo.domein.timetable;

import com.example.inhouse.rwm.demo.domein.BaseEntity;
import com.example.inhouse.rwm.demo.domein.train.Train;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "timetable", schema = "rwm_storage")
public class TimeTable extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @OneToMany(mappedBy = "timeTable")
    private Set<Station> stations;
}
