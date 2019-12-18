package com.example.inhouse.rwm.demo.service.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.model.employee.AddOrUpdateCustomerRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    Customer getByIdentity(UUID identity);

    Customer findByEmail(String email);

    List<Customer> getAllByBirthdayToday();

    List<Customer> getAll();

    Page<Customer> getAll(PageRequest pageRequest);

    Customer add(AddOrUpdateCustomerRequest request);

    Customer update(UUID identity, AddOrUpdateCustomerRequest request);
}
