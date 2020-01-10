package com.example.inhouse.rwm.demo.controller.api.train;

import com.example.inhouse.rwm.demo.model.train.TrainDto;
import com.example.inhouse.rwm.demo.service.train.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/train")
@RequiredArgsConstructor
public class TrainController {

    private final TrainService service;

    @GetMapping("/{trainId}")
    public TrainDto getById(@PathVariable Long trainId){
        return new TrainDto(service.getById(trainId));
    }
}
