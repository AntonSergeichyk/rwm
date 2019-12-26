package com.example.inhouse.rwm.demo.service.customer;

import com.example.inhouse.rwm.demo.domein.customer.CustomerAdvancedDetails;

public interface CustomerAdvancedDetailsService {

    CustomerAdvancedDetails getCustomerByOrderId(Long orderId);
}
