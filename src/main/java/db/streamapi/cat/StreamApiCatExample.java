package db.streamapi.cat;

import db.streamapi.DataGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiCatExample {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            cats.add(DataGenerator.newCat());
        }

        // cats.stream().forEach(cat -> System.out.println(cat));

        // filter
//        cats.stream()
//                .filter(cat -> cat.getName().startsWith("A"))
//                .filter(cat -> cat.getName().endsWith("l"))
//                .filter(cat -> cat.getRegistry().length() < 20)
//                .sorted((c1, c2) -> -c1.getBreed().compareTo(c2.getBreed()))
//                .forEach(cat -> System.out.println(cat));


        // map
        // wyciągnij imiona kotów i posortuj
        cats.stream()
                .map(cat -> cat.getName())
                .filter(name -> name.length() > 6)
                .sorted()
                .limit(5)
                .forEach(name -> System.out.println(name));


        List<String> catsNames = cats.stream()
                .map(cat -> cat.getName())
                .filter(name -> name.length() > 6)
                .sorted()
                .limit(5)
                .collect(Collectors.toList());



    }
}
