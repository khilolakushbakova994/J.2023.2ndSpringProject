package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service

public class EmployeeServiceImpl implements EmployeeService {
private final List<Employee> employeeList;
  public EmployeeServiceImpl() {
    this.employeeList = new ArrayList<>();
  }
@Override
  public Employee addEmployee(String firstName, String lastName) {
    Employee employee = new Employee(firstName, lastName);
    if (employeeList.contains(employee)) {
      throw new EmployeeAlreadyAddedException("уже есть такой сотрудник");
    }
    employeeList.add(employee);
    return employee;
    }
@Override
  public Employee removeEmployee(String firstName, String lastName) {
    Employee employee = new Employee( firstName, lastName);
    if (employeeList.contains(employee)) {
      employeeList.remove(employee);
      return employee;
    }
    throw new EmployeeNotFoundException("Такого сотрудника нет в списке");
    }

@Override
  public Employee searchEmployee(String firstName, String lastName) {
  Employee employee = new Employee(firstName, lastName);

  if (employeeList.contains(employee)) {
    return employee;
  }
        throw new EmployeeNotFoundException("Такого сотрудника нет в списке");
      }

  @Override
  public Collection<Employee> showAllEmployeeList() {
    return Collections.unmodifiableList(employeeList);
  }


}
