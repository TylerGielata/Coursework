/*
 * Title: Inflation.java
 * Description: Program to calculate inflation 
 * Author: Nithun Harikrishnan
 * Version: 1.0
 * Usage: >javac Inflation.java >java Inflation
 */
package week1;

import java.util.Scanner;

public class Inflation {

	public static void main(String[] args) {
		
		// Declare variables
		Scanner scnr = new Scanner (System.in);
		double cost, rate, orgnlcost;
		int years;
		
		// User Input prompt
		System.out.print("Enter the cost, number of years and inflation rate: ");
		cost = scnr.nextDouble();
		years = scnr.nextInt();
		rate = scnr.nextDouble();
		
		orgnlcost = cost; //retains original cost
			
		System.out.printf("Year "+ 0 + " ==> $ %.2f%n", cost); // Prints amount for 0th year
		
		for (int i = 1; i <= years; i++){
	        
			double amount = cost + (cost*(rate/100)); // Calculates amount to be paid
	        
			if (i < years) {   // Prints amount for remaining years
				System.out.printf("Year "+ i + " ==> $ %.2f %n", amount );
			}
			else  {             // Prints amount for final year (i == years)
				System.out.printf("\r\n" + "==== Final Result ==="+ "\r\n");
				System.out.printf("This item of $"+ orgnlcost + " will cost $%.2f", amount );
				System.out.printf(" after " + i +" years");
			}
			cost = amount;
		}
		
		scnr.close();
	}

}
