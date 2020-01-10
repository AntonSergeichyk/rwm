package com.example.inhouse.rwm.demo.repository.train;

import com.example.inhouse.rwm.demo.domein.train.Waggon;
import com.example.inhouse.rwm.demo.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaggonRepository extends BaseRepository<Waggon> {

    List<Waggon> getByTrainId(Long trainId);

    List<Waggon> getByTrainIdAndBought(Long trainId, Boolean bought);
}
