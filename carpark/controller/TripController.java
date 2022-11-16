package com.example.carpark.controller;

import com.example.carpark.entity.Trip;
import com.example.carpark.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    private TripService tripService;

    //Select all
    @GetMapping
    public ResponseEntity<List<Trip>> selectAllTrip(){

        return ResponseEntity.ok(tripService.selectAllTrip());
    }

    //Select by id
    @GetMapping("/{id}")
    public ResponseEntity<Trip> selectById(@PathVariable("id") long id){
        return ResponseEntity.ok(tripService.selectById(id));
    }

    //Add trip
    @PostMapping
    public ResponseEntity<Trip> addTrip(@RequestBody Trip trip){
        return ResponseEntity.ok(tripService.addTrip(trip));
    }
}
