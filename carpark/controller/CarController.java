package com.example.carpark.controller;

import com.example.carpark.entity.Car;
import com.example.carpark.entity.ParkingLot;
import com.example.carpark.service.CarService;
import com.example.carpark.service.ParkingLotService;
import com.example.carpark.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private ParkingLotService parkingLotService;
    @Autowired
    private TicketService ticketService;

    //Select all
    @GetMapping
    public ResponseEntity<List<Car>> selectAllCar(){
        return ResponseEntity.ok(carService.selectAllCar());
    }

    //Select by Id (licenseplate)
    @GetMapping("/{licenseplate}")
    public ResponseEntity<Car> selectById(@PathVariable("licenseplate") String lp){
        return ResponseEntity.ok(carService.selectById(lp));
    }

    //Using @Query
    @GetMapping("/lp/{licenseplate}")
    public ResponseEntity<Car> selectByLicensePlate(@PathVariable("licenseplate") String lp){
        return ResponseEntity.ok(carService.selectByLicensePlate(lp));
    }

    //Add Car
    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        return ResponseEntity.ok(carService.addCar(car));
    }
}
