package com.trips.Trips.services.impl;

import com.trips.Trips.dto.TripDTO;
import com.trips.Trips.models.Trip;
import com.trips.Trips.repository.TripRepository;
import com.trips.Trips.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;
    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }


    @Override
    public List<TripDTO> findAllTrips() {
        List<Trip> trips = tripRepository.findAll();
        return trips.stream().map((trip) -> mapToTripDto(trip)).collect(Collectors.toList());
    }

    @Override
    public Trip saveTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public TripDTO findTripById(Long tripId) {
        Trip trip = tripRepository.findById(tripId).get();
        return mapToTripDto(trip);
    }

    @Override
    public void updateTrip(TripDTO tripDto) {
        Trip trip = mapToTrip(tripDto);
        tripRepository.save(trip);
    }
    private Trip mapToTrip(TripDTO trip){
        Trip tripDto = Trip.builder()
                .id(trip.getId())
                .trip_from(trip.getTrip_from())
                .trip_to(trip.getTrip_to())
                .distance(trip.getDistance())
                .date(trip.getDate())
                .build();
        return tripDto;
    }

    private TripDTO mapToTripDto(Trip trip){
        TripDTO tripDTO = TripDTO.builder()
                .id(trip.getId())
                .distance(trip.getDistance())
                .date(trip.getDate())
                .trip_from(trip.getTrip_from())
                .trip_to(trip.getTrip_to())
                .build();
        return tripDTO;
    }
}
