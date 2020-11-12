package coffee_and_tea.jdk8.jep103_parallel_array_sorting;

public class BubbleSort {

    public static void sort(int[] array) {
        boolean swapFound = true;

        while (swapFound) {
            swapFound = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swapFound = true;
                    swap(array, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] array, int posA, int posB) {
        int tmp = array[posA];
        array[posA] = array[posB];
        array[posB] = tmp;
    }
}
