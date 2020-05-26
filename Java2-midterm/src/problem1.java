//**********************************************************************
// Java2 Midterm - Problem2
//  
// Write a program that lists all ways people can line up for a photo
//   (all permutations of a list of Strings). The program will read a
//   list of one word names (until -1), and use a recursive method to
//   create and output all possible orderings of those names, one ordering
//   per line.
// When the input is:
// 		Julia Lucas Mia -1
// Then the output is (must match the below ordering):
//   	Julia Lucas Mia 
//		Julia Mia Lucas
//		Lucas Julia Mia
//		Lucas Mia Julia
//		Mia Julia Lucas
//		Mia Lucas Julia
// 
// Created By: Mike Gilson
// Date: 5/22/2020
//**********************************************************************
import java.util.Scanner;
import java.util.ArrayList;

//Imports used for various experiments(see notes at bottom)
 //import java.util.Arrays;
 //import java.awt.List;
 //import java.util.Collections;

public class problem1 {

	public static void main(String[] args) {
		
	Scanner console = new Scanner(System.in);
	ArrayList<String> nameList = new ArrayList<String>();
	ArrayList<String> permList = new ArrayList<String>();
	
// While loop to take all Strings entered and add to nameList until -1 entered.
	System.out.println("Enter names, separated by a space. -1 to exit");
	String name = console.next();
	while (!name.equals("-1")) {
		nameList.add(name);
		name = console.next();
	} // end while	
		
	console.close();
	
	allPermutations(permList, nameList);
	} // end main
	
	
// Created shortcut method to iterate through ArrayList and display
//   elements without brackets and commas.
//     **thought it would be used more, but I kept it around, anyway.
	public static void display(ArrayList<String> displayList) {
		for (String names : displayList) {
			System.out.print(names + " ");
		}
		System.out.println();
	}

// allPermutations method, with two ArrayLists as parameters
	public static void allPermutations(ArrayList<String> permList, ArrayList<String> nameList) {
		
// Base case - when there are no more elements in nameList, printout
//    permList, using the display method.
		  if (nameList.size() == 0) {
			  display(permList);

// Recursive part - for loop to go through each element in nameList. For
//   each iteration, will take i from nameList and add it to the temp
//   ArrayList newPerms. and remove i from the temp ArrayList newNames,
//   which is a copy of nameList. These temp ArrayLists are then recursively  
//	 put into allPermutations. This continues to move the i element from
//   nameList to permList until the for loop is completed, displaying permList.
// It then will backtrace through the stack to complete the other iterations
//   of the initial i value, and then proceed to the next value of i.  This will
//   result in index of 1 being put into permList first.
// The same process will then occur for for index 2 being put into permList
//   first, and recursion and backtracing will display the final permList
//   permutation, thus completing all stacks and ending the program.
		  } else {
			  for (int i = 0; i < nameList.size(); i++) {
			  ArrayList<String> newPerms = new ArrayList<String>(permList); 
			  newPerms.add(nameList.get(i));
			  ArrayList<String> newNames = new ArrayList<String>(nameList);
// I added these lines to help trace the recursive flow of ArrayList element placement 
			  //System.out.print("perm:"); display(permList);
			  //System.out.print("name:"); display(nameList);
			  newNames.remove(i);
			  allPermutations(newPerms, newNames);
			  } //end for
		  } // end else
	
	} // end allPermutations
} // end class


//*******************************************************
//************** NOTES AND FAILED ATTEMPTS **************
//*******************************************************

//-------------------------------------------------------
// Another attempt that dead-ended, basing on a different
//   base case that didn't remove items from nameList.
//   Couldn't get it to not error out, unfortunately.
//-------------------------------------------------------
		/*
		 * int start = 0;
		 * if (start == nameList.size()-1) { 
		 * 		display(permList);
		 * } else {
		 * 		for (int i = start; i < nameList.size(); i++) {
		 * 			permList = new ArrayList<String>(nameList);
		 * 			String target = permList.get(i);
		 * 			permList.remove(target);
		 * 			permList.add(0, target);
		 * 			start++;
		 * 			allPermutations(permList, nameList);
		 * 		}
		 * }
		 */

//-------------------------------------------------------
// *****Attempt to duplicate slide46 from Ch12*****
// ArrayLists don't concatenate like strings and chars do, 
//    so I wasn't able to get a successful reproduction.
//-------------------------------------------------------
//			ArrayList<String> ch = new ArrayList<>(nameList.subList(i, i+1));
//			ArrayList<String> rest = new ArrayList<>(nameList.subList(0, i));
//			ArrayList<String> add = new ArrayList<>(nameList.subList(i+1, nameList.size()));
//			add.addAll(rest);
//			ch.addAll(permList);
//			allPermutations(rest, permList);

//---------------------------------------------------
//  Solved the problem without recursion, in an attempt to
//  understand the problem
//---------------------------------------------------
//			for (int i = 0; i < nameList.size(); i++) {
//			  
//				permList = new ArrayList<String>(nameList);
//				String target = permList.get(i);
//				permList.remove(target);
//				permList.add(0, target);
//
//				display(permList);
//				Collections.swap(permList, 1, 2);
//				display(permList);
//				}

		
//---------------------------------------------------
		//for loop to go through index of arrayList
		//permList = nameList
		//print permList	  	// 0 1 2
		//swap 1 2
		//print "new" 0, 1, 2 	// 0 2 1
		
		
		


