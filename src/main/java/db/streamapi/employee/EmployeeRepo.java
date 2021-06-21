package db.streamapi.employee;

import db.streamapi.DataGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepo {
    private static final int NUMBER_OF_EMPLOYEES = 1000;

    private List<Employee> employees = new ArrayList<>();

    public EmployeeRepo() {
        generateEmployees(NUMBER_OF_EMPLOYEES);
    }

    public Employee findEmployeeByName(String name){
        for (Employee e : employees) {
            if(e.getName().equals(name)){
                return e;
            }
        }
        return null;
    }

    public Optional<Employee> findEmployeeByNameOptional(String name){
        for (Employee e : employees) {
            if(e.getName().equals(name)){
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }

    public List<Employee> getAll() {
        return employees;
    }

    private void generateEmployees(int n) {
        for (int i = 0; i < n; i++) {
            employees.add(DataGenerator.newEmployee());
        }
    }
}
