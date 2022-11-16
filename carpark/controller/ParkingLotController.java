package com.example.carpark.controller;

import com.example.carpark.entity.ParkingLot;
import com.example.carpark.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkinglot")
public class ParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;

    //Select all parking lot
    @GetMapping
    public List<ParkingLot> selectAllParkingLot(){
        return parkingLotService.selectAllParkingLot();
    }

    //Select by Id
    @GetMapping("/{id}")
    public ResponseEntity<ParkingLot> selectById(@PathVariable("id") long id){
        return ResponseEntity.ok(parkingLotService.selectById(id));
    }

    //Add parking lot
    @PostMapping
    public ResponseEntity<ParkingLot> addParkingLot(@RequestBody ParkingLot parkingLot){
        return ResponseEntity.ok(parkingLotService.addParkingLot(parkingLot));
    }
}
