package com.howtodoinjava.dao;

import java.util.List;
import java.util.UUID;

import com.howtodoinjava.entity.EmployeeEntity;

public interface EmployeeDAO 
{
    public void addEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public void deleteEmployee(UUID employeeId);
}