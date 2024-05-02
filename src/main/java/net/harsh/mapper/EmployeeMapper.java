package net.harsh.mapper;

import net.harsh.dto.EmployeeDto;
import net.harsh.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployee(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static  Employee mapToEmployeeDto(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
