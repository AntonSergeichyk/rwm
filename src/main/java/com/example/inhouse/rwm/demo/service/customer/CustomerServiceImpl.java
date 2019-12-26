package com.example.inhouse.rwm.demo.service.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.domein.customer.CustomerBankDetails;
import com.example.inhouse.rwm.demo.domein.customer.CustomerSensitiveDetails;
import com.example.inhouse.rwm.demo.model.PageRequest;
import com.example.inhouse.rwm.demo.model.customer.AddOrUpdateCustomerRequest;
import com.example.inhouse.rwm.demo.repository.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    private final CustomerBunkDetailsService bunkDetailsService;
    private final CustomerSensitiveDetailsService sensitiveDetailsService;

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
    public Page<Customer> getAll(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Customer add(AddOrUpdateCustomerRequest request) {
        Customer customer = new Customer(request.getFirstName(), request.getLastName(), request.getEmail(),
                request.getGender(), request.getBirthDate(), request.getPhoneNumbers());
        Customer persistCustomer = repository.save(customer);

        CustomerBankDetails bankDetails = bunkDetailsService.add(request.getCustomerBunkDetailsRequest(), persistCustomer);
        CustomerSensitiveDetails sensitiveDetails = sensitiveDetailsService.add(request.getCustomerSensitiveDetailsRequest(), persistCustomer);

        persistCustomer.setCustomerBankDetails(bankDetails);
        persistCustomer.setCustomerSensitiveDetails(sensitiveDetails);
        return persistCustomer;
    }

    @Transactional
    @Override
    public Customer update(UUID identity, AddOrUpdateCustomerRequest request) {
        Customer customer = getByIdentity(identity);

        bunkDetailsService.delete(customer.getCustomerBankDetails());
        sensitiveDetailsService.delete(customer.getCustomerSensitiveDetails());

        CustomerBankDetails bankDetails = bunkDetailsService.add(request.getCustomerBunkDetailsRequest(), customer);
        CustomerSensitiveDetails sensitiveDetails = sensitiveDetailsService.add(request.getCustomerSensitiveDetailsRequest(), customer);

        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setGender(request.getGender());
        customer.setBirthDate(request.getBirthDate());
        customer.setPhoneNumbers(request.getPhoneNumbers());
        customer.setCustomerBankDetails(bankDetails);
        customer.setCustomerSensitiveDetails(sensitiveDetails);

        return repository.save(customer);
    }
}
