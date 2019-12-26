package com.example.inhouse.rwm.demo.model.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.domein.dictionary.common.Gender;
import com.example.inhouse.rwm.demo.model.customer.advanced.CustomerAdvancedDetailsDto;
import com.example.inhouse.rwm.demo.model.customer.bank.CustomerBankDetailsDto;
import com.example.inhouse.rwm.demo.model.customer.sensitive.CustomerSensitiveDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDto {

    private String identity;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private LocalDate birthDate;
    private List<String> phoneNumbers;
    private CustomerBankDetailsDto customerBankDetails;
    private CustomerSensitiveDetailsDto customerSensitiveDetails;
    private CustomerAdvancedDetailsDto customerAdvancedDetails;

    public CustomerDto(Customer customer) {
        if (customer == null) {
            return;
        }
        this.identity = customer.getIdentity().toString();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        this.gender = customer.getGender();
        this.birthDate = customer.getBirthDate();
        this.phoneNumbers = new ArrayList<>(customer.getPhoneNumbers());
        this.customerBankDetails = new CustomerBankDetailsDto(customer.getCustomerBankDetails());
        this.customerSensitiveDetails = new CustomerSensitiveDetailsDto(customer.getCustomerSensitiveDetails());
        this.customerAdvancedDetails = new CustomerAdvancedDetailsDto(customer.getCustomerAdvancedDetails());


    }
}
