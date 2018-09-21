package com.util;


import com.dto.Employee;

import java.util.Arrays;
import java.util.List;

public class EmployeeFactory {

    public static List<Employee> buildEmployeeList() {
        List<Employee> employeeList = Arrays.asList(new Employee("Robin Smith", 10),
                new Employee("Aravind Jayaram", 36),
                new Employee("Jack Russel", 55),
                new Employee("Tom Moody", 48), new Employee("Graham Hick", 53),
                new Employee("Michael Atherton", 23), new Employee("Zaheer Khan", 38));
        return employeeList;
    }
}
