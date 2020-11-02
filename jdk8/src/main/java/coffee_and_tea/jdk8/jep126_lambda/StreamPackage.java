package coffee_and_tea.jdk8.jep126_lambda;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPackage {

    private static int count = 0;
    private static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) {

        // lazy seeking for intermediate operation, lazy until terminate operation performed
        playWithLazySeeking();

        // build stream from Collection stream(), Arrays.stream(), Stream.of ... Ramdom.ints()
        playWithStreamFactories();

        // parallel vs sequential execution, ordering on ordered source and none-ordered source
        playWithParallelAndSequentialExecution();

        // iterator, splititerator escape-hatch operations
        playWithIterator();
        playWithSplitIterator();

        // stateless vs stateful, synchronized vs non synchronized access
        playWithState();

        // reduce function
        playWithReduce();

        // collector
        playWithCollector();

    }

    private static void playWithCollector() {
        StringBuilder collected = Stream.of("a", "b", "c", "d", "e", "f", "g").collect(
                StringBuilder::new,
                (a, b) -> a.append(" " + b),
                (a,  b) -> { a.append(" " + b); }
        );

        System.out.println(collected.toString());

        Map<Integer, List<String>> mapped = Stream.of("a", "a", "b", "b", "b", "c", "c").collect(
                Collectors.groupingBy(
                        String::hashCode
                )
        );

        System.out.println(mapped);

        Map<String, String> mappList = Stream.of("a", "a", "b", "b", "b", "c", "c").collect(
                Collectors.toMap(
                        (String a) -> {
                            return a;
                        },
                        (a) -> {
                            return a;
                        },
                        (a, b) -> {
                            return a + b;
                        }
                )
        );

        System.out.println(mappList);
    }

    private static void playWithReduce() {
        IntStream intStream = new Random().ints(100);

        OptionalInt result = intStream.reduce((a, b) -> a + b);
        System.out.println(result.getAsInt());

        String combine = Stream.of("a", "b", "c", "d", "e", "f", "g").parallel().reduce(
                new String(),
                (a, b) -> {
                    System.out.println("accumulator called with :" + a + " and " + b);
                    return a + b;
                },
                (a, b) -> {
                    System.out.println("combine function called with: " + a + " and " + b);
                    return a + b;
                }
        );

        System.out.println(combine);
    }

    private static void playWithState() {

        // keep state information in stream processing
        IntStream intStream = new Random().ints(100);
        intStream.parallel().forEach((y) -> {
            count++;
        });
        // count won't be 100 due to stateful function in stream
        System.out.println(count);

        // synchrized processing, trade off on performance
        intStream = new Random().ints(100);
        intStream.parallel().forEach((y) -> {
            atomicCount.incrementAndGet();
        });
        // count will be 100
        System.out.println(atomicCount);
    }


    private static void playWithSplitIterator() {
        Spliterator<Integer> integerIterator = new Random().ints(100).spliterator();
        Spliterator<Integer> anotherIterator = integerIterator.trySplit();

        Runnable iterator1 = () -> {
            System.out.println("iterator1 started");
            while (
                    integerIterator.tryAdvance((x) -> System.out.println("split iterator 1: " + x))
            ) {
            }
        };
        Runnable iterator2 = () -> {
            System.out.println("iterator2 started");
            while (
                    anotherIterator.tryAdvance((x) -> System.out.println("split iterator 2: " + x))
            ) {
            }
        };
        new Thread(iterator1).start();
        new Thread(iterator2).start();
    }

    private static void playWithIterator() {
        DoubleStream doubleStream = new Random()
                .doubles(100)
                .filter((x) -> {
                            System.out.println("filtering: " + x);
                            return x > 0;
                        }
                );
        Iterator<Double> doubleIterator = doubleStream.iterator();
        System.out.println("Start to use iterator, nothing should have printed so far:");
        while (doubleIterator.hasNext()) {
            System.out.println("Positive double: " + doubleIterator.next());
        }
    }

    private static void playWithParallelAndSequentialExecution() {
        long[] longArray = new Random().longs(10).toArray();
        System.out.println("Array in order:");
        System.out.println(Arrays.toString(longArray));

        // on ordered array parallel print does not have have advantage over sequential order, adjustment size of array to see

        // output order not guarantee
        Instant executionStart = Instant.now();
        System.out.println("parallel stream print start at: " + executionStart);
        Arrays.stream(longArray).parallel().forEach(x -> System.out.print(x + " "));
        Instant executionEnd = Instant.now();
        System.out.println("\nparallel stream print end at: " + executionEnd + " time used: " + Duration.between(executionStart, executionEnd));

        // output order the same
        executionStart = Instant.now();
        System.out.println("sequential stream print start at: " + executionStart);
        Arrays.stream(longArray).sequential().forEach(x -> System.out.print(x + " "));
        executionEnd = Instant.now();
        System.out.println("\nsequential stream print end at: " + executionEnd + " time used: " + Duration.between(executionStart, executionEnd));

        Set<Long> longSet = (Set<Long>) Arrays.stream(longArray).parallel().collect(
                HashSet<Long>::new,
                Set::add,
                Set::addAll
        );

        System.out.println("Sets size: " + longSet.size() + Arrays.toString(longSet.toArray()));

        // non ordered set parallel is having advantage than sequential, adjustment size of array to see

        // output order not guarantee
        executionStart = Instant.now();
        System.out.println("parallel stream print start at: " + executionStart);
        longSet.stream().parallel().forEach(x -> System.out.print(x + " "));
        executionEnd = Instant.now();
        System.out.println("\nparallel stream print end at: " + executionEnd + " time used: " + Duration.between(executionStart, executionEnd));

        // output order the same
        executionStart = Instant.now();
        System.out.println("sequential stream print start at: " + executionStart);
        longSet.stream().sequential().forEach(x -> System.out.print(x + " "));
        executionEnd = Instant.now();
        System.out.println("\nsequential stream print end at: " + executionEnd + " time used: " + Duration.between(executionStart, executionEnd));
    }

    private static void playWithStreamFactories() {

        // from Collection
        // list, set, map, queue can use stream() function to build stream
        ArrayDeque<String> strings = new ArrayDeque<>();
        strings.add("a");
        strings.add("b");

        System.out.println(strings.stream().collect(Collectors.joining()));

        // from Arrays
        Stream<String> alph = Arrays.stream(new String[]{"a", "b", "c", "d", "e"});

        System.out.println(alph.toArray()[0]);

        // from Stream.of
        System.out.println(Stream.of("a", "b", "c").findAny().get());

        // from Stream.iterate
        Stream<Integer> counting = Stream.iterate(0, (x) -> x + 1);
        counting.map(x -> {
            System.out.println(x);
            return x;
        }).anyMatch(x -> x == 10);

        // from IntStream.range()
        IntStream.range(0, 100).forEach(System.out::println);

        // from Random.ints()
        System.out.println("100 in 2**32 chance of finding zero: " + new Random().ints(100).anyMatch((x) -> {
            // this could take really long depend on how lucky you are in this 1 out of 2**32 game
            System.out.println("Found random int: " + x);
            return x == 0;
        }));
    }

    private static void playWithLazySeeking() {

        Stream<String> alph = Arrays.stream(new String[]{"a", "b", "c", "d", "e"});

        Predicate<String> foundA = (x) -> {
            if (x.equals("a")) {
                System.out.println("Found a");
                return true;
            } else {
                System.out.println("Not a a");
                return false;
            }
        };
        // not going to see any print lines here, lazy seeking, stream not evaluated until a terminal function called
        alph.filter(foundA);

        alph = Arrays.stream(new String[]{"a", "a", "b", "b", "c"});

        // prints in foundA will be printed here
        alph.filter(foundA).forEach(System.out::println);
    }
}
