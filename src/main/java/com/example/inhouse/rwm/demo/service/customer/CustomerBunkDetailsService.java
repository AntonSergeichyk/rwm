package com.example.inhouse.rwm.demo.service.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.domein.customer.CustomerBankDetails;
import com.example.inhouse.rwm.demo.model.customer.bank.AddCustomerBunkDetailsRequest;

public interface CustomerBunkDetailsService {

    CustomerBankDetails add(AddCustomerBunkDetailsRequest request, Customer customer);

    void delete(CustomerBankDetails bankDetails);
}
