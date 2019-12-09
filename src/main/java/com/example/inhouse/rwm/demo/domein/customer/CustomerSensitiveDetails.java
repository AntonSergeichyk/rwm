package com.example.inhouse.rwm.demo.domein.customer;

import com.example.inhouse.rwm.demo.domein.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_sensitive_details", schema = "rwm_storage")
public class CustomerSensitiveDetails extends BaseEntity {

    @Column(name = "passport_id")
    private String passportId;

    @Column(name = "passport_issuer")
    private String passportIssuer;

    @Column(name = "passport_issued_date")
    private LocalDate passportIssuedDate;

    @Column(name = "passport_expire_date")
    private LocalDate passportExpireDate;

    @Column(name = "first_name_rus")
    private String firstNameRus;

    @Column(name = "middle_name_rus")
    private String middleNameRus;

    @Column(name = "last_name_rus")
    private String lastNameRus;

    @Column(name = "citizenship")
    private String citizenship;

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
