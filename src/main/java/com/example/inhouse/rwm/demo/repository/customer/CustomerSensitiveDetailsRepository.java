package com.example.inhouse.rwm.demo.repository.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.domein.customer.CustomerSensitiveDetails;
import com.example.inhouse.rwm.demo.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSensitiveDetailsRepository extends BaseRepository<CustomerSensitiveDetails> {

    CustomerSensitiveDetails findByCustomer(Customer customer);
}
