package com.example.carpark.service;

import com.example.carpark.entity.Employee;
import com.example.carpark.entity.dto.EmployeeDTO;
import com.example.carpark.exception.DuplicateRecordException;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service        //Giải quyết các logic nghiệp vụ
public class EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;      //class Service giao tiếp với DB thông qua Repository

    //Thêm employee
    public Employee addEmployee(Employee employee){
        List<Employee> employeeList = employeeRepository.getEmployee(employee.getAccount(),
                employee.getEmployeePhone(), employee.getEmployeeEmail());
        if(employeeList.size() == 0){
            return employeeRepository.save(employee);
        }else{
            throw new DuplicateRecordException("Duplicate Employee (account | phone | email)");
        }
    }

    //Lấy ra danh sách employee
    public List<EmployeeDTO> selectAllEmployee(){
        List<Employee> employeeList = employeeRepository.findAll();
        if(employeeList.size() > 0){
            List<EmployeeDTO> employeeDTOList = new ArrayList<>();
            for(Employee employee : employeeList){
                employeeDTOList.add(new EmployeeDTO(employee));
            }
            return employeeDTOList;
        }else{
            throw new NotFoundException("Employee not found");
        }
    }

    //Lấy ra danh sách employee theo address (Sử dụng @Query)
    public List<EmployeeDTO> getByName(String address){
        List<Employee> employeeList = employeeRepository.getEmployeeByAddress(address);
        if(employeeList.size() > 0){
            List<EmployeeDTO> employeeDTOList = new ArrayList<>();
            for(Employee employee : employeeList){
                employeeDTOList.add(new EmployeeDTO(employee));
            }
            return employeeDTOList;
        }else{
            throw new NotFoundException("Employee not found");
        }
    }

    //delete employee by account using @Query
    public String deleteByAccount(String account){
        Optional<Employee> optionalEmployee = employeeRepository.getEmployeeByAccount(account);
        if(optionalEmployee.isPresent()){
            employeeRepository.deleteEmployeeByAccount(account);
            return "Deleted successfully";
        }else{
            throw new NotFoundException("Employee account="+account+" not found");
        }
    }


    //Update employee
    public Employee updateEmployee(long id, Employee newUpdate){
        Optional<Employee> employeeData = employeeRepository.findById(id);
        if(employeeData.isPresent()){
            Employee employee = employeeData.get();
            employee.setEmployeeAddress(newUpdate.getEmployeeAddress());
            employee.setEmployeeBirthdate(newUpdate.getEmployeeBirthdate());
            employee.setEmployeeEmail(newUpdate.getEmployeeEmail());
            employee.setEmployeePhone(newUpdate.getEmployeePhone());
            employee.setAccount(newUpdate.getAccount());
            employee.setDepartment(newUpdate.getDepartment());
            employee.setPassword(newUpdate.getPassword());
            employee.setSex(newUpdate.getSex());
            return employeeRepository.save(employee);
        }else{
            throw new NotFoundException("Employee id="+ id +"not found");
        }
    }

    //search by Id
    public EmployeeDTO searchById(long id){
        Optional<Employee> employeeData = employeeRepository.findById(id);
        if(employeeData.isPresent()){
            return new EmployeeDTO(employeeData.get());
        }else{
            throw new NotFoundException("Employee id="+ id +"not found");
        }
    }

    //Delete employee by Id
    public String deleteById(long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            employeeRepository.deleteById(id);
            return "Deleted successfully";
        }else{
            throw new NotFoundException("Employee id="+ id +"not found");
        }
    }

    //PageRequest
    public List<EmployeeDTO> getEmployee(int page, int offset){
        Page<Employee> employeePage = employeeRepository.findAll(PageRequest.of(page, offset, Sort.by("account").ascending()));
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for(Employee employee : employeePage.getContent()){
            employeeDTOList.add(new EmployeeDTO(employee));
        }
        return  employeeDTOList;
    }


}
