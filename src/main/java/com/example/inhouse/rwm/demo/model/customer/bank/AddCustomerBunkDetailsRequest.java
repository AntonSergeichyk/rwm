package com.example.inhouse.rwm.demo.model.customer.bank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCustomerBunkDetailsRequest {

    private String paymentAccountId;
    private String tin;
    private String bankAccountNumber;
}
