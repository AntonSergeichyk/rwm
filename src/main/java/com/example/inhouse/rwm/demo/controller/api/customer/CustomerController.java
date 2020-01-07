package com.example.inhouse.rwm.demo.controller.api.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.model.PageRequest;
import com.example.inhouse.rwm.demo.model.PageResponse;
import com.example.inhouse.rwm.demo.model.customer.AddOrUpdateCustomerRequest;
import com.example.inhouse.rwm.demo.model.customer.CustomerDto;
import com.example.inhouse.rwm.demo.service.customer.CustomerAdvancedDetailsService;
import com.example.inhouse.rwm.demo.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;
    private final CustomerAdvancedDetailsService advancedDetailsService;

    @GetMapping("/list")
    public List<CustomerDto> getAll() {
        return service.getAll().stream().map(CustomerDto::new).collect(Collectors.toList());
    }

    @GetMapping
    public PageResponse<CustomerDto> getAll(PageRequest pageRequest) {
        Page<Customer> pageCustomer = service.getAll(pageRequest);
        List<CustomerDto> customers = pageCustomer.stream().map(CustomerDto::new).collect(Collectors.toList());
        return new PageResponse<CustomerDto>(pageCustomer.getTotalElements(), customers);
    }

    @GetMapping("/{customerIdentity}")
    public CustomerDto getByIdentity(@PathVariable UUID customerIdentity) {
        return new CustomerDto(service.getByIdentity(customerIdentity));
    }

    @GetMapping("/{email}/email")
    public CustomerDto getByEmail(@PathVariable String email) {
        return new CustomerDto(service.getByEmail(email));
    }

    @PostMapping
    public CustomerDto add(@RequestBody AddOrUpdateCustomerRequest request) {
        return new CustomerDto(service.add(request));
    }

    @PutMapping("/{customerIdentity}")
    public CustomerDto update(@PathVariable UUID customerIdentity,
                              @RequestBody AddOrUpdateCustomerRequest request) {
        return new CustomerDto(service.update(customerIdentity, request));
    }

    @GetMapping("/order/{orderId}")
    public CustomerDto getCustomerByOrder(@PathVariable Long orderId) {
        return new CustomerDto(advancedDetailsService.getCustomerByOrderId(orderId).getCustomer());
    }
}
