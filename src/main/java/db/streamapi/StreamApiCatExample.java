package db.streamapi;

import java.util.ArrayList;
import java.util.List;

public class StreamApiCatExample {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            cats.add(DataGenerator.newCat());
        }

        // cats.stream().forEach(cat -> System.out.println(cat));

        // filter
        cats.stream()
                .filter(cat -> cat.getName().startsWith("A"))
                .filter(cat -> cat.getName().endsWith("l"))
                .filter(cat -> cat.getRegistry().length() < 20)
                .sorted((c1, c2) -> -c1.getBreed().compareTo(c2.getBreed()))
                .forEach(cat -> System.out.println(cat));
    }
}
