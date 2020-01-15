package com.example.inhouse.rwm.demo.repository.train;

import com.example.inhouse.rwm.demo.domein.train.Place;
import com.example.inhouse.rwm.demo.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends BaseRepository<Place> {

    //    @Query(value = "SELECT count(p) FROM Waggon w JOIN Place p WHERE w.id=:waggonId")
    @Query(nativeQuery = true, value = "SELECT count(p) FROM rwm_storage.waggon w JOIN rwm_storage.place p ON w.id = p.waggon_id WHERE p.bought=false AND p.waggon_id =:waggonId")
    Integer getCountFreeByWaggonId(Long waggonId);

    List<Place> getByWaggonIdAndBought(Long waggonId, Boolean bought);

}
