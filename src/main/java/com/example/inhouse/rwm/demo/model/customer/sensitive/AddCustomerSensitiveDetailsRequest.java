package com.example.inhouse.rwm.demo.model.customer.sensitive;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AddCustomerSensitiveDetailsRequest {

    private String passportId;
    private String passportIssuer;
    private LocalDate passportIssuedDate;
    private LocalDate passportExpireDate;
    private String firstNameRus;
    private String middleNameRus;
    private String lastNameRus;
    private String citizenship;
}
