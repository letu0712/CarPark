package com.example.carpark.repository;

import com.example.carpark.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository     // Phục vụ truy xuất dữ liệu
public interface EmployeeRepository extends JpaRepository<Employee, Long> {  //Bảng muốn thao tác và kiểu dữ liệu của khóa chính
    //Tìm kiếm Employee theo address
    @Query(value="SELECT * FROM Employee e WHERE e.employeeAddress= ?1", nativeQuery = true)
    List<Employee> getEmployeeByAddress(String address);

    //Tim kiem theo account
    @Query(value="SELECT * FROM Employee e WHERE e.account= ?1", nativeQuery = true)
    Optional<Employee> getEmployeeByAccount(String account);

    //Xóa Employee theo account
    @Modifying
    @Query(value="DELETE FROM Employee e WHERE e.account= ?1", nativeQuery = true)
    void deleteEmployeeByAccount(String address);

    //select employee de kiem tra duplicate
    @Query(value="SELECT * FROM Employee e WHERE e.account=?1 OR e.employeePhone=?2 OR e.employeeEmail=?3", nativeQuery = true)
    List<Employee> getEmployee(String account, String employeePhone, String employeeEmail);


}
