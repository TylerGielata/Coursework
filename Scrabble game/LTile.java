public class LTile {
	// instance member
	private char letter;
	private int letterValue;
	private int id;

	
	// class/static variable, stored by the class and not the instance of a class.
	private static int idMain = 0;
	
	// public instance method/function (constructor)
	public LTile(char n, int a){
		this.letter = n;
		this.letterValue = a;
		this.id = idMain;
		idMain++;

	}
	
	public LTile(){  //default constructor
		//this.letter = "?"; // empty string
		this.letterValue = 0;
		this.id = idMain;
		idMain++;

	}
	
	// get methods
	public char getLetter(){ return this.letter;}
	public int getLetterValue(){ return this.letterValue;}
	public int getID(){ return this.id;}

	//toString override
	public String toString(){
		String ret;
		ret = "["+ this.id +":"+ this.letter +","+ this.letterValue + "]";
		return ret;
	}
	
	//equals override
	public boolean equals(Object obj){
		if (obj == null || obj.getClass() != this.getClass())
		      return false;
		    else {
		      // type-cast obj to LTile
		    	LTile tempTile = (LTile) obj;		    	
		      if (this.id == tempTile.id)
		        return true;
		      else
		        return false; 
		    }
	}
	
		//*
		//*Unit test code
		//*
	public static void main(String[] args)
	  {
	    final String letters = "EAIONRTLSUDGBCMPFHVWYKJXQZ";
	    final int[] values  =  {1,1,1,1,1,1,1,1,1,1,2,2,3,3,3,3,4,4,4,4,4,5,8,8,10,10};

	    java.util.List<LTile> lst = new java.util.ArrayList<LTile>();
	    for (int i = 0; i < letters.length(); ++i)
	      lst.add(new LTile(letters.charAt(i), values[i]));

	    for (LTile tile : lst)
	      System.out.println(tile);
	    System.out.println();

	    // test for equals
	    boolean found = false;
	    for (int i = 0; i < lst.size()-1; ++i) {
	      for (int j = i+1; j < lst.size(); ++j) {
	        if (lst.get(i).equals(lst.get(j))) {
	          System.out.println("ERROR in equals() found for "
	              + lst.get(i) + " and " + lst.get(j));
	          found = true;
	        }
	      }
	    }
	    if (!found)
	      System.out.println("No error in equals().");

	  }
}
