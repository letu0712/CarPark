package com.example.carpark.service;

import com.example.carpark.entity.BookingOffice;
import com.example.carpark.entity.Employee;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.repository.BookingOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BookingOfficeService {
    @Autowired
    private BookingOfficeRepository bookingOfficeRepository;

    //Lấy ra toàn bộ BookingOffice
    public List<BookingOffice> selectAllBookingOffice(){
        return bookingOfficeRepository.findAll();
    }

    //Tìm kiếm bookingoffice theo Id
    public BookingOffice selectById(long id){
        Optional<BookingOffice> bookingOfficeOptional = bookingOfficeRepository.findById(id);
        if(bookingOfficeOptional.isPresent()){
            return bookingOfficeOptional.get();
        }else{
            throw new NotFoundException("BookingOffice id="+id+"not found");
        }
    }

    //Thêm booking office
    public BookingOffice addBookingOffice(BookingOffice bookingOffice){
        return bookingOfficeRepository.save(bookingOffice);
    }
}
