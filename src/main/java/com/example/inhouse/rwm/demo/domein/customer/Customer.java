package com.example.inhouse.rwm.demo.domein.customer;

import com.example.inhouse.rwm.demo.domein.BaseEntity;
import com.example.inhouse.rwm.demo.domein.dictionary.common.Gender;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer", schema = "rwm_storage")
public class Customer extends BaseEntity {

    public Customer(String firstName, String lastName, String email, Gender gender,
                    LocalDate birthDate, Set<String> phoneNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phoneNumbers = phoneNumbers;
    }

    @Column(name = "identity", nullable = false, unique = true)
    private UUID identity;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Enumerated(STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @ElementCollection
    @CollectionTable(name = "customer_phone_number", schema = "rwm_storage", joinColumns = {@JoinColumn(name = "customer_id")})
    @Column(name = "phone_number", nullable = false)
    private Set<String> phoneNumbers;

    @OneToOne(mappedBy = "customer", fetch = LAZY)
    private CustomerBankDetails customerBankDetails;

    @OneToOne(mappedBy = "customer", fetch = LAZY)
    private CustomerSensitiveDetails customerSensitiveDetails;

    @OneToOne(mappedBy = "customer", fetch = LAZY)
    private CustomerAdvancedDetails customerAdvancedDetails;
}
