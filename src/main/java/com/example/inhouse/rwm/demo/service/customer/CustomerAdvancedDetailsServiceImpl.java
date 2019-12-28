package com.example.inhouse.rwm.demo.service.customer;

import com.example.inhouse.rwm.demo.common.exception.NotFoundException;
import com.example.inhouse.rwm.demo.domein.customer.CustomerAdvancedDetails;
import com.example.inhouse.rwm.demo.repository.customer.CustomerAdvancedDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerAdvancedDetailsServiceImpl implements CustomerAdvancedDetailsService {

    private final CustomerAdvancedDetailsRepository repository;

    @Override
    public CustomerAdvancedDetails getCustomerByOrderId(Long orderId) {
        return repository.findByOrderId(orderId)
                .orElseThrow(() -> new NotFoundException("CustomerAdvancedDetails is not found with orderId: " + orderId));
    }
}
