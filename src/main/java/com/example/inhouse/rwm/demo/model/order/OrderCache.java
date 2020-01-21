package com.example.inhouse.rwm.demo.model.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class OrderCache {

    private LocalDateTime dateOfLeave;
    private Long stationLeaveId;
    private LocalDateTime dateOfArrival;
    private Long stationArrivalId;
    private String cost;
    private Long placeId;
}
