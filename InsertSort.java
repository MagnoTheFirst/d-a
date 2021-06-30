

public class InsertSort 
{
	/**
	 * Quelle: https://www.geeksforgeeks.org/insertion-sort/
	 * Sortiert ein Array durch Einfügen
	 * @param array Das zu sortierende Array.
	 */
	public static void sort(int[] array)
	{
		int n = array.length;
		
		for(int i = 1; i < n; i++) 
		{
			int value = array[i];
			
			int j = i -1;
			while(j >= 0 && array[j] > value) 
			{
				array[j+1] = array[j];
				j = j-1;
			}
			array[j+1] = value;
		}
	}
	
	/**
	 * Sortiert einen durch zwei Grenzen angebenen Teil eines Arrays durch Einfügen.
	 * Arrayelemente ausserhalb der Grenzen werden nicht verschoben.
	 * @param array 
	 * @param start Index des ersten  Elementes des Teils, das Sortiert werden muss.
	 * @param end   Index des letzten Elementes des Teils, das sortiert werden muss.
	 */
	public static void sort(int[] array, int start, int end)
	{	
		int counter = start+1;
		for(int i = counter; i < end; i++)
		{
			int value = array[i];	
			int j = i-1;
			while(j >= 0 && array[j] > value) 
			{
				array[j+1] = array[j];
				j = j-1;
			}
			array[j-1] = value;
		}
		
	}
	
	

	public static void printArrayValues(int[] array) 
	{
		for(int i=0; i < array.length; i++) 
		{
			System.out.print(array[i]+ "," + " ");
		}
	}
	
	public static void main(String[] args) 
	{
		int[] array = {1,3,4,6,10,5, 90, 30, 40, 20, 12, 13};
		printArrayValues(array);
		sort(array, 3, 10);
		System.out.println("------------------------------------");
		printArrayValues(array);
	}

}


