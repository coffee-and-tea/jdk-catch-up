package coffee_and_tea.jdk8.jep126_lambda;

import java.util.Comparator;
import java.util.stream.Stream;

public class Comparators {

    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("a", "b", "c", "d", "coffee", "tea");

        // lambda comparing 2 objects
        // comparator by length short first
        Comparator<String> stringComparator = (x, y) -> {
            return x.length() - y.length();
        };
        stringStream.sorted(stringComparator).forEach(System.out::println);

        // nature order
        stringStream = Stream.of("a", "b", "c", "d", "coffee", "tea");
        stringStream.sorted(Comparator.naturalOrder()).forEach(System.out::println);

        // null first/last
        stringStream = Stream.of("a", "b", "c", "d", null, "coffee", "tea");
        stringStream.sorted(Comparator.nullsFirst(Comparator.naturalOrder())).forEach(System.out::println);

        stringStream = Stream.of("a", "b", "c", "d", null, "coffee", "tea");
        stringStream.sorted(Comparator.nullsLast(Comparator.naturalOrder())).forEach(System.out::println);

        // reverse order
        stringStream = Stream.of("a", "b", "c", "d", "coffee", "tea");
        stringStream.sorted(stringComparator.reversed()).forEach(System.out::println);

        // comparing int
        stringStream = Stream.of("a", "b", "c", "d", "coffee", "tea");
        stringStream.sorted(Comparator.comparingInt(x -> x.hashCode())).forEach(System.out::println);

    }
}
