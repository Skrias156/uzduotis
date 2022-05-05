package tt;

import java.util.Comparator;
import java.util.stream.Stream;

public class value {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Go home", "interesting", "SOMETHING", "GOOD LUCK");
        String value = stream.map(String::toUpperCase)
        .filter(v -> v.length() > 7)
                .map(v ->v.replace(" ", "_"))
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
        System.out.println(value);
    }
}
