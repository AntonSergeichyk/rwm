package com.example.inhouse.rwm.demo.model.customer.advanced;

import com.example.inhouse.rwm.demo.domein.customer.CustomerAdvancedDetails;
import com.example.inhouse.rwm.demo.model.order.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class CustomerAdvancedDetailsDto {

    private Long id;
    private Long customerId;
    private List<OrderDto> orders;

    public CustomerAdvancedDetailsDto(CustomerAdvancedDetails advancedDetails) {
        if (advancedDetails == null) {
            return;
        }
        this.id = advancedDetails.getId();
        this.customerId = advancedDetails.getCustomer().getId();
        this.orders = advancedDetails.getOrders().stream().map(OrderDto::new).collect(Collectors.toList());
    }
}
