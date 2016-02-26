/*
 * Title: tinyScrGame.java
 * Description: Tiny scrabble game  
 * Author: Nithun Harikrishnan
 * Version: 1.0
 * Usage: >javac tinyScrGame.java >java tinyScrGame
 */
 
import java.io.*;
import java.util.*;

public class tinyScrGame 
{
  // instance variables
  private Set<String> dictionary;   // Scrabble dictionary as a set of Strings
  private RandomBag<LTile> tilebag; // Scrabble tiles in a random bag
  private int nletter;              // n-letter words

  // instance methods
  public tinyScrGame(String fname, int n, int sd) {
    nletter = n;

    // (1) load the dictionary
    dictionary = new HashSet<String>();
    Scanner data = null;
    try {
      data = new Scanner(new File(fname));
    }
    catch (IOException e) {
      System.out.println("ERROR: file opening error for " + fname);
      e.printStackTrace();
      System.exit(0); // terminate the program
    }

    String s;
    while (data.hasNext()) {
      s = data.next(); // read in a/one next string
      if (s.length() == nletter)
        dictionary.add(s.toUpperCase());
    }
    System.out.println("# of " + nletter + "-letter words in the dictionary: "
        + dictionary.size() + "\n======================================\n");
    
  /*  System.out.println("Words in the dictionary");
    for (String dic : dictionary)
      System.out.println(dic);*/

    //(2) load the tilebag
    tilebag = new RandomBag<LTile>(sd); //create an instance of RandomBag called tilebag which contains instances of class Ltile 
    /*
    2 blank tiles (scoring 0 points)
    1 point: E ×12, A ×9, I ×9, O ×8, N ×6, R ×6, T ×6, L ×4, S ×4, U ×4
    2 points: D ×4, G ×3
    3 points: B ×2, C ×2, M ×2, P ×2
    4 points: F ×2, H ×2, V ×2, W ×2, Y ×2
    5 points: K ×1
    8 points: J ×1, X ×1
    10 points: Q ×1, Z ×1
    */
    final String letters = " EAIONRTLSUDGBCMPFHVWYKJXQZ";
    final int[] numbers  = {2,12,9,9,8,6,6,6,4,4,4,4,3,2,2,2,2,2,2,2,2,2,1,1,1,1,1};
    final int[] values  =  {0, 1,1,1,1,1,1,1,1,1,1,2,2,3,3,3,3,4,4,4,4,4,5,8,8,10,10};
    final int len = letters.length();
    int num;
    for (int i = 0; i < len; ++i) {
      for (int j = 0; j < numbers[i]; ++j) { // number of tiles
        tilebag.add(new LTile(letters.charAt(i), values[i]));
      }
    }
   
//    System.out.println("===== Tiles ==========");
//    for (LTile et : tilebag)
//      System.out.println(et.getLetter());
    
  }

  public void play(int k) {
	  int round = 1;
	  int myTotal = 0;
	  for (int i=0; i < k ; i++){  
		  String wordPickString = "";
		  for (int j = 0; j < nletter; j++){
			  String rp = Character.toString(tilebag.randomPick().getLetter()) ; //returns random chars from bag
			  wordPickString += rp;   //string builder
		  } 
//		  for (int z = 0; i < wordPickString.length(); ++z) {
//				 for (LTile et : tilebag){
//				        if(wordPickString.charAt(z) == et.getLetter());
//				        myTotal = et.getLetterValue();
//				        System.out.println(myTotal);
//				        break;
//				 }
//		      
//		  }        
          System.out.println("Round "+round+" => "+wordPickString+" - score: "); //print round details
          round++;
          
		  ArrayList<String> permuteString;
		  permuteString = permute(wordPickString);  // permute string
		  
		  for (String n : permuteString)
			  for (String d : dictionary)
				  if (n.equalsIgnoreCase(d))   // checks equality
				  	System.out.println(" - FOUND == "+d);
	  }  
  }

//========================================================================
// PERMUTE and PERMUTATION
//  -- permutation is taken from a solution posted at StacckOverflow,
//  http://stackoverflow.com/questions/4240080/generating-all-permutations-of-a-given-string
//========================================================================
  public static ArrayList<String> permute(String s)
  {
    HashSet<String> hs = new HashSet<String>();
    ArrayList<String> ret = new ArrayList<String>();
    for (String p : permutation(s)) {
      if (!hs.contains(p)) {
        hs.add(p);
        ret.add(p);
      }
    }

    return ret;
  }

/**
 * List permutation of a string
 *
 * @param s the input string
 * @return  the list of permutation
 */
public static ArrayList<String> permutation(String s) {
    // The result
    ArrayList<String> res = new ArrayList<String>();
    // If input string's length is 1, return {s}
    if (s.length() == 1) {
        res.add(s);
    } else if (s.length() > 1) {
        int lastIndex = s.length() - 1;
        // Find out the last character
        String last = s.substring(lastIndex);
        // Rest of the string
        String rest = s.substring(0, lastIndex);
        // Perform permutation on the rest string and
        // merge with the last character
        res = merge(permutation(rest), last);
    }
    return res;
}

/**
 * @param list a result of permutation, e.g. {"ab", "ba"}
 * @param c    the last character
 * @return     a merged new list, e.g. {"cab", "acb" ... }
 */
public static ArrayList<String> merge(ArrayList<String> list, String c) {
    ArrayList<String> res = new ArrayList<String>();
    // Loop through all the string in the list
    for (String s : list) {
        // For each string, insert the last character to all possible postions
        // and add them to the new list
        for (int i = 0; i <= s.length(); ++i) {
            String ps = new StringBuffer(s).insert(i, c).toString();
            res.add(ps);
        }
    }
    return res;
}
//========================================================================

  //**
  //** main() for some real games
  //**

  public static void main(String[] args) {
    tinyScrGame g1 = new tinyScrGame("scrabble-ospd.txt", 4, 5);
    g1.play(10);

  }

} // end class

/* Output of the program

# of 4-letter words in the dictionary: 3857
======================================

Round 1 => H EL - score: 6
Round 2 => NKSE - score: 8
 - FOUND == KENS
Round 3 => LUCZ - score: 15
Round 4 => TIEO - score: 4
Round 5 => ONAJ - score: 11
Round 6 => PIWI - score: 9
Round 7 => ADIC - score: 7
 - FOUND == CAID
 - FOUND == ACID
 - FOUND == CADI
Round 8 => ETAM - score: 6
 - FOUND == MATE
 - FOUND == TAME
 - FOUND == TEAM
 - FOUND == MEAT
 - FOUND == META
Round 9 => ARTG - score: 5
 - FOUND == GRAT
Round 10 => IMLA - score: 6
 - FOUND == MAIL
 - FOUND == LIMA

** Average word score = 7.70

*/
