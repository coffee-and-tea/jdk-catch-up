package coffee_and_tea.jdk8.jep103_parallel_array_sorting;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int [] array){
        
        sort(array, 0, array.length-1);
    }

    private static void sort(int[] array, int start, int end) {

        if(end > start) {
            int mid = start + (end - start) / 2;
            sort(array, start, mid);
            sort(array, mid+1, end);

            merge(array, start, mid, end);
        }

    }

    private static void merge(int[] array, int start, int mid, int end) {
        int [] temp = Arrays.copyOfRange(array, start, end+1);
        int firstHalfMinIdx = 0;
        int secondHalfMinIdx = mid+1-start;
        for (int i = 0; i < temp.length; i++){
            if(firstHalfMinIdx == mid+1-start){
                array[start+i] = temp[secondHalfMinIdx];
                secondHalfMinIdx++;
            }else if(secondHalfMinIdx == temp.length){
                array[start+i] = temp[firstHalfMinIdx];
                firstHalfMinIdx++;
            }else if(temp[firstHalfMinIdx] <= temp[secondHalfMinIdx]){
                array[start+i] = temp[firstHalfMinIdx];
                firstHalfMinIdx++;
            } else {
                array[start+i] = temp[secondHalfMinIdx];
                secondHalfMinIdx++;
            }
        }
    }
}
