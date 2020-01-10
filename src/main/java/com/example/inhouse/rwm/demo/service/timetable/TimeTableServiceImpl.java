package com.example.inhouse.rwm.demo.service.timetable;

import com.example.inhouse.rwm.demo.common.exception.NotFoundException;
import com.example.inhouse.rwm.demo.domein.timetable.Station;
import com.example.inhouse.rwm.demo.domein.timetable.TimeTable;
import com.example.inhouse.rwm.demo.domein.train.Train;
import com.example.inhouse.rwm.demo.model.PageRequest;
import com.example.inhouse.rwm.demo.model.timetable.AddOrUpdateTimeTableRequest;
import com.example.inhouse.rwm.demo.model.timetable.FullTimeTableDto;
import com.example.inhouse.rwm.demo.repository.timetable.TimeTableRepository;
import com.example.inhouse.rwm.demo.service.common.DateManager;
import com.example.inhouse.rwm.demo.service.station.StationService;
import com.example.inhouse.rwm.demo.service.train.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.OperationNotSupportedException;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TimeTableServiceImpl implements TimeTableService {

    private final TimeTableRepository repository;
    private final TrainService trainService;
    private final StationService stationService;

    @Override
    public List<FullTimeTableDto> getByStationsAndDate(Long departureStationId, Long arrivalStationId, String date) {
        return repository.findByDepartureStAndArrivalStAddDate(arrivalStationId, departureStationId, DateManager.parse(date));
    }

    @Override
    public Page<FullTimeTableDto> getByStationsAndDate(Long departureStationId, Long arrivalStationId,
                                                       String date, PageRequest pageRequest) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("pagination not supported");
    }

    @Override
    public TimeTable getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("TimeTable is not found with identity: " + id));
    }

    @Override
    @Transactional
    public TimeTable add(AddOrUpdateTimeTableRequest request) {
        Train train = trainService.getById(request.getTrainId());
        Station station = stationService.getById(request.getTrainId());

        TimeTable timeTable = new TimeTable(train, station, request.getArrivalTime());
        return repository.save(timeTable);
    }

    @Override
    @Transactional
    public TimeTable update(Long id, AddOrUpdateTimeTableRequest request) {
        TimeTable timeTable = getById(id);

        Train train = trainService.getById(request.getTrainId());
        Station station = stationService.getById(request.getTrainId());

        timeTable.setTrain(train);
        timeTable.setStation(station);
        timeTable.setArrivalTime(request.getArrivalTime());
        return timeTable;
    }
}
