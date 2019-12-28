package com.example.inhouse.rwm.demo.service.timetable;

import com.example.inhouse.rwm.demo.common.exception.NotFoundException;
import com.example.inhouse.rwm.demo.domein.timetable.Station;
import com.example.inhouse.rwm.demo.domein.timetable.TimeTable;
import com.example.inhouse.rwm.demo.domein.train.Train;
import com.example.inhouse.rwm.demo.model.timetable.AddOrUpdateTimeTableRequest;
import com.example.inhouse.rwm.demo.model.timetable.FullTimeTableDto;
import com.example.inhouse.rwm.demo.repository.timetable.TimeTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TimeTableServiceImpl implements TimeTableService {

    private final TimeTableRepository repository;

    @Override
    public List<FullTimeTableDto> getByStationsAndDate(
            Long departureStationId,
            Long arrivalStationId,
            LocalDate date) {
        return repository.findByDepartureStAndArrivalStAddDate(arrivalStationId, departureStationId, date, FullTimeTableDto.class);
    }

    //TODO
//    @Override
//    public List<FullTimeTableDto> getByStationsAndDate(
//            Long departureStationId,
//            Long arrivalStationId,
//            LocalDate date,
//            PageRequest pageRequest) {
//        return repository.findByDepartureStAndArrivalStAddDate(arrivalStationId, departureStationId,
//                date, pageRequest, FullTimeTableDto.class);
//    }

    @Override
    public TimeTable getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("TimeTable is not found with identity: " + id));
    }

    @Override
    @Transactional
    public TimeTable add(AddOrUpdateTimeTableRequest request) {
        Train train = new Train();
        train.setId(request.getTrainId());

        Station station = new Station();
        station.setId(request.getTrainId());

        TimeTable timeTable = new TimeTable(train, station, request.getArrivalTime());
        return repository.save(timeTable);
    }

    @Override
    @Transactional
    public TimeTable update(Long id, AddOrUpdateTimeTableRequest request) {
        TimeTable timeTable = getById(id);

        Train train = new Train();
        train.setId(request.getTrainId());

        Station station = new Station();
        station.setId(request.getTrainId());

        timeTable.setTrain(train);
        timeTable.setStation(station);
        timeTable.setArrivalTime(request.getArrivalTime());
        return timeTable;
    }
}
