package coffee_and_tea.jdk8.jep103_parallel_array_sorting;

import java.util.LinkedList;

public class InsertionSort {

    public static void sort(int [] array) {
        if(array.length > 1) {
            sort(array, 1);
        }
    }

    private static void sort(int [] array, int pos){
        if(pos > array.length - 1 ) {
            throw new ArrayIndexOutOfBoundsException("Pos is greater than array length");
        }

        int swapIdx = pos - 1;
        int temp = array[pos];

        while( swapIdx >= 0 && array[swapIdx] > temp ) {
            array[swapIdx + 1] = array[swapIdx];
            swapIdx--;
        }

        array[swapIdx + 1] = temp;

        if(pos < array.length -1){
            sort(array, pos+1);
        }
    }

    public static void sort(LinkedList<Integer> bucket) {
    }
}
