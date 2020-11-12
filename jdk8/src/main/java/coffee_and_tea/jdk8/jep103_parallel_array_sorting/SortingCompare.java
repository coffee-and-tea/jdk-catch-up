package coffee_and_tea.jdk8.jep103_parallel_array_sorting;

import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class SortingCompare {

    public static void main(String[] args) {

        Instant before, after;
        int[] ints100 = new Random().ints(200).toArray();
        int[] ints100Clone = Arrays.copyOf(ints100, ints100.length);
        int[] ints100Clone1 = Arrays.copyOf(ints100, ints100.length);
        int[] ints100Clone2 = Arrays.copyOf(ints100, ints100.length);
        int[] ints100Clone3 = Arrays.copyOf(ints100, ints100.length);
        int[] ints100Clone4 = Arrays.copyOf(ints100, ints100.length);
        int[] ints100Clone5 = Arrays.copyOf(ints100, ints100.length);


        before = Instant.now();
        Arrays.sort(ints100);
        after = Instant.now();

        // test coded selection sort
        SelectionSort.sort(ints100Clone);

        System.out.println("Selection sort is correct:" + Arrays.equals(ints100, ints100Clone));

        // test coded bubble sort
        BubbleSort.sort(ints100Clone1);
        System.out.println("Bubble sort is correct:" + Arrays.equals(ints100, ints100Clone1));

        // test coded insertion sort
        InsertionSort.sort(ints100Clone2);
        System.out.println("Insertion sort is correct:" + Arrays.equals(ints100, ints100Clone2));

        // test coded heap sort
        HeapSort.sort(ints100Clone3);
        System.out.println("Heap sort is correct:" + Arrays.equals(ints100, ints100Clone3));

        // test coded quick sort
        QuickSort.sort(ints100Clone4);
        System.out.println("Quick sort is correct:" + Arrays.equals(ints100, ints100Clone4));

        // test coded merge sort
        MergeSort.sort(ints100Clone5);
        System.out.println("Merge sort is correct:" + Arrays.equals(ints100, ints100Clone5));
    }
}
