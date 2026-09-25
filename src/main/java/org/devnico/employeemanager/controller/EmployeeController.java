package org.devnico.employeemanager.controller;

import jakarta.validation.Valid;
import org.devnico.employeemanager.model.Employee;
import org.devnico.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Employee> findEmployeeById(@Valid
                                                     @PathVariable Long id){
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employee));
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
