package com.example.inhouse.rwm.demo.service.train;

import com.example.inhouse.rwm.demo.domein.train.Waggon;
import com.example.inhouse.rwm.demo.repository.train.WaggonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WaggonServiceImpl implements WaggonService {

    private final WaggonRepository repository;


    @Override
    public List<Waggon> getByTrainId(Long trainId) {
        return repository.getByTrainId(trainId);
    }

    @Override
    public List<Waggon> getFreeByTrainId(Long trainId, Boolean bought) {
        return repository.getByTrainIdAndBought(trainId, bought);
    }
}
