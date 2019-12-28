package com.example.inhouse.rwm.demo.repository.customer;

import com.example.inhouse.rwm.demo.domein.customer.Customer;
import com.example.inhouse.rwm.demo.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends BaseRepository<Customer> {

    Optional<Customer> getByIdentity(UUID identity);

    Optional<Customer> findByEmail(String email);

    @Query("SELECT c FROM Customer c WHERE month(c.birthDate)=:month AND day(c.birthDate)=:day")
    List<Customer> findAllByBirthday(@Param("month") Integer month, @Param("day") Integer day);

}
