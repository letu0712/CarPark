package com.example.carpark.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {       //Vé
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketId;      //Mã vé
    @Column(name = "bookingTime")
    private LocalTime bookingTime;  //Thời gian đặt vé
    @Column(name = "customerName")
    private String customerName;    //Tên khách hàng

    //ticket có 2 khóa ngoại là licensePlate và tripId
    @JsonBackReference("car-ticket")
    @ManyToOne
    @JoinColumn(name = "licensePlate")
    private Car car;

    @JsonBackReference(value="trip-ticket")
    @ManyToOne
    @JoinColumn(name = "tripId")
    private Trip trip;

    public long getTicketId() {
        return ticketId;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

}
