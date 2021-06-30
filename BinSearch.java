
public class BinSearch {

/**

 * Findet für einen aufsteigend geordneten Array zu einer Zahl value

 * den kleinsten und den grössten Index.

 * @param array
 * @param value

 * @return Ein Paar mit kleinestem und grösstem Index oder
 * null, wenn der gegebene Wert im array nicht vorkommt.
 */
	
	

public static Pair search(int[] array, int value)
{
	
		int index = binSearch(array, value, 0, array.length -1);

			if (index == - 1)
			{

				return null;

			}
		
		int min = getMin(array, 0, array.length -1, value);

				int max = getMax(array, min, array.length - 1, value);

				return new Pair(min, max);
		
	}

	
	private static int getMax(int[] array, int min, int max, int value)
		{
	
		int index = binSearch(array, value, min, max);

		if (index == -1) 
		{
			
			return min - 1;

		} 
		else 
		{

			return getMax(array, index + 1, max, value);

		}

	}


	private static int getMin(int[] array, int min, int max, int value) {

		int index = binSearch(array, value, min, max);

		if (index == -1) {

			return max + 1;

		}
		else 	
		{

			return getMin(array, min, index - 1, value);

		}

	}


	public static int binSearch(int[] array, int value, int min, int max) {

		int location = -1;  // if value not found

		if (min <= max && max <= (array.length - 1)) 
		{

			int middle = min + (max - min)/2;

			if(value == array[middle]) 
			{

				location = middle;

				return location;

			}
		else if(value < array[middle]) 
		{

			location = binSearch(array, value, min, middle -1);

			return location;

		}
		else 
		{

				location = binSearch(array, value, middle + 1, max);

				return location;
			}

		}

		return location;

		}

	
	public static void main(String [] args) {

		int [] array = {0,10,20,30,40};

		Pair result = search(array, 10);

		
		if(result != null) 
		{

			System.out.println("Pair with the lowest and the highest index : " + result.toString());

		}
		else 
		{

			System.out.println("Your Array is empty");

		}

	}
}
