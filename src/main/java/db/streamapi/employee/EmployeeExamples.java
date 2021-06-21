package db.streamapi.employee;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeExamples {

    public static void main(String[] args) {
        EmployeeRepo employeeRepo = new EmployeeRepo();
        Employee marian = employeeRepo.findEmployeeByName("Marian");
        if (marian != null) {
            System.out.println(marian.getName());
        }

        Optional<Employee> maybeMarian = employeeRepo.findEmployeeByNameOptional("Marian");
        if (maybeMarian.isPresent()) {
            marian = maybeMarian.get();
        }

        Optional<Employee> maybeMinEmployee = employeeRepo.getAll().stream()
                .min((e1, e2) -> e1.getSalary().compareTo(e2.getSalary()));
        String response = maybeMinEmployee.isPresent() ? maybeMinEmployee.get().toString() : "Sorry! :(";
        System.out.println(response);

        // obliczmy wszystkie pensje pracowników
        BigDecimal totalSalary = employeeRepo.getAll().stream()
                .map(e -> e.getSalary())
                .reduce(BigDecimal.ZERO, (s1, s2) -> s1.add(s2));

        System.out.println(totalSalary);

        var employeeGrouped = employeeRepo.getAll().stream()
                .collect(Collectors.groupingBy(e -> e.getSalary()));


        // wynagrodzenie: ilu pracowników
        employeeGrouped.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + ":" + entry.getValue().size());
        });

        System.out.println("---------------------------------");


        // Map<BigDecimal, Integer>
        var map = employeeGrouped.entrySet().stream()
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> e.getValue().size()
                ));

        map.entrySet().forEach(e -> {
                    System.out.println(e.getKey() + ":" + e.getValue());
                }
        );
    }


}
