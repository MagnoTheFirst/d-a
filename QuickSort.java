

public class QuickSort 
{
	
	/**
	 * Sortiert ein Array durch Quicksort.
	 * @param array Zu sortierendes Array.
	 * Quelle https://www.geeksforgeeks.org/quick-sort/
	 */
	public static void sort(int[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	/**
	 * Sortiert ein Teilstück eines Arrays durch Quicksort.
	 * @param array ZU sortierenden Array
	 * @param start Index des ersten Elementes des Teils, das sortiert werden muss.
	 * @param end   Index des letzen Elementes des Teils, das sortiert werden muss.
	 */
	public static void sort(int[] array, int start, int end)
	{
		if(start < end) 
		{
			int pi = partition(array, start, end, array[end]);
			//Recursiv sort elements befort
			//partition and after partition
			sort(array, start, pi-1);
			sort(array, pi+1, end);
		}
	}
	
	/** 
	 * Schwellwert, bei welcher Arraygrösse in der Rekursion InsertSort 
	 * statt Quicksort aufgerufen werden sollte. 
	 */
	static int THRESHOLD = 4; // TODO finden Sie einen sinnvollen Wert
	
	/**
	 * Modifiziertes Quicksorts.
	 * Wenn die Grösse des zu sortierenden Arrays in der Rekursion 
	 * einen Schwellwert unterschreitet, wird InsertSort statt Quicksort 
	 * aufgerufen.
	 * @param array Zu sortierendes Array
	 */
	public static void sortPlus(int[] array)
	{
		if(THRESHOLD > array.length) 
		{
			InsertSort.sort(array);
		}
		else 
		{
			sortPlus(array, array[0], array.length - 1);
		}

	}

	/**
	 * Modifiziertes Quicksorts zum SOrtieren eines Teilstücks eines Arrays.
	 * Wenn die Grösse des zu sortierenden Arrays in der Rekursion 
	 * einen Schwellwert unterschreitet, wird InsertSort statt Quicksort 
	 * aufgerufen.
	 * @param array Zu sortierendes Array
	 * @param start Index des ersten  Elementes des zu sortierenden teilstücks.
	 * @param end   Index des letzten Elementes des zu sortierenden teilstücks.
	 */
	public static void sortPlus(int[] array, int start, int end)
	{
		if(THRESHOLD > array.length) 
		{
			InsertSort.sort(array);
		}
		else 
		{
			sort(array);
		}
	}

	/**
	 * Hilfsmethode für Quicksort. 
	 * Ein Teilstück eines Arrays wird geteilt, so dass alle Elemente,
	 * die kleiner als ein gewisses Pivot-Elements sind, links stehen
	 * und alle Elemente, die grösser als das Pivot-Element rechts stehen.
	 * @param array Array zum Umordnen.
	 * @param start Indes des ersten  Elements des Teilstücks, das geteilt werden muss.
	 * @param end   Index des letztes Elements des Teilstücks, das geteilt werden muss.
	 * @param piv   Index des PiotElements
	 * @return Index des Piot-Element nach der Partitionierung.
	 * 
	 * 
	 * This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted array, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot
	 */
	static int partition(int[] array, int start, int end, int piv) // piv sollte array[end] sein
	{
		int i = (start -1);
		for(int j = start; j<end; j++) 
		{
			//If the current element is smaller than piv
			if(array[j] < piv) 
			{
				i++;
				swap(array, i, j);
			}
		}
		
		swap(array, i+1, end);
		//swap arra[i+1] and arra[end] or pivot
		return i+1;
	}
	
	/**
	 * Hilfsmethode zum Vertauschen zweier Array-Elemente
	 * @param array
	 * @param a
	 * @param b
	 */
	static void swap(int[] array, int a, int b)
	{
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	
	/**
	 * Hilfsmethode zum Finden eines Pivot-Elementes für Quicksort.
	 * Zu einem Array und den zwei Indices start und end wird 
	 * der Index eines möglichen Pivot-Elementes angegeben 
	 * @param array
	 * @param start
	 * @param end
	 * @return Index eines Pivot-Elementes
	 * 
	 * Das Pivot Element wird immer in der Mitte des angegebenen Arrayteils returnt
	 * rechte Seite 
	 * *****start = (array.length-1)/2 
	 * *****Ende = end
	 * linke Seite 
	 * *****start = array[0]
	 * *****Ende =  (array.length-1)/2  
	 * 
	 * Pivot = Ende /2 
	 *  
	 */
	static int findPivot(int[] array, int start, int end)
	{
		int pivot = end / 2;
		return pivot;
	}
}
