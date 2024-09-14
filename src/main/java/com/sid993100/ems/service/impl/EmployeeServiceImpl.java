package com.sid993100.ems.service.impl;

import com.sid993100.ems.dto.EmployeeDto;
import com.sid993100.ems.entity.Employee;
import com.sid993100.ems.exception.ResourceNotFoundException;
import com.sid993100.ems.mapper.EmployeeMapper;
import com.sid993100.ems.repository.EmployeeRepository;
import com.sid993100.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found" + employeeId));
        return  EmployeeMapper.mapToEmployeeDto(employee);

    }


}
