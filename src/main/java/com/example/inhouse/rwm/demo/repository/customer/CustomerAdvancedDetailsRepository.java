package com.example.inhouse.rwm.demo.repository.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.domein.customer.CustomerAdvancedDetails;
import com.example.inhouse.rwm.demo.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAdvancedDetailsRepository extends BaseRepository<CustomerAdvancedDetails> {

    CustomerAdvancedDetails findByCustomer(Customer customer);
}
