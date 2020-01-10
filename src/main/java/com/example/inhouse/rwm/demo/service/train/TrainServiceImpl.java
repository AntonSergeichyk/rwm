package com.example.inhouse.rwm.demo.service.train;

import com.example.inhouse.rwm.demo.common.exception.NotFoundException;
import com.example.inhouse.rwm.demo.domein.train.Train;
import com.example.inhouse.rwm.demo.repository.train.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TrainServiceImpl implements TrainService {

    private final TrainRepository repository;

    @Override
    public Train getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Train is not found with identity: " + id));
    }
}
