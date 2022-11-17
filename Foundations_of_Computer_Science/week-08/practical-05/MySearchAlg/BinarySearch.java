public class BinarySearch {//extends MySearchAlg{

    // implement search method
    public int search(int [] array, int num){

        int index = binarySearch(array, num, 0, array.length-1);
        return index;

    }

    // binary search
    private int binarySearch(int [] array, int num, int left, int right){
        while(right - left >= 0){
            // get the middle index
            int middle = left + (right - left) / 2;
            if( array[middle] == num)
                return middle;
            else if(array[middle] > num)
                // maybe the num is on the left
                return binarySearch(array, num, left, middle-1);
            else if(array[middle] < num)
                // maybe the num is on the right
                return binarySearch(array, num, middle+1, right);
        }
        return -1;
    }

}