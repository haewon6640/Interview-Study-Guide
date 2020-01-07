import java.util.Arrays;
public class Sorts
{
    public static void main(String[] args)
    {
    	int[] arr = {64,25,12,22,11};
    	// SelectionSort(arr);
    	// BubbleSort(arr);
    	InsertionSort(arr);
    	System.out.println(Arrays.toString(arr));
    }
    /* The selection sort algorithm sorts an array by repeatedly 
    *	finding the minimum element (considering ascending order)
    *	from unsorted part and putting it at the beginning. 
    *	The algorithm maintains two subarrays in a given array.
	*	1) The subarray which is already sorted.
	*	2) Remaining subarray which is unsorted.
	*
	*	In every iteration of selection sort, the minimum element (considering ascending order) 
	*	from the unsorted subarray is picked and moved to the sorted subarray.
    */
    public static void SelectionSort(int[] arr)
    {	
    	for (int j = 0; j < arr.length; j++) {
    		int currMinIndex = j;
    		// Finds the actual minimum for the unsorted subarray arr[j:]
	    	for (int i = j; i < arr.length; i++) {
	    		if (arr[i] < arr[currMinIndex]) {
	    			currMinIndex = i;
	    		}
	    	}
	    	// The minimum is swapped with the original.
	    	int temp = arr[j];
	    	arr[j] = arr[currMinIndex];
	    	arr[currMinIndex] = temp;
    	}
    }

   	// a: first index, b: second index 
    public static void swap(int[] arr, int a, int b) {
    	int temp = arr[a];
    	arr[a] = arr[b];
    	arr[b] = temp;
    }

    // N(N-1)/2 swaps = O (N^2)
    // Optimize by boolean swap = false that will change
    public static void BubbleSort(int[] arr) {
    	int n = arr.length;
    	// Only consider arr[0..n-i-1] because last element is always at the right place after each iteration
    	for (int i = 0; i < n-1; i++) {
    		// swap greater element continuosly
    		for (int j = 0; j < n-i-1; j++) {
    			if (arr[j] > arr[j+1]) {
    				swap(arr,j,j+1);
    			}
    		}
    	}
    }
    // Picks an element from unsorted array and places it onto the correct spot in the sorted array.
    public static void InsertionSort(int[] arr) {
    	for (int i = 0; i < arr.length; i++) {
    		for (int j = i; j < arr.length; j++) {
    			if (arr[j] < arr[i]) {
    				swap(arr, i,j);
    			}
    		}
    	}
    }
}