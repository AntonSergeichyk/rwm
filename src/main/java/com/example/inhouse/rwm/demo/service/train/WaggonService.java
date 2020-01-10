package com.example.inhouse.rwm.demo.service.train;

import com.example.inhouse.rwm.demo.domein.train.Waggon;

import java.util.List;

public interface WaggonService {

    List<Waggon> getByTrainId(Long trainId);

    List<Waggon> getFreeByTrainId(Long trainId, Boolean bought);
}
