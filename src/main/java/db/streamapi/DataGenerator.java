package db.streamapi;

import com.github.javafaker.Faker;
import db.streamapi.cat.Cat;
import db.streamapi.employee.Employee;

import java.math.BigDecimal;
import java.nio.file.FileAlreadyExistsException;

public final class DataGenerator {

    public static Cat newCat(){
        com.github.javafaker.Cat cat = new Faker().cat();
        return new Cat(cat.name(), cat.breed(), cat.registry());
    }

    public static Employee newEmployee(){
        String name = new Faker().name().name();
        BigDecimal salary = BigDecimal.valueOf(new Faker().number().randomDouble(0, 1000, 1100));
        return new Employee(name, salary);
    }
}
