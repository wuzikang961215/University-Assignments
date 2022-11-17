public class InsertionSort extends MySortAlg{
    
    // overriding the sort method in father class
    public int [] sort(int [] array){
        int i, j, key;
        for(i = 1 ; i < array.length; i++){
            key = array[i]; // key variable is for saving bigger element
            j = i-1;
            // move smaller elements to the bigger index
            while(j >= 0 && array[j] < key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key; 
        }
        return array;
    }
}