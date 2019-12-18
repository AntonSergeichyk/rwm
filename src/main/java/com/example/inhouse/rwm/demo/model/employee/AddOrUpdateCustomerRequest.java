package com.example.inhouse.rwm.demo.model.employee;

import com.example.inhouse.rwm.demo.domein.dictionary.common.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class AddOrUpdateCustomerRequest {

    private String firstName;
    private String lastName;
    private String email;
    private Set<String> phoneNumbers;
    private Gender gender;
    private LocalDate birthDate;
    private Long CustomerAdvancedDetails;

}
