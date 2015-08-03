/**
 * Created by guillermo on 4/27/15.
 */
public class SortTester {


    public SortTester() {
        int[] array = {23,12,3,7,5,4,3,1,7};
        System.out.println("The original array is");
        for(int element:array)
            System.out.print(element + ", ");
        System.out.println();
//        Sorter.bubbleSort(array);
//        System.out.println("After sorting with bubblesort");
//        for(int element:array)
//            System.out.print(element + ", ");
//        Sorter.selectionSort(array);
//        System.out.println("After sorting with selection sort");
//        for(int element:array)
//            System.out.print(element + ", ");
        Sorter.insertionSort(array);
        System.out.println("After sorting with insertion sort");
        for(int element:array)
            System.out.print(element + ", ");

    }

    public static void main(String [] args) {
        try {
            new SortTester();
        }
        catch(Exception e) {
            System.out.println("ERROR: " + e);
            e.printStackTrace();
        }
    }
}
