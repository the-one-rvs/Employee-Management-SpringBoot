package com.quasarcelestio.springBootDemo.Spring.Boot.demo.services;

import com.quasarcelestio.springBootDemo.Spring.Boot.demo.dto.EmployeeDTO;
import com.quasarcelestio.springBootDemo.Spring.Boot.demo.entities.EmployeeEntity;
import com.quasarcelestio.springBootDemo.Spring.Boot.demo.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    final EmployeeRepository employeeRepository;

    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id){
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        return  modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository
                .findAll()
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public boolean deleteEmployeeByID(Long id) {
        boolean isPresent = employeeRepository.existsById(id);
        if (isPresent){
            employeeRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
