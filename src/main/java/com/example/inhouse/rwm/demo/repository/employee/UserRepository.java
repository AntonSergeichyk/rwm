package com.example.inhouse.rwm.demo.repository.employee;

import com.example.inhouse.rwm.demo.domein.employee.User;
import com.example.inhouse.rwm.demo.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {
}
