import java.util.Arrays;

public class Main{
    
    // testing if two arrays are the same
    public static boolean test(int [] result, int [] ans){
        return Arrays.equals(result, ans);
    }

    // compare two arrays 
    public static boolean compare(int [] arr1, int [] arr2){
        QuickSort quicksort = new QuickSort();
        return Arrays.equals(quicksort.sort(arr1), quicksort.sort(arr2));
    }

    public static int findSmallestSum(int [] array){
        MergeSort mergesort = new MergeSort();
        // since the sorted array is in descending order, sum up the last two elements
        return (mergesort.sort(array)[array.length-1]+mergesort.sort(array)[array.length-2]);
    }

    public static void main(String [] args){
        // arrays for testing
        int [] array1 = {34, 58, 54, 20, 76, 35, 52, 23};
        int [] array1_sorted = {76, 58, 54, 52, 35, 34, 23, 20};
        int [] array2 = {2, 5, 3 ,1};
        int [] array2_sorted = {5, 3, 2, 1};
        int [] array3 = {345, 1234, 76, 3, 432, 876, 214231, 56, 5, 6, 234, 76};
        int [] array3_sorted = {214231, 1234, 876, 432, 345, 234, 76, 76, 56, 6, 5, 3};

        // creating objects of sorting classes
        InsertionSort i = new InsertionSort();
        MergeSort m = new MergeSort();
        QuickSort q = new QuickSort();
        
        // three test cases
        System.out.println(test(q.sort(array1), array1_sorted));
        System.out.println(test(i.sort(array2), array2_sorted));
        System.out.println(test(m.sort(array3), array3_sorted));

        // arrays for comparing
        int [] arr1 = {4, 64, 7, 23, 89, 89};
        int [] arr2 = {89, 7, 64, 23, 4, 89};
        // call compare method
        System.out.println(compare(arr1, arr2));

        // finding smallest sum
        System.out.println(findSmallestSum(array1));
    }
}