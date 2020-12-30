package coffee_and_tea.jdk8.jep103_parallel_array_sorting;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class ArraysParallelSort {

    public static void main(String [] args) {
        Instant before, after;
        int[] ints100 = new Random().ints(1000000).toArray();

        int[] ints100Second = new Random().ints(1000000).toArray();

        before = Instant.now();
        Arrays.sort(ints100Second);
        after = Instant.now();

        System.out.println("Single thread execution time: " + Duration.between(before, after));

        before = Instant.now();
        Arrays.parallelSort(ints100);
        after = Instant.now();
        System.out.println("Parallel execution time: " + Duration.between(before, after));
    }
}
