package src.ch.ffhs.dua.permutations;

import java.util.ArrayList;

public class Permutations 
{


	   private static ArrayList<int[]> permutations = new ArrayList<>();

	    /**
	     * Creates an arrayList with all permutations
	     * @param n number of values in the array.
	     * @return  An array of permutations each permutation is an array of integer
	     */
	    public static int[][] permutations(int n)
	    {
	        // Reset the list
	        permutations.clear();

	        int[] startArray = createArray(n);
	        if(startArray.length != 0) {
	        	createPermutationArray(n, startArray);
	        }
	        return permutations.toArray(new int[0][0]);
	    }

	    /**
	     * 
	     * @param n number of values in the array
	     * @return array of different values
	     */
	    private static int[] createArray(int n)
	    {
	        int[] buffer = new int[n];
	        for(int i = 0; i < n; i++)
	        {
	        	buffer[i] = i;
	        }
	        return buffer;
	    }

	    private static void createPermutationArray(int n, int[] array)
	    {

	        if(n == 1)
	        {
	            output(array);
	        } 
	        else 
	        {
	        	createPermutationArray(n-1, array);
	            for(int i = 0; i < n-1; i++)
	            {
	                if(n % 2 == 0) 
	                {
	                	changePosition(array,i, n-1);
	                } 
	                else 
	                {
	                	changePosition(array, 0, n-1);
	                }
	                createPermutationArray(n-1, array);
	            }
	        }

	    }

	    /**
	     * This method will change the position of to values in an array
	     */
	    private static void changePosition(int[] array, int a, int b) 
	    {
	        int buffer = array[a];
	        array[a] = array[b];
	        array[b] = buffer;
	    }

	    private static void output(int[] array)
	    {
	        permutations.add(copyArray(array));
	    }

	    /**
	     * 
	     * This method creates an new array 
	     */
	    private static int[] copyArray(int[] array)
	    {
	        int [] buffer = new int[array.length];
	        for(int i = 0; i < array.length; i++)
	        {
	            buffer[i] = array[i];
	        }
	        return buffer;
	    }
}

