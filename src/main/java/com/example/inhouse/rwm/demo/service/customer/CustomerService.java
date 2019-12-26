package com.example.inhouse.rwm.demo.service.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.model.PageRequest;
import com.example.inhouse.rwm.demo.model.customer.AddOrUpdateCustomerRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    Customer getByIdentity(UUID identity);

    Customer findByEmail(String email);

    List<Customer> getAllByBirthdayToday();

    Page<Customer> getAll(PageRequest pageRequest);

    List<Customer> getAll();

    Customer add(AddOrUpdateCustomerRequest request);

    Customer update(UUID identity, AddOrUpdateCustomerRequest request);
}
