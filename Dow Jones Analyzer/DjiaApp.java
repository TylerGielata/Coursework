// Nithun Harikrishnan
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class DjiaApp {

	public static void main(String[] args) {
		Scanner data = null;
		Scanner scnr = new Scanner (System.in);

		System.out.println("This program finds the   N lowest closing averages in a file of Dow Jones Industrial Average closing records. "); //explain program
		System.out.println("Stock file: "); //prompt for file
		System.out.println("Lowest N closing averages. N: "); //ask for N
		int N = scnr.nextInt();// read in and store N
		final MinPQ<Djia> pq = new MinPQ<Djia>(); 

		
		try {
			data = new Scanner(new File ("tinyDjia.txt"));
		}
		catch (IOException e) {
			System.out.println("Error: input file does not exist");
			System.exit(0); //program terminates
		}
		

			while (data.hasNext()) { // while there's more input to read
				String fileText = data.nextLine(); //fileText = the next line
				String[] fields = fileText.split("\\s* \\s*"); //split the line based on where the comma is
				String date = fields[0]; // put the first part of the split in element 0 of fields
				double closing = Double.parseDouble(fields[1]); // put the second part of the split in element 1 of fields
				Djia tmp = new Djia(date, closing); // new Djia object
				pq.insert(tmp); //insert the Djia object on the priority queue
			}
			data.close(); // close scanner to remove resource leak

		Djia min; // will hold the N minimum Djia objects for immediate printing
		for(int i = 0; i < N; i++) {
			if(!pq.isEmpty()) { // check that its not empty, and that we're not being asked to print more Djia's than the file holds.
			min = pq.deleteMin(); //put the lowest Djia into min
			System.out.println(min); //print min
			}
		}
	}
}
