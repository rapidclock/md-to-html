package edu.neu.ccs.cs5004.seattle.assignment9.utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.seattle.assignment9.utils.ImpedList;


public class ImpedListTest {

  ImpedList<Integer> iList1;
  ImpedList<Integer> iList2;

  @Before
  public void setUp() throws Exception {
    this.iList1 = new ImpedList<>();
    this.iList1.add(10);
    this.iList1.add(20);
    this.iList1.add(30);
    this.iList2 = new ImpedList<>();
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGet() {
    Assert.assertEquals(new Integer(10), this.iList1.get(1));
    Assert.assertEquals(new Integer(30), this.iList1.get(this.iList1.size()));
    Assert.assertNull(this.iList1.get(this.iList1.size() + 1));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetException() throws IndexOutOfBoundsException {
    this.iList1.get(0);
  }

  @Test
  public void testGetLast() {
    Assert.assertNull(this.iList2.getLast());
    Assert.assertEquals(new Integer(30), this.iList1.getLast());
  }
}
