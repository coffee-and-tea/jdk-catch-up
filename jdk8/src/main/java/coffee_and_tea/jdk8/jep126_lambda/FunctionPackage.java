package coffee_and_tea.jdk8.jep126_lambda;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionPackage {

    public static void main(String[] args) {

        // Function<T,R>
        playWithFunction();
        // BiFunction<T,U,R>
        playWithBiFunction();

        // BinaryOperation<T>
        playWithBinaryOperation();
        // UnaryOperation<T>
        playWithUnaryOperation();

        // Predicate<T>
        playWithPredicate();

        // Supplier<T>
        playWithSupplier();

        // Consumer<T>
        playWithConsumer();
    }

    private static void playWithConsumer() {

        Consumer<String> printIt = System.out::println;

        printIt.accept("Coffee and Tea");
    }

    private static void playWithSupplier() {

        Supplier<String> coffeeAndTea = () -> "Coffee and Tea";

        System.out.println("My cats are " + coffeeAndTea.get());
    }

    private static void playWithPredicate() {

        Predicate<String> coffeeOrTea = (x) -> x.toLowerCase().contains("coffee") || x.toLowerCase().contains("tea");

        System.out.println("Coffee or tea? " + coffeeOrTea.test("TEA please"));
    }

    private static void playWithUnaryOperation() {

        UnaryOperator<String> hello = (x) -> "Hello " + x;

        System.out.println(hello.apply("Coffee"));
    }

    private static void playWithBinaryOperation() {
        BinaryOperator<Stream<String>> filter = (x, y) -> {
            ArrayList<String> yList = y.collect(Collectors.toCollection(ArrayList::new));
            return x.filter(
                    a -> !yList.contains(a)
                    );
        };


        Stream<String> streamA = Stream.of("a", "b", "c", "d");
        Stream<String> streamB = Stream.of("d", "e");

        filter.apply(streamA, streamB).forEach(System.out::println);

    }

    private static void playWithBiFunction() {
        BiFunction<Character, String, StringBuilder> append = (x, y) -> new StringBuilder(y.length()+1).append(x).append(y);
        StringBuilder result = append.apply('a', "bc");
        System.out.println(result);
    }

    private static void playWithFunction() {
        Function<Integer, Long> cast = (x) -> Long.valueOf(x);
        Object x = cast.apply(10);
        System.out.println(x instanceof Long);
    }
}
