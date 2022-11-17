/*
*   Foundations of Computer Science
*   2020, Trimester 3
*   Practical-Exam-04
*
*   student (id): a1816094
*   student (name): Zikang, Wu
*
* Note: in order to finish your exam you need to make changes in this class
* Problem 03
*/
public class Selection extends Sort{

	@Override
	public int [] sortIntByIndex(int [] arr){
		// selection sort
		for(int i = 0; i < arr.length-1; i++){
			// this variable is the minimun index
			int minIndex = i;
			int key = arr[i];
			for(int j = i+1; j < arr.length; j++){
				if(arr[j] < arr[minIndex])
					minIndex = j;
			}
			// swap the minimum index and i
			arr[i] = arr[minIndex];
			arr[minIndex] = key;
		}
		return arr;
	}

	@Override
	public int [] sortInt(int [] arr){
		throw new java.lang.UnsupportedOperationException("Not implemented yet!");
	}


	@Override
	public int [] sortStringByIndex(String [] arr){
		throw new java.lang.UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public String [] sortString(String [] arr){
		throw new java.lang.UnsupportedOperationException("Not implemented yet!");
	}
}
