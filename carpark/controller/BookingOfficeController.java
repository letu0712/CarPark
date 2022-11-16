package com.example.carpark.controller;

import com.example.carpark.entity.BookingOffice;
import com.example.carpark.service.BookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookingoffice")
public class BookingOfficeController {
    @Autowired
    private BookingOfficeService bookingOfficeService;

    //Lấy ra toàn bộ booking office
    @GetMapping("")
    public ResponseEntity<List<BookingOffice>> selectAllBookingOffice(){
        return ResponseEntity.ok(bookingOfficeService.selectAllBookingOffice());
    }

    //Lấy ra theo Id
    @GetMapping("/{id}")
    public ResponseEntity<BookingOffice> selectById(@PathVariable("id") long id){
        return ResponseEntity.ok(bookingOfficeService.selectById(id));
    }

    //Thêm booking office
    @PostMapping
    public ResponseEntity<BookingOffice> addBookingOffice(@RequestBody BookingOffice bookingOffice){
        return ResponseEntity.ok(bookingOfficeService.addBookingOffice(bookingOffice));
    }

}
