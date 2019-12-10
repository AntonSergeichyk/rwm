package com.example.inhouse.rwm.demo.domein.timetable;

import com.example.inhouse.rwm.demo.domein.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "station", schema = "rwm_storage")
public class Station extends BaseEntity {

    @Column(name = "name")
    private String name;
}
