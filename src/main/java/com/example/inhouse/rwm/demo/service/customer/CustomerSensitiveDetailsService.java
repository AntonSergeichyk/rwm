package com.example.inhouse.rwm.demo.service.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.domein.customer.CustomerSensitiveDetails;
import com.example.inhouse.rwm.demo.model.customer.sensitive.AddCustomerSensitiveDetailsRequest;

public interface CustomerSensitiveDetailsService {

    CustomerSensitiveDetails add(AddCustomerSensitiveDetailsRequest request, Customer customer);

    void delete(CustomerSensitiveDetails sensitiveDetails);
}
