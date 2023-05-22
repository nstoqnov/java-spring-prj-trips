package com.trips.Trips.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TripDTO {
    private Long id;
    private String trip_from;
    private String trip_to;
    private double distance;
    private LocalDateTime date;
}
