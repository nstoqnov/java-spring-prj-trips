package com.trips.Trips.controllers;

import com.trips.Trips.dto.TripDTO;
import com.trips.Trips.models.Trip;
import com.trips.Trips.services.TripService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/trips/new")
    public String createTripForm(Model model){
        Trip trip = new Trip();
        model.addAttribute("trip",trip);
        return "trips-create";
    }
    @PostMapping("/save")
    public String saveTrip(@Valid @ModelAttribute("trip") TripDTO trip, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "trips-create";
        }
        tripService.saveTrip(trip);
        return "redirect:/trips";
    }

    @GetMapping("/trips/{id}/edit")
    public String editTripForm(@PathVariable("id") Long tripId,Model model){
        TripDTO trip = tripService.findTripById(tripId);
        model.addAttribute("trip",trip);
        return "trips-edit";
    }

    @PostMapping("/trips/{id}/edit")
    public String updateTrip(@PathVariable("id") Long tripId, @Valid @ModelAttribute("trip") TripDTO trip, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "trips-edit";
        }
        trip.setId(tripId);
        tripService.updateTrip(trip);
        return "redirect:/trips";
    }
}
