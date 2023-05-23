package com.trips.Trips.services;

import com.trips.Trips.dto.TripDTO;
import com.trips.Trips.models.Trip;

import java.util.List;

public interface TripService {
    List<TripDTO> findAllTrips();
    Trip saveTrip(TripDTO trip);

    TripDTO findTripById(Long tripId);

    void updateTrip(TripDTO trip);
}
