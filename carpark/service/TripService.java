package com.example.carpark.service;

import com.example.carpark.entity.Trip;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    //Select all
    public List<Trip> selectAllTrip(){
        if(tripRepository.findAll().size() > 0){
            return tripRepository.findAll();
        }else{
            throw new NotFoundException("Trip not found");
        }
    }

    //Select by Id
    public Trip selectById(long id){
        Optional<Trip> tripOptional = tripRepository.findById(id);
        if(tripOptional.isPresent()){
            return tripOptional.get();
        }else{
            throw new NotFoundException("Trip id="+id+" not found");
        }
    }

    // Add Trip
    public Trip addTrip(Trip trip){
        return tripRepository.save(trip);
    }
}
