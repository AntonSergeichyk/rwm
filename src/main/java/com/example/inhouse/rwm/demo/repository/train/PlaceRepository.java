package com.example.inhouse.rwm.demo.repository.train;

import com.example.inhouse.rwm.demo.domein.train.Place;
import com.example.inhouse.rwm.demo.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends BaseRepository<Place> {

    @Query()
    Integer getCountFreeByWaggonId(Long waggonId);

    List<Place> getByWaggonIdAndBought(Long waggonId, Boolean bought);
}
