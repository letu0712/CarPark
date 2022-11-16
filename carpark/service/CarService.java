package com.example.carpark.service;

import com.example.carpark.entity.Car;
import com.example.carpark.entity.ParkingLot;
import com.example.carpark.exception.DuplicateRecordException;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.repository.CarRepository;
import com.example.carpark.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    //Select all
    public List<Car> selectAllCar(){
        if(carRepository.findAll().size() > 0){
            return carRepository.findAll();
        }else{
            throw new NotFoundException("Car not found");
        }

    }

    //Select by LicensePlate
    public Car selectById(String licensePlate){
        Optional<Car> carOptional = carRepository.findById(licensePlate);   //findById return optional
        if(carOptional.isPresent()){
            return carOptional.get();
        }else{
            throw new NotFoundException("Car license plate="+licensePlate+" not found");
        }
    }

    //Select by LicensePlate using @Query
    public Car selectByLicensePlate(String licensePlate){
        Optional<Car> carOptional = carRepository.findByLicencePlate(licensePlate);
        if(carOptional.isPresent()){
            return carOptional.get();
        }else{
            throw new NotFoundException("Car license plate="+licensePlate+" not found");
        }
    }

    //Add Car
    public Car addCar(Car car){
        return carRepository.save(car);
    }
}
