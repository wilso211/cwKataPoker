/**
 * The Sorter class handles all the sorting needs of the application.
 * It currently allows the sorting of the cards from lowest to highest
 * by their value.
 * 
 * @author Cecil Wilson
 *
 */
public class Sorter {
	
	Sorter()
	{
		
	}

	/**
	 * This method calls for the cards in a hand 
	 * to be sorted from lowest to highest by it's value
	 * 
	 * @param hand
	 * @return sorted cards in a hand by value
	 */
	public Card[] sortCardsByValue(Card[] hand)
	{
		
		int low = 0;
		int high = hand.length - 1;
		
		hand = this.quickSort(hand, low, high);
		return hand;
	}
	
	/**
	 * Implementation of a quicksort algorithm
	 * 
	 * @param arr	| the array to be sorted
	 * @param low	| lowest of the array
	 * @param high	| highest of the array
	 * @return the new sorted array
	 */
	public Card[] quickSort(Card[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return arr;
 
		if (low >= high)
			return arr;
 
		// pick a pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle].getIntValue();
 
		// make the left < pivot and the right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i].getIntValue() < pivot) {
				i++;
			}
 
			while (arr[j].getIntValue() > pivot) {
				j--;
			}
 
			if (i <= j) {
				Card temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// sort two parts recursively
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
		
		return arr;
	}
}
