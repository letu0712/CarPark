package com.example.carpark.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name="employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    @NotNull(message = "Account shouldn't be null")
    @Column(name="account")
    private String account;

    @Column(name="department")
    private String department;

    @Column(name="employeeAddress")
    private String employeeAddress;

    @Column(name="employeeBirthdate")
    private LocalDate employeeBirthdate;

    @Email(message = "Invalid email")
    @Column(name="employeeEmail")
    private String employeeEmail;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone")
    @Column(name="employeePhone")
    private String employeePhone;

    @NotBlank
    @Column(name="password")
    private String password;

    @Column(name="sex")
    private String sex;

    public long getEmployeeId() {
        return employeeId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public LocalDate getEmployeeBirthdate() {
        return employeeBirthdate;
    }

    public void setEmployeeBirthdate(LocalDate employeeBirthdate) {
        this.employeeBirthdate = employeeBirthdate;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", account='" + account + '\'' +
                ", department='" + department + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeeBirthdate=" + employeeBirthdate +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
