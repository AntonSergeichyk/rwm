package com.example.inhouse.rwm.demo.domein.customer;

import com.example.inhouse.rwm.demo.domein.BaseEntity;
import com.example.inhouse.rwm.demo.domein.dictionary.common.Gender;
import lombok.*;

import javax.persistence.*;
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
    @Column(name = "phone_number")
    private Set<String> phoneNumbers;

    @OneToOne(mappedBy = "customer", fetch = LAZY)
    private CustomerAdvancedDetails customerAdvancedDetails;
}
