public class Sorter {
	public static int[] bubble(int[] arr, boolean descend) {
		int j;
		int temp;			  //holding variable
		boolean flag = true;   //set flag to true to begin first pass
		if (descend) { //the if/else is outside because then it will not have to check the variable during the actual sort. It's longer though.
			while (flag) {
				flag = false;	 //set flag to false awaiting a possible swap
				for (j = 0; j < arr.length - 1; j++) {
					if (arr[j] < arr[j + 1]) { // change to > for ascending sort
						temp = arr[j];				//swap elements
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
						flag = true;			  //shows a swap occurred  
					} 
				} 
			}	
		}
		else {
			while (flag) {
				flag = false;	 //set flag to false awaiting a possible swap
				for (j = 0; j < arr.length-1; j++) {
					if (arr[j] < arr[j + 1]) { // change to > for ascending sort
						temp = arr[j];				//swap elements
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
						flag = true;			  //shows a swap occurred  
					} 
				} 
			}
		}
		return arr;
	}
	public static int[] selection(int[] arr, boolean descend){
		if (descend) {
			for (int i = 0; i < arr.length - 1; i++) {
				int index = i;
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] > arr[index]) {
						index = j;
					}
				}
			int smallernumber = arr[index]; 
			arr[index] = arr[i];
			arr[i] = smallernumber;
			}
		}
		else {
			for (int i = 0; i < arr.length - 1; i++) {
				int index = i;
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] > arr[index]) {
						index = j;
					}
				}
			int smallernumber = arr[index]; 
			arr[index] = arr[i];
			arr[i] = smallernumber;
			}
		}
		return arr;
	}
	public static int[] insertion(int[] arr, boolean descend) {
		int i, j, newValue;
		for (i = 1; i < arr.length; i++) {
			newValue = arr[i];
			j = i;
			while (j > 0 && arr[j - 1] > newValue) {
				arr[j] = arr[j - 1];
					j--;
			}
			arr[j] = newValue;
		}
		return arr;
	}
}
