/*
 * Title: RecPower.java
 * Description: Find the power of a number using a recursive function
 * Author: Nithun Harikrishnan
 * Version: 1.0
 * Usage: >javac RecPower.java >java RecPower
 */
package week2;
import java.util.Scanner;


public class RecPower {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		double x1;
		int n1;
		double ans;
		
		System.out.println("Enter value of x:");
		x1 = scnr.nextDouble();
		
		System.out.println("Enter value of n:");
		n1 = scnr.nextInt();

		ans = power(x1,n1); // calling power function
		System.out.printf("The value of x^n is: "+ ans);
		
		scnr.close();

	}
	public static double power(double x, int n){ 	// power function
		if (n == 0)
			return 1.0;
		else 
			return (power(x,n-1)*x); //recursive call
	}

}
