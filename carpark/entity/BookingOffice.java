package com.example.carpark.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "bookingoffice")
public class BookingOffice implements Serializable {        //Văn phòng đặt vé
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long officeId;          // Mã văn phòng
    @Column(name="startContractDeadline")
    private LocalDate startContractDeadline;    //thời hạn hợp đồng bắt đầu
    @Column(name = "endContractDeadline")
    private LocalDate endContractDeadline;      // Thời hạn hợp đồng kết thúc
    @Column(name = "officeName")
    private String officeName;        //Tên văn phòng
    @Column(name = "officePhone")
    private String officePhone;     //Số điện thoại văn phòng
    @Column(name = "officePlace")
    private String officePlace;     //Địa chỉ văn phòng
    @Column(name = "officePrice")
    private long officePrice;       // Giá

    @JsonBackReference("trip-bookingoffice")
    @ManyToOne
    @JoinColumn(name = "tripId")    //tripId: Tên khóa ngoại của bảng con
    private Trip trip;

    public long getOfficeId() {
        return officeId;
    }

    public LocalDate getStartContractDeadline() {
        return startContractDeadline;
    }

    public void setStartContractDeadline(LocalDate startContractDeadline) {
        this.startContractDeadline = startContractDeadline;
    }

    public LocalDate getEndContractDeadline() {
        return endContractDeadline;
    }

    public void setEndContractDeadline(LocalDate endContractDeadline) {
        this.endContractDeadline = endContractDeadline;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getOfficePlace() {
        return officePlace;
    }

    public void setOfficePlace(String officePlace) {
        this.officePlace = officePlace;
    }

    public long getOfficePrice() {
        return officePrice;
    }

    public void setOfficePrice(long officePrice) {
        this.officePrice = officePrice;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

}
