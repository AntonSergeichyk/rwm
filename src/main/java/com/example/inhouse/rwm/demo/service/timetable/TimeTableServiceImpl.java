package com.example.inhouse.rwm.demo.service.timetable;

import com.example.inhouse.rwm.demo.domein.timetable.Station;
import com.example.inhouse.rwm.demo.domein.timetable.TimeTable;
import com.example.inhouse.rwm.demo.domein.train.Train;
import com.example.inhouse.rwm.demo.model.PageRequest;
import com.example.inhouse.rwm.demo.model.timetable.AddOrUpdateTimeTableRequest;
import com.example.inhouse.rwm.demo.model.timetable.TimeTableDto;
import com.example.inhouse.rwm.demo.repository.timetable.TimeTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TimeTableServiceImpl implements TimeTableService {

    private final TimeTableRepository repository;

    @Override
    public Page<TimeTableDto> getByStationsAddDate(Long departureStationId, Long arrivalStationId,
                                                   LocalDate date, PageRequest pageRequest) {
        return null;
    }

    @Override
    public List<TimeTableDto> getByStationsAddDate(Long departureStationId, Long arrivalStationId, LocalDate date) {
        return repository.findByDepartureStAndArrivalStAddDate(arrivalStationId, departureStationId, date);
    }

    @Override
    public Optional<TimeTable> getById(Long id) {
        return repository.findById(id);
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


        return null;
    }
}
