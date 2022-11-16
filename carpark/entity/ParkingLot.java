package com.example.carpark.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "parkinglot")
public class ParkingLot implements Serializable {   //Bãi gửi xe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long parkId;    //Mã
    @Column(name = "parkArea")
    private long parkArea;  //Khu vực đậu xe
    @Column(name = "parkName")
    private String parkName;    //Tên bãi
    @Column(name = "parkPlace")
    private String parkPlace;   //Vị trí bãi
    @Column(name = "parkPrice")
    private long parkPrice;     //Giá
    @Column(name = "parkStatus")
    private String parkStatus;  //Trạng thái

    @JsonManagedReference("car-parkinglot")
    @OneToMany(mappedBy = "parkingLot")    //Map với thuộc tính parkingLot trong Car
    private List<Car> carList;

    public long getParkId() {
        return parkId;
    }

    public long getParkArea() {
        return parkArea;
    }

    public void setParkArea(long parkArea) {
        this.parkArea = parkArea;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkPlace() {
        return parkPlace;
    }

    public void setParkPlace(String parkPlace) {
        this.parkPlace = parkPlace;
    }

    public long getParkPrice() {
        return parkPrice;
    }

    public void setParkPrice(long parkPrice) {
        this.parkPrice = parkPrice;
    }

    public String getParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(String parkStatus) {
        this.parkStatus = parkStatus;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

}
