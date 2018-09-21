package com.service;

import com.dto.Employee;
import com.util.EmployeeFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class SortList {
    private static Logger log = Logger.getLogger("SortList");
    public static void main(String[] args) {

        List<Employee> employeeList = EmployeeFactory.buildEmployeeList();
        sortList(employeeList);
        sortListByComparable(employeeList);
        sortListByStream(employeeList);
        sortListByComparing(employeeList);

    }

    private static void sortList(List<Employee> employeeList) {
        Instant start = Instant.now();
        log.info("Sorting based on anonymous inner class");
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        employeeList.forEach(e -> System.out.println(e.getName()));
        Instant finish = Instant.now();
        log.info("Total time taken by sortList: " + Duration.between(start, finish).toMillis() + " ms");
    }

    private static void sortListByComparable(List<Employee> employeeList) {
        Instant start = Instant.now();
        log.info("Sorting based on stream and comparable interface");
        employeeList.stream().sorted().forEach(e -> System.out.println(e.getName()));
        Instant finish = Instant.now();
        log.info("Total time taken by sortListByComparable: " + Duration.between(start, finish).toMillis() + " ms");
    }

    private static void sortListByStream(List<Employee> employeeList) {
        Instant start = Instant.now();
        log.info("Sorting based on stream and lambda");
        employeeList.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).forEach(e -> System.out.println(e.getName()));
        Instant finish = Instant.now();
        log.info("Total time taken by sortListByStream: " + Duration.between(start, finish).toMillis() + " ms");
    }

    private static void sortListByComparing(List<Employee> employeeList) {
        Instant start = Instant.now();
        log.info("Sorting based on comparing");
        employeeList.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getName));
        employeeList.forEach(e -> System.out.println(e.getName()));
        Instant finish = Instant.now();
        log.info("Total time taken by sortListByComparing: " + Duration.between(start, finish).toMillis() + " ms");
    }
}