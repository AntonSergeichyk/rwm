package com.example.inhouse.rwm.demo.service.train;

import com.example.inhouse.rwm.demo.domein.train.Place;
import com.example.inhouse.rwm.demo.repository.train.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository repository;

    @Override
    public Integer getCountFreeByWaggonId(Long waggonId) {
        return repository.getCountFreeByWaggonId(waggonId);
    }

    @Override
    public List<Place> getByWaggonId(Long waggonId, Boolean bought) {
        return repository.getByWaggonIdAndBought(waggonId, bought);
    }
}
