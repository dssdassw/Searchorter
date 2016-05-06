package combined;
import java.util.Random; //only needed if doing the massive test
import combined.Sorter;

public class Searchorter {
	public static int getRand(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
	public static void main(String[] args) {
		/*int[] barray = {5, 2, 8, 3, 89, 1, 7, 9, 0, 244, 67, 2, 232, 2, 62, 624, 637, 4, 7, 6};    //a 20 element array
		int[] sarray = {5, 2, 8, 3, 89, 1, 7, 9, 0, 244, 67, 2, 232, 2, 62, 624, 637, 4, 7, 6}; //identical to the bubblearray, to be used with selection
		int[] iarray = {5, 2, 8, 3, 89, 1, 7, 9, 0, 244, 67, 2, 232, 2, 62, 624, 637, 4, 7, 6}; //identical to the bubblearray, to be used with insertion
		int[] qarray = {5, 2, 8, 3, 89, 1, 7, 9, 0, 244, 67, 2, 232, 2, 62, 624, 637, 4, 7, 6}; //identical to the bubblearray, to be used with quicksort*/
		System.out.println("Setting up...");
		Sorter sort = new Sorter();
		int len = 5000;
		int[] basearray = new int[len];
		for(int i = 0; i < basearray.length; i++){
			basearray[i] = getRand(0, 5000);
		}
		int[] barray = new int[len];
		int[] sarray = new int[len];
		int[] iarray = new int[len];
		int[] qarray = new int[len];
		System.arraycopy(basearray, 0, barray, 0, basearray.length);
		System.arraycopy(basearray, 0, sarray, 0, basearray.length);
		System.arraycopy(basearray, 0, iarray, 0, basearray.length);
		System.arraycopy(basearray, 0, qarray, 0, basearray.length);
		System.out.println("Finished setup!");
		//descending order:
		barray = sort.bubble(barray, true); 
		sarray = sort.selection(sarray, true); 
		iarray = sort.insertion(iarray, true); 
		qarray = sort.quicksort(qarray, true);
		int[] firstRun = {sort.bubbleiters, sort.selectioniters, sort.insertioniters, sort.quicksortiters};
		//and because what else makes an appropriate separator...
		System.out.println("[Chorus:] Crawling in my skin! These wounds they will not heal! Fear is how I fall, Confusing what is real! There's something inside me that pulls beneath the surface; Consuming, confusing! This lack of self-control I fear is never ending! Controlling. I can't seem... [Bridge:] To find myself again, My walls are closing in (without a sense of confidence and I'm convinced that there's just too much pressure to take) I've felt this way before... So insecure!!! [Chorus] Discomfort endlessly has pulled itself upon me! Distracting, reacting! Against my will I stand beside my own reflection! It's haunting how I can't seem... [Bridge] [Chorus] [Chorus] There's something inside me that pulls beneath the surface consuming, Confusing what is real. This lack of self-control I fear is never ending controlling, Confusing what is real.");
		//ascending order:
		sort.resetCounters();
		barray = sort.bubble(barray, false);
		sarray = sort.selection(sarray, false);
		iarray = sort.insertion(iarray, false);
		qarray = sort.quicksort(qarray, false);
		int[] secondRun = {sort.bubbleiters, sort.selectioniters, sort.insertioniters, sort.quicksortiters};
		String[] labels = {"Bubble sort took ", "Selection sort took ", "Insertion sort took ", "Quicksort took "};
		System.out.println("On the first run... ");
		for (int i = 0; i < firstRun.length; i++) {
			System.out.println(labels[i] + firstRun[i] + " iterations");
		}
		System.out.println("\nOn the second run... ");
		for (int i = 0; i < firstRun.length; i++) {
			System.out.println(labels[i] + secondRun[i] + " iterations");
		}
		//separate my lines (can't separate)
		System.out.println("How can you see into my eyes Like open doors? Leading you down into my core Where I've become so numb Without a soul... My spirit's sleeping somewhere cold. Until you find it there And lead it back home: (Wake me up) Wake me up inside!!1 (I can't wake up) Wake me up inside!!1 (Save me) Call my name and save me from the dark!!1 (Wake me up) Bid my blood to run!!1 (I can't wake up) Before I come undone!!1 (Save me) Save me from the nothing I've become!!1 Now that I know what I'm without You can't just leave me. Breathe into me and make me real. Bring me to life!!1 (Wake me up) Wake me up inside!!1 (I can't wake up) Wake me up inside!!1 (Save me) Call my name and save me from the darkness I've become!!1 (Wake me up) Bid my blood to run!!1 (I can't wake up) Before I come undone!!1 (Save me) Save me from the nothing I've become!!1 Bring me to life!!1 (I've been living a lie, there's nothing inside!!11111!!)11!111!!1!! Bring me to life! Frozen inside without your touch, Without your love, darling Only you, all the life among the dead!!!!!!1111!!!!!1!!!11111!!!!!!!!!!1!!!1!1!!!111111 (All of this I, I can't believe I couldn't see) (Kept in the dark, but you were there in front of me) I've been sleeping a thousand years, it seems... Got to open my eyes to everything (Without a thought) (Without a voice, without a soul) (Don't let me die here) (There must be something more) Bring me to life!!1 (Wake me up) Wake me up inside!!1 (I can't wake up) Wake me up inside!!1 (Save me) Call my name and save me from the darkness I've become!!1 (Wake me up) Bid my blood to run!!1 (I can't wake up) Before I come undone!!1 (Save me) Save me from the nothing I've become!!1 Bring me to life!!1 (I've been living a lie, there's nothing inside) Bring me to life!!!!!!!!!!!!!!!!!!!!!!!!!)");
		Searcher search = new Searcher();
		int wantedValue = getRand(0, 5000);
		System.out.println("Value to search for:    " + wantedValue + "\nSequential:");
		int found1 = search.sequential(wantedValue, qarray); //using the quicksorted array because why not
		System.out.println("Value found at " + found1 + "\nBinary:");
		int found2 = search.binary(wantedValue, qarray);
		System.out.println("Value found at " + found2);
	}
}
