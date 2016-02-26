import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;

public class MinPQTest {
  private MinPQ<Integer> pq;

  @Before
  public void setup()
  {
    pq = new MinPQ<Integer>();
  }

  @Test
  public void test1() {
    assertEquals(0, pq.size());
    assertEquals(true, pq.isEmpty());
  }

  @Test(expected=NoSuchElementException.class)
  public void test2()
  {
    pq.min();
  }

  @Test(expected=NoSuchElementException.class)
  public void test3()
  {
    pq.deleteMin();
  }

  @Test
  public void test4()
  {
    pq.insert(5);
    assertEquals(1, pq.size());
    assertEquals(false, pq.isEmpty());
    assertEquals(5, (int) pq.min());
  }

  @Test
  public void test5()
  {
    pq.insert(5);
    int x = pq.deleteMin();
    assertEquals(5, x);
    assertEquals(0, pq.size());
    assertEquals(true, pq.isEmpty());
  }

  @Test
  public void test6()
  {
    pq.insert(5);
    pq.insert(6);
    pq.insert(3);
    pq.insert(4);
    assertEquals(4, pq.size());
    assertEquals(3, (int) pq.min());
    pq.deleteMin();
    assertEquals(3, pq.size());
    assertEquals(4, (int) pq.min());
    pq.deleteMin();
    assertEquals(2, pq.size());
    assertEquals(5, (int) pq.min());
    pq.deleteMin();
    assertEquals(1, pq.size());
    assertEquals(6, (int) pq.min());
    assertEquals(6, (int) pq.deleteMin());
    assertEquals(0, pq.size());
    assertEquals(true, pq.isEmpty());

  }

}
