package com.example.carpark.entity.dto;

import com.example.carpark.entity.Employee;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
public class EmployeeDTO {
    private long employeeId;
    private String account;
    private String department;
    private String employeeAddress;
    private LocalDate employeeBirthdate;
    private String employeeEmail;
    private String employeePhone;
    private String sex;

    public EmployeeDTO(Employee employee){
        this.employeeId = employee.getEmployeeId();
        this.account = employee.getAccount();
        this.department = employee.getDepartment();
        this.employeeAddress = employee.getEmployeeAddress();
        this.employeeBirthdate = employee.getEmployeeBirthdate();
        this.employeeEmail = employee.getEmployeeEmail();
        this.employeePhone = employee.getEmployeePhone();
        this.sex = employee.getSex();
    }
}
