package example.smallest.Utililty;

import com.github.javafaker.Faker;
import example.smallest.controllers.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakerUtility {

    public static List<Employee> generate (){
        Faker faker = new Faker();
        List<Employee> listOfEmployee = new ArrayList<>();
        for (int i=0; i<20; i++){
            Employee e = new Employee();
            String id = UUID.randomUUID().toString();
            e.setId(id);
            e.setName(faker.name().firstName().toString());
            e.setCountry(faker.address().country().toString());
            e.setStreet(faker.address().streetName().toString());

            listOfEmployee.add(e);
        }
        return listOfEmployee;
    }
}
