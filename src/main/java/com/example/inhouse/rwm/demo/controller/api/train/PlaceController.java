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

    @GetMapping("/count/{waggonId}/free/waggon")
    public Integer getCountFreeByWaggonId(@PathVariable Long waggonId) {
        return service.getCountFreeByWaggonId(waggonId);
    }

    @GetMapping("/{waggonId}/free/waggon")
    public List<PlaceDto> getByWaggonId(@PathVariable Long waggonId,
                                        @RequestParam Boolean bought) {
        return service.getByWaggonId(waggonId, bought).stream()
                .map(PlaceDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{waggonId}/free/waggon/cost")
    public List<PlaceDto> getByWaggonIdWithCost(@PathVariable Long waggonId,
                                        @RequestParam Boolean bought) {
        return service.getByWaggonId(waggonId, bought).stream()
                .map(PlaceDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{placeId}")
    public PlaceDto getById(@PathVariable Long placeId) {
        return new PlaceDto(service.getById(placeId));
    }

    @PutMapping("/{placeId}/reserve")
    public PlaceDto reserve(@PathVariable Long placeId) {
        return new PlaceDto(service.reserve(placeId));
    }

    @PutMapping("/{placeId}/reserve/remove")
    public PlaceDto removeReservation(@PathVariable Long placeId) {
        return new PlaceDto(service.removeReservation(placeId));
    }

    @PutMapping("/{placeId}/bay")
    public PlaceDto bay(@PathVariable Long placeId) {
        return new PlaceDto(service.bay(placeId));
    }

    @PutMapping("/{placeId}/giveAway")
    public PlaceDto giveAway(@PathVariable Long placeId) {
        return new PlaceDto(service.giveAway(placeId));
    }
}
