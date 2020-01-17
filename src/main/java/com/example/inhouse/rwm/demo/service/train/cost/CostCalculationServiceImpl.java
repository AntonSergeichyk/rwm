package com.example.inhouse.rwm.demo.service.train.cost;

import com.example.inhouse.rwm.demo.service.timetable.TimeTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CostCalculationServiceImpl implements CostCalculationService {

    private final TimeTableService timeTableService;

    @Override

    public String calculate(Long waggonId) {
        return null;
    }
}
