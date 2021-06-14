import db.app1.Car;
import db.app1.Message;
import db.app1.Status;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        /*
        UnaryOperator<T> - wejście 1xT, wyjście T (apply)
        BinaryOperator<T> - wejście 2xT, wyjście T (apply)
        Consumer<T> - wejście 1xT, wyjście void, (accept)
        Supplier<T> - wejście void, wyjście T (get)
        Function<T,R> - wejscie 1xT, wyjście R (apply)
        Predicate<T> - wejście 1xT, wyjście boolean (test)
        */

        UnaryOperator<Car> repair = car -> {
            car.setStatus(Status.READY);
            return car;
        };

        Car car = new Car("Fiat", Status.NEW);
        car.setStatus(Status.TO_REPAIR);
        car = repair.apply(car);
        System.out.println(car);

        BinaryOperator<Integer> sum = (a,b) -> a+b;
        int result = sum.apply(3,5);
        System.out.println(result);

        Consumer<Message> readEmail = email -> System.out.println(email);
        Message email = new Message("Zapraszam na spotkanie", "Siema, jutro o 10 spotkanie.");
        readEmail.accept(email);
        Message email2 = new Message("Zapotrzebowanie na sprzęt", "Siema, potrzebuję nowego lapka.");
        readEmail.accept(email2);

        Consumer<Message> filterSpam = message -> {
            if(!message.getEmail().endsWith("wp.pl") && !message.getDescription().contains("oferta")){
                System.out.println(message);
            }
        };

        Message message3 = new Message("Ważna wiadomość!", "Tylko do jutra....", "marek@wp.pl");
        filterSpam.accept(message3);
        Message message4 = new Message("Ważna wiadomość!", "Tylko do jutra....oferta...kliknij tutaj...", "marek@onet.pl");
        filterSpam.accept(message4);
        Message message5 = new Message("Ważna wiadomość!", "Tylko do jutra....", "marek@onet.pl");
        filterSpam.accept(message5);

        Supplier<Car> produceBMW5 = () -> new Car("BMW 5", Status.NEW);

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cars.add(produceBMW5.get());
        }
        System.out.println(cars);

        Function<Car, db.app2.Car> mapCarApp1ToCarApp2 = carApp1 -> new db.app2.Car(carApp1.getName());
        List<db.app2.Car> carsApp2 = new ArrayList<>();
        for (Car c:cars) {
            carsApp2.add(mapCarApp1ToCarApp2.apply(c));
        }
        System.out.println(carsApp2);

        Predicate<String> correctEmail = e -> e.contains("@");
        System.out.println(correctEmail.test("siema"));
        System.out.println(correctEmail.test("marek@wp.pl"));
        System.out.println(correctEmail.test("janusz.onet.pl"));

        cars.forEach(c -> System.out.println(c));

        cars.forEach(c -> {
            int randomStatusIndex = new Random().nextInt(3);
            c.setName(c.getName().replace(" ", "-").replace("5", ""+(randomStatusIndex+1)));
            c.setStatus(Status.values()[randomStatusIndex]);
        });
        System.out.println("------------------------");
        cars.forEach(c -> System.out.println(c));

        cars.removeIf(c -> c.getStatus().equals(Status.TO_REPAIR));

        System.out.println("------------------------");
        cars.forEach(c -> System.out.println(c));

        cars.replaceAll(c -> new Car());
        System.out.println("------------------------");
        cars.forEach(c -> System.out.println(c));

    }
}
