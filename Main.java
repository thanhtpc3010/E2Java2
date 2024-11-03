import Entity.Department;
import Entity.Employee;
import Entity.Gender;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Department> departments = new ArrayList<Department>();
        List<Employee> employees = new ArrayList<>();

        Map<String, Long> countEmployee = new HashMap<>();

        departments.add(new Department(1, "HR", "Human Resource"));
        departments.add(new Department(2, "IT", "Information Technology"));
        employees.add(new Employee(1, "Lo Van Hieu", departments.get(0)));
        employees.add(new Employee(2, "Nguyen Van Hieu", departments.get(0)));
        employees.add(new Employee(3, "Dat Nguyen", departments.get(1)));

        /*Count Total Employees for each Department(Name)
         * HR=2, IT=1
         * way 1: using count() return Long dataType
         * javadoc
         * */
        departments.stream().forEach(department -> {
            long totalEmp = employees.stream()
                    .filter(emp -> department.getId() == emp.getDepartment().getId())
                    .collect(Collectors.toSet())
                    .stream().count();
            countEmployee.put(department.getCode(), totalEmp);
        });
        System.out.println(countEmployee);
        /*getOrDefault(base on Count() must be unique, 0) + 1; iterator in MapEntry
         * way 2
         * */
        departments.forEach(d -> {
            employees.stream()
                    .filter(emp -> emp.getDepartment().getId() == d.getId())
                    .peek(employee -> { // peek no need to return object
                        countEmployee.put(d.getCode(), countEmployee.getOrDefault(d.getCode(), 0L) + 1);
                    });
        });
        System.out.println(countEmployee);
        /*
         * way 3: using Set<Object> vs size() convert dataType to Long
         *
         *  */
        departments.stream().forEach(department -> {
            Set<Employee> employeeSet = employees.stream()
                    .filter(employee -> employee.getDepartment().getId() == department.getId())
                    .collect(Collectors.toSet());
            countEmployee.put(department.getCode(), (long) employeeSet.size());
        });
        System.out.println(countEmployee);

        Map<Integer, Department> departmentMap = departments.stream()
                .collect(Collectors.toMap(Department::getId, department -> department));

        long maleCount = employees.stream()
                .filter(e -> e.getDepartment().getId() == 1 && e.getGender() == Gender.M)
                .count();
        System.out.println("Số lượng nhân viên nam trong phòng ban 1: " + maleCount);


        Month currentMonth = LocalDate.now().getMonth();
        Map<String, List<Employee>> birthdayEmployees = employees.stream()
                .filter(e -> e.getDoB().getMonth().equals(currentMonth))
                .collect(Collectors.groupingBy(e -> departmentMap.get(e.getDepartment()).getName()));

        System.out.println("\nEmployees with birthdays this month, grouped by department:");
        birthdayEmployees.forEach((dept, empList) -> {
            System.out.println("Department: " + dept);
            empList.forEach(System.out::println);
        });
    }
}

