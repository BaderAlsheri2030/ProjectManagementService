package com.example.todolist.Service;

import com.example.todolist.DTO.EmployeeDTO;
import com.example.todolist.Model.Employee;
import com.example.todolist.Model.User;
import com.example.todolist.Repository.EmployeeRepository;
import com.example.todolist.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    EmployeeRepository employeeRepository;
    UserRepository userRepository;

    public void register(EmployeeDTO employeeDTO){
        Employee employee = new Employee(null,employeeDTO.getFirstName(),employeeDTO.getLastName(),"Employee",null,null,null);
        User user = new User(null,employeeDTO.getUserName(),employeeDTO.getPassword(),employeeDTO.getEmail(),"Employee",null,null,employee);
        employee.setUser(user);
        employeeRepository.save(employee);
        userRepository.save(user);
    }
}
