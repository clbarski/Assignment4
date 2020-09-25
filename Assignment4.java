import java.util.*;

public class Assignment4
{

	//Function mergeKlists to merge the multidimensional array
	public static double [] mergekLists(double [] [] outerArr)
	{
		//To check if the array is empty or null
		if(outerArr == null || outerArr.length == 0 || outerArr[0].length == 0)
		{
			//Returns an empty array if true
			return new double[] {};
		}

		int count = 0;
		//Nested for loop to find how big to make the return array
		for(int i = 0; i<outerArr.length; i++)
		{
			for(int j = 0; j<outerArr[i].length; j++)
			{
				count+=1;
			}
		}

		double[] arr = new double[count];

		count = 0;
		//Takes the values from the multidimensional array and puts them into the new array arr
		for(int i = 0; i<outerArr.length; i++)
		{
			for(int j = 0; j<outerArr[i].length; j++)
			{
				arr[count++] = outerArr[i][j];
			}
		}

		//Calls merge sort to sort the array
		mergeSort(arr);
		//Returns the new array arr
		return arr;

	}

	//Function to get left array
	public static double [] get_left(double [] arr)
	{
		//Divide the array by 2
		int size = arr.length/2;
		//Create a new array left to return
		double[] left = new double[size];
		//Iterate through index 0 and the middle of the array
		for(int i = 0; i<size;i++)
		{
			//Add that element to the left array
			left[i] = arr[i];
		}
		//Return the left array
		return left;
	}

	//Function to get right array
	public static double [] get_right(double [] arr)
	{
		//Divide the array by 2
		int size = (arr.length/2);
		int arrSize = size;
		//Create a new array right to return
		double[] right = new double[size];
		//Iterate through the mid point and the last element in the array
		for(int i = 0; i<size; i++)
		{
			//Add that element to the array right
			right[i] = arr[arrSize];
			arrSize+=1;
		}
		//Return the right attay
		return right;
	}

	//Fuction to merge the arrays left and right together
	public static void mergeSort(double[] arr)
	{
		if(arr.length > 1)
		{
			double [] left = get_left(arr);
			double [] right = get_right(arr);

			mergeSort(left);
			mergeSort(right);
			merge(arr, left, right);
		}
	}

	//Fuction to compare left and right values adn merge together
	public static void merge(double[] arr, double[] left, double[] right)
	{
		int l = 0, r = 0, i = 0;

		//Iterate through left and right arrays until one reaches the end
		while(l < left.length && r < right.length)
		{
			//Compare the values, and add the correct value
			if(left[l] < right[r])
			{
				arr[i] = left[l++];
			}
			else
			{
				arr[i] = right[r++];
			}
			++i;
		}

		//two while loops to add the remaining values from the array that did not finish
		//In the previous while loop
		while(l < left.length)
		{
			arr[i++] = left[l++];
		}

		while(r < right.length)
		{
			arr[i++] = right[r++];
		}
	}

	//Main function to run the program
	public static void main(String[] args)
	{
		double[][] outerArr = {{}};

		double[] arr = mergekLists(outerArr);

		System.out.print("The array sorted: ");
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}

	}

	

}