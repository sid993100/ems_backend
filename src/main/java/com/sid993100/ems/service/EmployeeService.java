package com.sid993100.ems.service;

import com.sid993100.ems.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee (EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
}
