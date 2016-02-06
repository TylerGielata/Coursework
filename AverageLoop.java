/*
 * Title: AverageLoop.java
 * Description: Simple program to calculate average using a for loop 
 * Author: Nithun Harikrishnan
 * Version: 1.0
 * Usage: >javac AverageLoop.java >java AverageLoop
 */

package week1;
import java.util.Scanner;

public class AverageLoop {
	public static void main(String[] args){
		// Declare vars
		double average;
		int value, times;
		int total = 0;
		Scanner in = new Scanner(System.in);
		
		
		// Ask the user how many numbers
		System.out.print("How many numbers are you going to enter");
		times = in.nextInt(); // receive int value
		
		// loop times "times", and  accumulate into total
		for (int i = 0; i < times; i++){
			System.out.print("Enter an integer:");
			value = in.nextInt();
			
			// add total
			total = total + value;
		}
		
		//calculate average
		average = (double) total / times; // double has been typecasted at this instance
		System.out.print("Average is "+  average);
		in.close();
		
	}
	
	
}
