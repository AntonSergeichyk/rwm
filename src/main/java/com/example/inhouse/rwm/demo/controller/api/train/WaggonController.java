package com.example.inhouse.rwm.demo.controller.api.train;

import com.example.inhouse.rwm.demo.model.train.WaggonDto;
import com.example.inhouse.rwm.demo.service.train.WaggonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/waggon")
@RequiredArgsConstructor
public class WaggonController {

    private final WaggonService service;

    @GetMapping("/{trainId}")
    private List<WaggonDto> getByTrainId(@RequestParam Long trainId) {
        return service.getByTrainId(trainId).stream()
                .map(WaggonDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{trainId}/free")
    private List<WaggonDto> getFreeByTrainId(@RequestParam Long trainId,
                                             @PathVariable Boolean bought) {
        return service.getFreeByTrainId(trainId, bought).stream()
                .map(WaggonDto::new)
                .collect(Collectors.toList());
    }
}
