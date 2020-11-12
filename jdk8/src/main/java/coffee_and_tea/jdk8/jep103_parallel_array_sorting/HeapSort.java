package coffee_and_tea.jdk8.jep103_parallel_array_sorting;

public class HeapSort {

    public static void sort(int[] array) {

        // heapify array first by heapify on node from last none leaf node to root
        // assume array of size n, last none leaf node of a complete binary tree is n/2 - 1
        int n = array.length;
        for(int i = n/2 -1; i >=0; i--) {
            heapify(array, n, i);
        }

        for(int i = n - 1; i > 0; i--){
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int pos) {

        if (pos*2+1 < n && array[pos*2+1] > array[pos]){
            swap(array, pos, pos*2+1);
            heapify(array, n, pos*2+1);
        }
        if (pos*2+2 < n && array[pos*2+2] > array[pos]){
            swap(array, pos, pos*2+2);
            heapify(array, n, pos*2+2);
        }
    }

    private static void swap(int[] array, int posA, int posB) {
        int tmp = array[posA];
        array[posA] = array[posB];
        array[posB] = tmp;
    }
}
