package combined;

public class Searcher {
	public short sequentialiters    = 0; //short should be enough to hold these... right?
	public short binaryiters        = 0;

	public Searcher() {
		System.out.println("Searcher created!");
	}
	
	public void resetCounters() {
		sequentialiters = 0;
		binaryiters     = 0;
	}
	
	public int sequential(int target, int[] arr) {
		int foundAt = -1; //as in, what WAS found, not a status indicator
		for (int i = 0; i < arr.length; i++) {
			sequentialiters += 1;
			System.out.println("Sequential search iteration #" +  sequentialiters);
			if (arr[i] == target) {
				foundAt = i;
				break;
			}
		}
		return foundAt; //foundAt will be -1 if the value is not found, otherwise it'll be the index it was found at
	}
	
	public int binary(int target, int[] arr) {
		return binaryrecurse(target, arr, arr[0], arr[(int) (Math.floor((arr.length-1)/2))], arr.length-1); //mathsssssssssssssssssss PLURALsSSSSSSSSSSSsSsSsSssSSSSsSs
	} //the floor thing in there takes the value to the left of the array middle even if it's not round
	
	private int binaryrecurse(int target, int[] arr, int btm, int mid, int top) {
		binaryiters += 1;
		System.out.println("Binary search iteration #" + binaryiters);
		if (target<arr[mid]) {
			top = mid;
			mid = (int) (btm+top)/2;
			binaryrecurse(target, arr, btm, mid, top);
		}
		if (target>arr[mid]) {
			btm = mid;
			mid = (int) (btm+top)/2;
			binaryrecurse(target, arr, btm, mid, top);
		}
		return mid;
	}
}
