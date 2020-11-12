package coffee_and_tea.jdk8.jep103_parallel_array_sorting;

public class QuickSort {

    public static void sort(int[] array) {

        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {

        if(start < end){
            int pos = partition(array, start, end);
            sort(array, start, pos-1);
            sort(array, pos+1, end);
        }

    }

    /**
    * Partition at last position
    * */
    private static int partition(int[] array, int start, int end) {
        int privot = array[end];

        int smallLastIdx = start;

        for(int i = start; i < end; i ++) {
            if(array[i] < privot) {
                swap(array, i, smallLastIdx);
                smallLastIdx++;
            }
        }
        swap(array, smallLastIdx, end);
        return smallLastIdx;
    }

    private static void swap(int[] array, int posA, int posB) {
        int tmp = array[posA];
        array[posA] = array[posB];
        array[posB] = tmp;
    }
}
