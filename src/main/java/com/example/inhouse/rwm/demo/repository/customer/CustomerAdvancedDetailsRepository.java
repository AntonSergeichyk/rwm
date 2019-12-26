package com.example.inhouse.rwm.demo.repository.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.domein.customer.CustomerAdvancedDetails;
import com.example.inhouse.rwm.demo.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAdvancedDetailsRepository extends BaseRepository<CustomerAdvancedDetails> {

    CustomerAdvancedDetails findByCustomer(Customer customer);

    @Query("SELECT c FROM Order o JOIN CustomerAdvancedDetails ca JOIN Customer c  WHERE o.id=:orderId")
    CustomerAdvancedDetails findByOrderId(@Param("orderId") Long orderId);
}
