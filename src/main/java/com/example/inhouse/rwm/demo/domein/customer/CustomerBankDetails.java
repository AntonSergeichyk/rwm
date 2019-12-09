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

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_bank_details", schema = "rwm_storage")
public class CustomerBankDetails extends BaseEntity {

    @Column(name = "payment_account_id")
    private String paymentAccountId;

    @Column(name = "tin")
    private String tin;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
