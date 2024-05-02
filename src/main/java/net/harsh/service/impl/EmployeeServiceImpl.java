package net.harsh.service.impl;

import lombok.AllArgsConstructor;
import net.harsh.dto.EmployeeDto;
import net.harsh.entity.Employee;
import net.harsh.exception.ResourceNotFoundException;
import net.harsh.mapper.EmployeeMapper;
import net.harsh.repository.EmployeeRepository;
import net.harsh.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployeeDto(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployee(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee= employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id "+ employeeId));
        return EmployeeMapper.mapToEmployee(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees= employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployee).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updatedEmployee(Long EmployeeId, EmployeeDto updatedEmployee) {
      Employee employee = employeeRepository.findById(EmployeeId).orElseThrow(()-> new ResourceNotFoundException("The Employee is no present with that given id:"+EmployeeId));
      employee.setFirstName(updatedEmployee.getFirstName());
      employee.setLastName(updatedEmployee.getLastName());
      employee.setEmail(updatedEmployee.getEmail());

      Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployee(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("The Employee is no present with that given id:"+employeeId));
        employeeRepository.deleteById(employeeId);
    }
}
