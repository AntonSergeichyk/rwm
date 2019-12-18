package com.example.inhouse.rwm.demo.service.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.model.employee.AddOrUpdateCustomerRequest;
import com.example.inhouse.rwm.demo.repository.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static java.time.LocalDate.now;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public Customer getByIdentity(UUID identity) {
        return repository.getByIdentity(identity);
    }

    @Override
    public Customer findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<Customer> getAllByBirthdayToday() {
        return repository.findAllByBirthday(now().getMonthValue(), now().getDayOfMonth());
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Customer> getAll(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

    @Transactional
    @Override
    public Customer add(AddOrUpdateCustomerRequest request) {

        Customer customer = new Customer(request.getFirstName(), request.getLastName(), request.getEmail(),
                request.getGender(), request.getBirthDate(), request.getPhoneNumbers());

        Customer persistCustomer = repository.save(customer);

        return persistCustomer;
    }

    @Transactional
    @Override
    public Customer update(UUID identity, AddOrUpdateCustomerRequest request) {

        Customer customer = getByIdentity(identity);
        return null;
    }
}
