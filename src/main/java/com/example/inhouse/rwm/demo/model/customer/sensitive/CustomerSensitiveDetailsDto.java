package com.example.inhouse.rwm.demo.model.customer.sensitive;

import com.example.inhouse.rwm.demo.domein.customer.CustomerSensitiveDetails;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class CustomerSensitiveDetailsDto {

    private Long id;
    private String passportId;
    private String passportIssuer;
    private LocalDate passportIssuedDate;
    private LocalDate passportExpireDate;
    private String firstNameRus;
    private String middleNameRus;
    private String lastNameRus;
    private String citizenship;
    private Long customerId;

    public CustomerSensitiveDetailsDto(CustomerSensitiveDetails sensitiveDetails) {
        if (sensitiveDetails == null) {
            return;
        }
        this.id = sensitiveDetails.getId();
        this.passportId = sensitiveDetails.getPassportId();
        this.passportIssuer = sensitiveDetails.getPassportIssuer();
        this.passportIssuedDate = sensitiveDetails.getPassportIssuedDate();
        this.passportExpireDate = sensitiveDetails.getPassportExpireDate();
        this.firstNameRus = sensitiveDetails.getFirstNameRus();
        this.middleNameRus = sensitiveDetails.getMiddleNameRus();
        this.lastNameRus = sensitiveDetails.getLastNameRus();
        this.citizenship = sensitiveDetails.getCitizenship();
        this.customerId = sensitiveDetails.getCustomer().getId();
    }
}
