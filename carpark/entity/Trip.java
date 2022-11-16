package com.example.carpark.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "trip")
public class Trip implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tripId;                // Mã chuyến đi
    @Column(name = "bookedTicketNumber")
    private int bookedTicketNumber;     //Số vé đặt
    @Column(name = "carType")
    private String carType;             //Loại xe
    @Column(name = "departureDate")
    private LocalDate departureDate;    //Ngày khởi hành
    @Column(name = "departureTime")
    private LocalTime departureTime;    //Giờ khởi hành
    @Column(name = "destination")
    private String destination;         //Điểm đến

    @JsonManagedReference(value="trip-ticket")   //Thuộc tính trip của Ticket
    @OneToMany(mappedBy = "trip")
    private List<Ticket> ticketList;

    @JsonManagedReference("trip-bookingoffice")
    @OneToMany(mappedBy = "trip")
    private List<BookingOffice> bookingOfficeList;

    public long getTripId() {
        return tripId;
    }

    public int getBookedTicketNumber() {
        return bookedTicketNumber;
    }

    public void setBookedTicketNumber(int bookedTicketNumber) {
        this.bookedTicketNumber = bookedTicketNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public List<BookingOffice> getBookingOfficeList() {
        return bookingOfficeList;
    }

    public void setBookingOfficeList(List<BookingOffice> bookingOfficeList) {
        this.bookingOfficeList = bookingOfficeList;
    }

}
