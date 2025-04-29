package edu.icet.service.impl;

import edu.icet.dto.Employee;
import edu.icet.entity.EmployeeEntity;
import edu.icet.repository.EmployeeRepository;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.classfile.InnerClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository repository;
    final ModelMapper mapper;

    @Override
    public void addEmployee(Employee employee) {
        repository.save(mapper.map(employee, EmployeeEntity.class));
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList=new ArrayList<>();
        List<EmployeeEntity> all=repository.findAll();
        all.forEach(EmployeeEntity->{
            employeeList.add(mapper.map(EmployeeEntity, Employee.class));
        });
        return employeeList;
    }

    @Override
    public void deleteEmployee(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public void updateEmployee(Employee employee) {
        repository.save(mapper.map(employee, EmployeeEntity.class));
    }



    @Override
    public Employee searchById(Integer id) {
        return mapper.map(repository.findById(id), Employee.class);
    }
}
