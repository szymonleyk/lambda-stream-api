package db.streamapi.cat;

import java.util.ArrayList;
import java.util.List;

public class StreamApiCarExample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Jurek");
        names.add("Czarek");
        names.add("Kasia");
        names.add("Ktoś");
        names.add("Zosia");
        names.add("Karol");

        names.stream().filter(name -> name.startsWith("K")).forEach(name -> System.out.print(name + ", "));
        System.out.println();

        names.stream()
                .filter(name -> name.startsWith("K"))
                .filter(name -> name.endsWith("a"))
                .forEach(name -> System.out.print(name + ", "));
        System.out.println();
    }
}
