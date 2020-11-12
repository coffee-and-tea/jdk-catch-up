package coffee_and_tea.jdk8.jep103_parallel_array_sorting;

/* *
 * pick the min, put in the first place of the non sorted part
* */
public class SelectionSort {

    /* *
     * Sort entire array
    * */
    public static void sort(int [] array){
        sort(array, 0, array.length-1);
    }

    /* *
    * Sort part of array
    * */
    public static void sort(int [] array, int beginIndex, int endIndex){
        if (beginIndex < 0 || endIndex >= array.length || beginIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Sorting range out of bound");
        }

        int min = array[beginIndex];
        int minIdx = beginIndex;
        for(int i = beginIndex+1; i <= endIndex; i++) {
                if ( array[i] < min) {
                    min = array[i];
                    minIdx = i;
                }
        }

        swap(array, beginIndex, minIdx);

        if(beginIndex < endIndex - 1) {
            sort(array, beginIndex + 1, endIndex);
        }
    }

    private static void swap(int[] array, int posA, int posB) {

        if(posA != posB) {
            int tmp = array[posA];
            array[posA] = array[posB];
            array[posB] = tmp;
        }
    }
}
