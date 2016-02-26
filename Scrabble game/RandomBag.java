import java.util.*;

public class RandomBag<E> implements Iterable<E>
{
  // instance variables
  private List<E> bag; 		// array list as the container
  private Random rand;      // random number generator

  // constructors
  public RandomBag() { 
	    bag = new ArrayList<E>();
	    rand = new Random();
	    }
  
  public RandomBag(int seed) { 
      bag = new ArrayList<E>();
      rand = new Random(seed);  
  		}
  
  //instance methods
  public int size(){ 	//return size of bag
	  return bag.size();
		}
  
  public boolean isEmpty(){
		if (bag.isEmpty() == true) //check if bag is empty
			return true;
		else 
			return false;
  		}
 
  public void add(E element){
	  	bag.add(element);   // add new element to bag
  		}
  
  public E randomPick(){
	  	int k = rand.nextInt(bag.size()); //random pick limited by bag size
	  	E popElement = bag.remove(k);
	  	return popElement;
  		}
 
  public Iterator<E> iterator(){
	  Iterator<E> it = bag.iterator(); //creates iterator
	  return it;  
  }
  //**
  //** main() for testing RandomBag<E>
  //**
  public static void main(String[] args)
  {
    RandomBag<Integer> rbag = new RandomBag<Integer>(17);
    for (int i = 0; i < 8; ++i)
      rbag.add(10+i);

    for (Integer ival : rbag)
      System.out.println(ival);
    System.out.println();

    System.out.println("Random pick: " + rbag.randomPick());
    System.out.println("Random pick: " + rbag.randomPick());
    System.out.println("Random pick: " + rbag.randomPick());

    System.out.println();
    for (Integer ival : rbag)
      System.out.println(ival);
    System.out.println();

  }
}
