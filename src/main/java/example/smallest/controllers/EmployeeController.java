package example.smallest.controllers;

import example.smallest.Utililty.FakerUtility;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    static List<Employee> employees;

    @GetMapping("/generate-fake-data")
    String generateFakeData() {
        employees = FakerUtility.generate();
        return "generated!!";
    }

    @GetMapping("/employees")
    List<Employee> getAll() {
        return employees;
    }

    @GetMapping("/employee")
    public List<Employee> getEmployees(@RequestParam(required = false) String name,
                                       @RequestParam(required = false) String country) {
        return employees.stream()
                .filter(e -> ( name != null && e.getName().equals(name) )||
                        (country != null && e.getCountry().equals(country)))
                .collect(Collectors.toList());
    }
}


