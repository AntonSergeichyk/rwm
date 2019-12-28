package com.example.inhouse.rwm.demo.model.customer;

import com.example.inhouse.rwm.demo.domein.dictionary.common.Gender;
import com.example.inhouse.rwm.demo.model.customer.bank.AddCustomerBunkDetailsRequest;
import com.example.inhouse.rwm.demo.model.customer.sensitive.AddCustomerSensitiveDetailsRequest;
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
    private AddCustomerBunkDetailsRequest customerBunkDetailsRequest;
    private AddCustomerSensitiveDetailsRequest customerSensitiveDetailsRequest;
    private Long CustomerAdvancedDetails;
}
