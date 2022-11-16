package com.example.carpark.service;

import com.example.carpark.entity.BookingOffice;
import com.example.carpark.entity.ParkingLot;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    //Select all parking lot
    public List<ParkingLot> selectAllParkingLot(){
        if(parkingLotRepository.findAll().size() > 0){
            return parkingLotRepository.findAll();
        }else{
            throw new NotFoundException("ParkingLot not found");
        }
    }

    //Select by Id
    public ParkingLot selectById(long id){
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findById(id);
        if(parkingLotOptional.isPresent()){
            return parkingLotOptional.get();
        }else{
            throw new NotFoundException("Parking Lot id="+id+" not found");
        }
    }

    //Thêm parking lot
    public ParkingLot addParkingLot(ParkingLot parkingLot){
        return parkingLotRepository.save(parkingLot);
    }
}
