package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeeServiceImpl extends Employee {

  public EmployeeServiceImpl(String firstName, String lastName) {
    super(firstName, lastName);
  }

  public List<Employee> employeeList = new ArrayList<>();

  public void addEmployee(Employee employee) {
    employeeList.add(employee);
    if (getFirstName().matches(firstName) && (getLastName().matches(lastName))) {
      throw new EmployeeAlreadyAddedException("уже есть такой сотрудник");
    }

    if (employeeList.size() > 6) {

      throw new EmployeeStorageIsFullException(" превышен лимит количества сотрудников в фирме");
    }
  }

  public void removeEmployee(Employee employee) {
    employeeList.remove(employee);
    if (!employee.getFirstName().matches(firstName)) {
      throw new EmployeeNotFoundException("Такого сотрудника нет в списке");
    }
  }

  public void searchEmployee(String firstName, String lastName) {
    for (Employee employee : employeeList) {
      if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
        System.out.println("Результат поска: " + employee.getFirstName() + employee.getLastName());

      } else {
        throw new EmployeeNotFoundException("Такого сотрудника нет в списке");
      }

    }
  }
  public void listAllEmployee ( String firstName, String lastName){
         for (Employee employee : employeeList) {

         }
      System.out.println( " Firstname : " + firstName + " Lastname: " + lastName);


  }
}
