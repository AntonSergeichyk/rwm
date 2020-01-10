package com.example.inhouse.rwm.demo.controller.api.train;

import com.example.inhouse.rwm.demo.model.train.PlaceDto;
import com.example.inhouse.rwm.demo.service.train.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public List<PlaceDto> getByWaggonId(@RequestParam Long waggonId,
                                        @PathVariable Boolean bought) {
        return service.getByWaggonId(waggonId, bought).stream()
                .map(PlaceDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{placeId}")
    public PlaceDto getById(@RequestParam Long placeId) {
        return new PlaceDto(service.getById(placeId));
    }

    @PutMapping("/{placeId}/reserve")
    public PlaceDto reserve(@RequestParam Long placeId) {
        return new PlaceDto(service.reserve(placeId));
    }

    @PutMapping("/{placeId}/reserve/remove")
    public PlaceDto removeReservation(@RequestParam Long placeId) {
        return new PlaceDto(service.removeReservation(placeId));
    }
}
