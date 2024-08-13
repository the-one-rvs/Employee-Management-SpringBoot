package com.quasarcelestio.springBootDemo.Spring.Boot.demo.controllers;

//Operations
//GET /employees
//POST /employees
//DELETE /employees/{id}

import com.quasarcelestio.springBootDemo.Spring.Boot.demo.dto.EmployeeDTO;
import com.quasarcelestio.springBootDemo.Spring.Boot.demo.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployees(@PathVariable Long employeeID){
        return employeeService.getEmployeeById(employeeID);
    }

    @PostMapping
    public EmployeeDTO createNewData(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createNewEmployee(employeeDTO);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployeeByID(@PathVariable Long id){
        return employeeService.deleteEmployeeByID(id);
    }
}
