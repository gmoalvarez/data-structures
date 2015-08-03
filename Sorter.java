/**
 * Created by guillermo on 4/27/15.
 */
public class Sorter {

    public static int[] bubbleSort(int[] array) {
        int n = array.length;
        int temp;

        for(int i = n-1; i > 0; i--)
            for(int j = 0; j < i; j++)
                if(array[j] > array[j+1]) {
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1] = temp;
                }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        int n = array.length;
        int temp;
        int indexFound;
        
        for(int i=n-1; i>0; i--) {
            temp = array[0];
            indexFound = 0;
            for (int j = 1; j <= i; j++)
                if (array[j] > temp) {
                    temp = array[j];
                    indexFound = j;
                }
            array[indexFound] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        int n = array.length;
        int insert;
        int current;

        for (int i = 0; i < n - 1; i++) {
            insert = array[i+1];
            current = i + 1;
            while(current > 0 && insert < array[current-1]) {
                array[current] = array[current-1];
                current--;
            }
            array[current]=insert;
        }
    return array;
    }

//    public static int[] mergeSort(int[] array) {
//        int[] n = array;
//        int[] aux = new int[n.length];
//        mergeSortHelper(0, n.length - 1);
//        return n;
//    }
//
//    private static void mergeSortHelper(int low,int hi) {
//        if(low == hi) return;
//        int mid = (low+hi) >> 1;
//        mergeSortHelper(low,mid);
//        mergeSortHelper(mid + 1, hi);
//        merge(low, mid + 1, hi);
//    }

//    private static void merge(int low, int hi, int upperBound) {
//        int j=0;
//        int lowerBound = low;
//        int mid = hi-1;
//        int numElements = upperBound - lowerBound + 1;// number of items
//
//        while(low <= mid && hi <= upperBound)
//            if(n[low] <= )
//    }
}
