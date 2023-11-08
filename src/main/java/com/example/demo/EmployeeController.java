package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

    @RestController
public class EmployeeController {
        private final EmployeeServiceImpl employeeService;

        public EmployeeController(EmployeeServiceImpl employeeService) {
            this.employeeService = employeeService;

        }

        @GetMapping("/employee/add")
        public String employeeAdding(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
            return employeeService.addEmployee(firstName, lastName);
        }

        @GetMapping("/employee/remove")
        public String employeeRemove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
            return employeeService.removeEmployee(Employee firstName, Employee lastName);
        }

        @GetMapping("/employee/find")
        public String findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
            return employeeService.searchEmployee(String firstName, String lastName);

        }
        @GetMapping
        public String showAllEmployeeList {
            return employeeService.listAllEmployee(String firstName, String lastName);
        }

    }


