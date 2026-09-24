package org.devnico.employeemanager.controller;

import jakarta.validation.Valid;
import org.devnico.employeemanager.model.Employee;
import org.devnico.employeemanager.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }

    @GetMapping("find-by-id/{id}")
    public ResponseEntity<Employee> findEmployeeById(@Valid
                                                     @PathVariable Long id){
        return ResponseEntity.ok(employeeService.findById(id));
    }

}
