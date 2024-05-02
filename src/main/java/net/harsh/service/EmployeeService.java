package net.harsh.service;

import net.harsh.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public EmployeeDto getEmployeeById(Long employeeId);
    public List<EmployeeDto> getAllEmployee();
    public EmployeeDto updatedEmployee(Long EmployeeId,EmployeeDto updatedEmployee);
}
