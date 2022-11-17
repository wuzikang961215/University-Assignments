public class Main{
    
    // test searching methods
    private static boolean test(int result, int ans){
        // if the two ints are equal
        if(result == ans)
            return true;
        else
            return false;
    }

    // find the index of max value in array that first increase and then decrease
    private static int findMaxVal(int [] array){
        int i;
        for(i = 0; i < array.length; i++){
            if(array[i+1] < array[i])
                break;
        }
        return i;
    }

    public static void main(String [] args){
        int [] array = {46, 6, 54, 43, 3, 2, 80, 98, 78};
        int num = 43;
        int index = 3;

        int [] array1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int num1 = 6;
        int index1 = 5;

        int [] array2 = {23, 43, 54, 65, 789, 4563, 5678};
        int num2 = 54;
        int index2 = 2;

        LinearSearch l = new LinearSearch();
        // test linear search
        System.out.println(test(l.search(array, num), index));

        // test binary search
        BinarySearch b = new BinarySearch();
        System.out.println(test(b.search(array1, num1), index1));
        // test case 3
        System.out.println(test(b.search(array2, num2), index2));

        // test findMaxVal
        int [] array3 = {1, 5, 8, 12, 9, 7, -1};
        System.out.println(findMaxVal(array3));

        int [] array4 = {1, 15, 0};
        System.out.println(findMaxVal(array4));
    }
}