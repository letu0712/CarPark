package com.example.carpark.repository;

import com.example.carpark.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
    @Query(value="SELECT * FROM car WHERE licensePlate= :lp", nativeQuery = true)
    Optional<Car> findByLicencePlate(String lp);
}
