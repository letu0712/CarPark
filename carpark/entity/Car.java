package com.example.carpark.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



@Entity
@Table(name = "car")
public class Car implements Serializable {
    @Id
    private String licensePlate;    //Biển xe
    @Column(name = "carColor")
    private String carColor;        //Màu xe
    @Column(name = "carType")
    private String carType;     //Lọai xe
    @Column(name = "company")
    private String company;     //Công ty

    //car - parkinglot quan hệ (n - 1)
    @JsonBackReference("car-parkinglot")
    @ManyToOne
    @JoinColumn(name = "parkId")    //parkId: khóa ngoại của table car
    private ParkingLot parkingLot;

    //car - ticket quan hệ (1 - n)
    @JsonManagedReference("car-ticket")
    @OneToMany(mappedBy = "car")    //Map với thuộc tính car trong Ticket
    private List<Ticket> ticketList;

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

}
