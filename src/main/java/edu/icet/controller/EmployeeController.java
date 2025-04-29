package edu.icet.controller;

import edu.icet.dto.Employee;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {
    final EmployeeService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
    }

    @GetMapping("/get-all")
    public List<Employee> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        service.deleteEmployee(id);
    }

    @PutMapping("/update-employee")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  void updateEmployee(@RequestBody Employee employee){
        service.updateEmployee(employee);
    }

    @GetMapping("/search-by-id/{id}")
    public  Employee searchById(@PathVariable Integer id){
        return service.searchById(id);
    }

}
