package com.example.inhouse.rwm.demo.repository.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.domein.customer.CustomerBankDetails;
import com.example.inhouse.rwm.demo.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerBankDetailsRepository extends BaseRepository<CustomerBankDetails> {

    CustomerBankDetailsRepository findByCustomer(Customer customer);
}
