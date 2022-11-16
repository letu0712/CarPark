package com.example.carpark.controller;

import com.example.carpark.entity.Employee;
import com.example.carpark.entity.dto.EmployeeDTO;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.repository.EmployeeRepository;
import com.example.carpark.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //Thêm employee
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee){
//        return ResponseEntity.ok(employeeService.addEmployee(employee));
        //hoặc
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }

    //Lấy ra danh sách employee
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> selectAllEmployee(){
        return ResponseEntity.ok(employeeService.selectAllEmployee());
    }

    //Lấy ra danh sách employee theo address (Sử dụng @Query)
    @GetMapping("/address/{addr}")
    public ResponseEntity<List<EmployeeDTO>> getByName(@PathVariable("addr") String address){
        return ResponseEntity.ok(employeeService.getByName(address));
    }

    //Delete employee by account using @Query
    @DeleteMapping("/account/{acc}")
    public ResponseEntity<String> deleteEmployeeByAccount(@PathVariable("acc") String account){
        return ResponseEntity.ok(employeeService.deleteByAccount(account));
    }

    //Update employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee newUpdate){
        return ResponseEntity.ok(employeeService.updateEmployee(id, newUpdate));
    }

    //Tìm kiếm theo Id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> searchById(@PathVariable("id") long id){
        return ResponseEntity.ok(employeeService.searchById(id));
    }

    //Delete employee by Id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id){
        return ResponseEntity.ok(employeeService.deleteById(id));
    }


    //Page
    @GetMapping("/{page}/{offset}")
    public ResponseEntity<List<EmployeeDTO>> getEmployee(@PathVariable("page") int page, @PathVariable("offset") int offset){
        return ResponseEntity.ok(employeeService.getEmployee(page, offset));
    }

}
