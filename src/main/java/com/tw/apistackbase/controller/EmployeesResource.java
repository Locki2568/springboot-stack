package com.tw.apistackbase.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by jxzhong on 18/08/2017.
 */
@RestController
@RequestMapping("/employees")
public class EmployeesResource {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    EmployeeService employeeService = new EmployeeService();

    @Autowired
    public EmployeesResource(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(produces = {"application/json"})
    public List<Employees> getAll() {
        return employeeService.getAll();
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public Employees searchEmployee(@PathVariable String id ) {
        return employeeService.searchEmployee(Integer.parseInt(id));
    }

    @PostMapping(produces = {"application/json"})
    public List<Employees> search(@RequestParam Employees employees){

    List<Employees> newEmployeesList = employeeService.initiateEmployee(employees);
    return newEmployeesList;
    }

    

    //(@RequestBody Employees employees)

}
