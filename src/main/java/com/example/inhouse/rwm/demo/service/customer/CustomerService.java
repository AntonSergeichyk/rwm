package com.example.inhouse.rwm.demo.service.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.model.PageRequest;
import com.example.inhouse.rwm.demo.model.customer.AddOrUpdateCustomerRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getAll();

    Page<Customer> getAll(PageRequest pageRequest);

    Customer getByIdentity(UUID identity);

    Customer getByEmail(String email);

    List<Customer> getAllByBirthdayToday();

    Customer add(AddOrUpdateCustomerRequest request);

    Customer update(UUID identity, AddOrUpdateCustomerRequest request);
}
