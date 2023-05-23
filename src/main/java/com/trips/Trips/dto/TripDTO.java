package com.trips.Trips.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TripDTO {
    private Long id;
    @NotEmpty(message = "'Trip from' should not be empty!")
    private String trip_from;
    @NotEmpty(message = "'Trip to' should not be empty!")
    private String trip_to;
    @NotNull(message = "Distance may not be null")
    private double distance;
    private LocalDateTime date;
}
