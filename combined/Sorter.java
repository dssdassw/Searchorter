package combined;

public class Sorter {
	public short bubbleiters    = 0; //short should be enough to hold these... right?
	public short selectioniters = 0;
	public short insertioniters = 0;
	public short quicksortiters = 0;
	
	//General
	public Sorter() {
		System.out.println("Sorter created!"); //#bestConstructor2016
	}
	
	public void resetCounters() {
		bubbleiters    = 0;
		selectioniters = 0;
		insertioniters = 0;
		quicksortiters = 0;
	}
	
	private static void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if(i + 1 != array.length) {
				System.out.print(array[i] + ", ");
			}
			else {
				System.out.print(array[i] + "]");
			}
		}
		System.out.println("");
	}
	
	//Sorting
	public int[] bubble(int[] arr, boolean descend) { //modified version of http://mathbits.com/MathBits/Java/arrays/Bubble.htm
		int j;
		int temp;
		boolean flag = true;
		if (descend) {
			while (flag) {
				flag = false;
				for (j = 0; j < arr.length - 1; j++) {
					if (arr[j] < arr[j + 1]) {
						temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
						flag = true;
					}
				}
				bubbleiters += 1;
				System.out.println("Bubble sort iteration #" + bubbleiters);
				printArray(arr);
			}
		}
		else {
			while (flag) {
				flag = false;
				for (j = 0; j < arr.length-1; j++) {
					if (arr[j] > arr[j + 1]) {
						temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
						flag = true;
					} 
				}
				bubbleiters += 1;
				System.out.println("Bubble sort iteration #" + bubbleiters);
				printArray(arr);
			}
		}
		return arr;
	}
	
	public int[] selection(int[] arr, boolean descend){ //modified version of http://www.algolist.net/Algorithms/Sorting/Selection_sort
		selectioniters += 1;
		System.out.println("Selection sort iteration #" + selectioniters);
		printArray(arr);
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
				selectioniters += 1;
				System.out.println("Selection sort iteration #" + selectioniters);
				printArray(arr);
			}
		}
		else {
			for (int i = 0; i < arr.length - 1; i++) {
				int index = i;
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] < arr[index]) {
						index = j;
					}
				}
				int smallernumber = arr[index]; 
				arr[index] = arr[i];
				arr[i] = smallernumber;
				selectioniters += 1;
				System.out.println("Selection sort iteration #" + selectioniters);
				printArray(arr);
			}
		}
		return arr;
	}
	
	public int[] insertion(int[] arr, boolean descend) { //modified version of http://www.algolist.net/Algorithms/Sorting/Insertion_sort
		int i, j, newValue;
		if (descend) {
			for (i = 1; i < arr.length; i++) {
				newValue = arr[i];
				for (j = i - 1; (j >= 0) && (arr[j] < newValue); j--) {
					arr[j + 1] = arr[j];
				}
				arr[j + 1] = newValue;
				insertioniters += 1;
				System.out.println("Insertion sort iteration #" + insertioniters);
				printArray(arr);
			}
		}
		else {
			for (i = 1; i < arr.length; i++) {
				newValue = arr[i];
				for (j = i - 1; (j >= 0) && (arr[j] > newValue); j--) {
					arr[j + 1] = arr[j];
				}
				arr[j + 1] = newValue;
				insertioniters += 1;
				System.out.println("Insertion sort iteration #" + insertioniters);
				printArray(arr);
			}
		}
		return arr;
	}
	
	public int[] quicksort(int[] arr, boolean descend) { //modified version of http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
		if (descend) {
			return descendPartition(arr, 0, arr.length - 1);
		}
		else {
			return ascendPartition(arr, 0, arr.length - 1);
		}
	}
	
	private int[] descendPartition(int[] arr, int low, int high) {
		int l = low, h = high; //i=l && j=h
		int pivot = arr[low + (high-low)/2];
		while (l <= h) {
			while (arr[l] > pivot) { //the '>' here and '<' in the next determines that it sorts in descending order
				l++;
			}
			while (arr[h] < pivot) {
				h--;
			}
			if (l <= h) {
				int temp = arr[l];
				arr[l] = arr[h];
				arr[h] = temp;
				l++;
				h--;
			}
		}
		quicksortiters += 1;
		System.out.println("Quicksort iteration #" + quicksortiters);
		printArray(arr);
		if (low < h) {
			descendPartition(arr, low, h);
		}
		if (l < high) {
			descendPartition(arr, l, high);
		}
		return arr; //will only reach this point if it does not recurse, so it is okay to return, but...
	} //...where exactly does this return? Down the stack? Or to the 'questgiver'? Does the questgiver return it to its questgiver?
	private int[] ascendPartition(int[] arr, int low, int high) {
		int l = low, h = high; //i=l && j=h
		int pivot = arr[low + (high-low)/2];
		while (l <= h) {
			while (arr[l] < pivot) { //the '>' here and '<' in the next determines that it sorts in descending order
				l++;
			}
			while (arr[h] > pivot) {
				h--;
			}
			if (l <= h) {
				int temp = arr[l];
				arr[l] = arr[h];
				arr[h] = temp;
				l++;
				h--;
			}
		}
		quicksortiters += 1;
		System.out.println("Quicksort iteration #" + quicksortiters);
		printArray(arr);
		if (low < h) {
			ascendPartition(arr, low, h);
		}
		if (l < high) {
			ascendPartition(arr, l, high);
		}
		return arr;
	}
}