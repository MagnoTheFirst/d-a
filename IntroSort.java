package ch.ffhs.dua.sort;
import static ch.ffhs.dua.sort.QuickSort.partition;
import java.util.Arrays;

public class IntroSort 
{
	/** Quellen: https://www.geeksforgeeks.org/introsort-or-introspective-sort/ 
	 * 
	 * Sortiert ein Array der Länge n mit IntroSort.
	 * Das Array wird mit Quicksort sortiert, 
	 * wenn aber die Rekursionstiefe mehr 
	 * als n * log(n) wird, wird auf HeapSort ungestellt.
	 * @param array
	 */
	public static void sort(int[] array)
	{
		int l = array.length;
		sort(array, 0, l - 1, 2 * l * log2(l));
	}
	
	/**
	 * Sortiert eine Teilstück eines Arrays mit IntroSort.
	 * @param array Zu sortierendes Array
	 * @param start Index des ersten Elementes des zu sortierenden Stücks.
	 * @param end   Index des letzten Elementes des zu sortierenden Stücks.
	 * @param maxDepth
	 */
	public static void sort(int[] array, int start, int end, int maxDepth)
	{
		if (start >= end) {
			return;
		}
		
		if (maxDepth == 0) {
			//System.out.println("heap sort used");
			HeapSort.sort(array, start, end);
			return;
		}
		
		int q = partition(array, start, end, array[end]);
		sort(array, start, q - 1, maxDepth -1);
		sort(array, q + 1, end, maxDepth -1);
		//System.out.println(Arrays.toString(array));
	}

	/**
	 * Bestimmt den (abgerundeten) Zweierlogarithmus ohne float-Arithmetik.
	 * @param n
	 * @return
	 */
	static int log2(int n)
	{
		int log = 0;
		while (n > 1)
		{
			n >>>= 1;
			log++;
		}
		return log;
	}
}
