package com.example.inhouse.rwm.demo.model.customer.bank;

import com.example.inhouse.rwm.demo.domein.customer.CustomerBankDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerBankDetailsDto {

    private Long id;
    private String paymentAccountId;
    private String tin;
    private String bankAccountNumber;
    private Long customerId;

    public CustomerBankDetailsDto(CustomerBankDetails bankDetails) {
        if (bankDetails == null){
            return;
        }
        this.id = bankDetails.getId();
        this.paymentAccountId = bankDetails.getPaymentAccountId();
        this.tin = bankDetails.getTin();
        this.bankAccountNumber = bankDetails.getBankAccountNumber();
        this.customerId = bankDetails.getCustomer().getId();
    }
}
