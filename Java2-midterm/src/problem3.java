//**********************************************************************
// Java2 Midterm - Problem3
//  
// Write a void method selectionSortDescendTrace() that takes an integer
//   array, and sorts the array into descending order. The method should
//   use nested loops and output the array after each iteration of the
//   outer loop, thus outputting the array N-1 times (where N is the size).
//   Complete main() to read in a list of up to 10 positive integers (ending
//   in -1) and then call the selectionSortDescendTrace() method.
// 
// Created By: Mike Gilson
// Date: 5/22/2020
//**********************************************************************

// Needed import for test displaying of array contents
//   import java.util.Arrays;

import java.util.Scanner;

public class problem3 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int i = 0;  // to iterate through number array for int placement
		int numElements = 0; // to be passed to sort method
		int [] numbers = new int[10]; // initialize array up to 10 integers
		
// Instructions for user to use Scanner object as desired
		System.out.println("Enter integers to sort, separated by a space. -1 to exit");
		int input = console.nextInt();

// While loop to continually take next integer, unless a -1 is entered.
// Also iterates i for placement into array, and updates numElements to
//   match number of entries.
		while (input != -1) {
			numbers[i] = input;
			i++;
			numElements = i;
			input = console.nextInt();
		}
// If statement used for testing. See full array's initial state, including
//   all remaining elements that were default initialized to 0.
		//if (input == -1) {
		//		System.out.println("Original array" + Arrays.toString(numbers));
		//}
		
		console.close();
				
// Run selectionSortDescendTrace, with array and number of elements parameters
		selectionSortDescendTrace(numbers, numElements);
		
// Test line to show full array, post sorting.
		//System.out.println("Sorted array:" + Arrays.toString(numbers));
		
	} //end main

// Swap method from original SelectionSort:
//   Swaps a[i] with a[j].
    public static void swap(int[] a, int i, int j) {
        if (i != j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        } //end if
    } //end swap method
      
// For loop to go through given array, starting at the first index, and goes
//   from beginning to end for the number of elements indicated by the provided
//   numElements parameter. Each time through, the outer loop will have "i"
//   be declared as largest, and the inner for loop will also iterate from the
//   beginning to the end of the array, starting with an index one more than
//   the outer for loop position.

// If statement checks if the inner for loop's current index is larger than "largest".
//   If so, sets largest to that index.
    public static void selectionSortDescendTrace(int [] a, int numElements) {
    	
// If there is only 1 element, it will save time by simply printing it.
    	if (numElements == 1) {
        	System.out.println(a[0]);
// 
        } else {
        for (int i = 0; i < numElements -1; i++) {
        	
            int largest = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[largest]) {
                    largest = j;
                } //end if 
            } //end outer for loop
            
// Outer for loop will then run the swap method to swap the i index with current
//   index of largest.
            swap(a, i, largest);
            
// for loop to print each iteration through the sort process, but just for the 
//   numElements entered (ignoring the default 0s).
            for (int x = 0; x < numElements; x++) {
            	System.out.print(a[x] + " ");
            }
            System.out.println();
            
        } // end outer for loop
    } // end else
    } // end Trace method
	
	
} //end class
