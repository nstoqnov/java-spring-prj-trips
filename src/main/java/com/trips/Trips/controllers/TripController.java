package com.trips.Trips.controllers;

import com.trips.Trips.dto.TripDTO;
import com.trips.Trips.models.Trip;
import com.trips.Trips.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TripController {
    private TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/trips")
    public String listTrips(Model model){
        List<TripDTO> trips = tripService.findAllTrips();
        model.addAttribute("trips",trips);
        return "trips";
    }
}
