package com.example.inhouse.rwm.demo.controller.api.train;

import com.example.inhouse.rwm.demo.model.train.PlaceDto;
import com.example.inhouse.rwm.demo.service.train.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/place")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService service;

    @GetMapping("/count/{waggonId}/free")
    public Integer getCountFreeByWaggonId(@RequestParam Long waggonId) {
        return service.getCountFreeByWaggonId(waggonId);
    }

    @GetMapping("/{waggonId}/free")
    public List<PlaceDto> getByWaggonId(@RequestParam Long waggonId) {
        return service.getByWaggonId(waggonId, false).stream()
                .map(PlaceDto::new)
                .collect(Collectors.toList());
    }
}
