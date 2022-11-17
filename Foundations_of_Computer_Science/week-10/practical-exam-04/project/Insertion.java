/*
*   Foundations of Computer Science
*   2020, Trimester 3
*   Practical-Exam-04
*
*   student (id): a1816094
*   student (name): Zikang, Wu
*
* Note: in order to finish your exam you need to make changes in this class.
* Note that you have to implemented lines from 57 - 67
*
*/
public class Insertion extends Sort{

	char [] alphas = {'B', 'J', 'M', 'V'};

	// search for the alphas
	public int searchAlpha(char n){
		int index = 0;
		for(int i = 0; i < alphas.length; i++){
			if(n == alphas[i]){
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public int [] sortIntByIndex(int [] arr){
		int [] index = this.getIndex(arr.length);

		for(int i = 1; i < arr.length; i++){
			int key = arr[i];
			int keyIndex = index[i];
			int j = i - 1;
			while( j >= 0 && arr[j] > key){
				if(arr[j] > key){
					arr[j+1] = arr[j];
					index[j+1] = index[j];
					j--;
				}
			}
			arr[j+1] = key;
			index[j+1] = keyIndex;
		}
		return index;
	}

	@Override
	public int [] sortInt(int [] arr){
		int [] index = this.getIndex(arr.length);

		for(int i = 1; i < arr.length; i++){
			int key = arr[i];
			int keyIndex = index[i];
			int j = i - 1;
			while( j >= 0 && arr[j] > key){
				if(arr[j] > key){
					arr[j+1] = arr[j];
					index[j+1] = index[j];
					j--;
				}
			}
			arr[j+1] = key;
			index[j+1] = keyIndex;
		}
		return arr;
	}


	@Override
	public int [] sortStringByIndex(String [] arr){
		// save the index
		int [] index = new int[arr.length];
		for(int j = 0; j < index.length; j++)
			index[j] = j;
		
		for(int i = 1; i < arr.length; i++){
			// save the arr[i]'s index here
			int key = index[i];
			int j = i - 1;
			// search for smaller Strings 
			while(j >= 0 && searchAlpha(arr[i].charAt(0)) > searchAlpha(arr[j].charAt(0))){
				index[j+1] = index[j];
				j--;
			}
			// put the smaller Strings in the front
			index[j+1] = key;
		}
		return index;
		
	}

	@Override
	public String [] sortString(String [] arr){
		for(int i = 1; i < arr.length; i++){
			// save the arr[i] here
			String key = arr[i];
			int j = i - 1;
			// search for smaller Strings 
			while(j >= 0 && searchAlpha(arr[i].charAt(0)) > searchAlpha(arr[j].charAt(0))){
				arr[j+1] = arr[j];
				j--;
			}
			// put the smaller Strings in the front
			arr[j+1] = key;
		}
		return arr;
	}


}