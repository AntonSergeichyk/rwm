package com.example.inhouse.rwm.demo.service.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.domein.customer.CustomerBankDetails;
import com.example.inhouse.rwm.demo.model.customer.bank.AddCustomerBunkDetailsRequest;
import com.example.inhouse.rwm.demo.repository.customer.CustomerBankDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerBunkDetailsServiceImpl implements CustomerBunkDetailsService {

    private final CustomerBankDetailsRepository repository;

    @Override
    public CustomerBankDetails add(AddCustomerBunkDetailsRequest request, Customer customer) {
        CustomerBankDetails bankDetails = new CustomerBankDetails(request.getPaymentAccountId(),
                request.getTin(), request.getBankAccountNumber(), customer);
        return repository.save(bankDetails);
    }

    @Override
    public void delete(CustomerBankDetails bankDetails) {
        repository.delete(bankDetails);
        repository.flush();
    }
}
