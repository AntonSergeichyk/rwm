package com.example.inhouse.rwm.demo.service.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.domein.customer.CustomerSensitiveDetails;
import com.example.inhouse.rwm.demo.model.customer.sensitive.AddCustomerSensitiveDetailsRequest;
import com.example.inhouse.rwm.demo.repository.customer.CustomerSensitiveDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerSensitiveDetailsServiceImpl implements CustomerSensitiveDetailsService {

    private final CustomerSensitiveDetailsRepository repository;

    @Override
    public CustomerSensitiveDetails add(AddCustomerSensitiveDetailsRequest request, Customer customer) {
        CustomerSensitiveDetails sensitiveDetails = new CustomerSensitiveDetails(
                request.getPassportId(),
                request.getPassportIssuer(),
                request.getPassportIssuedDate(),
                request.getPassportExpireDate(),
                request.getFirstNameRus(),
                request.getMiddleNameRus(),
                request.getLastNameRus(),
                request.getCitizenship(),
                customer);
        return repository.save(sensitiveDetails);
    }

    @Override
    public void delete(CustomerSensitiveDetails sensitiveDetails) {
        repository.delete(sensitiveDetails);
        repository.flush();
    }
}
