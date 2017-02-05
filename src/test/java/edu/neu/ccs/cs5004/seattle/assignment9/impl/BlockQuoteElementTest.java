package edu.neu.ccs.cs5004.seattle.assignment9.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BlockQuoteElementTest {

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testCalOrder() {
    Assert.assertEquals(new Integer(2), BlockQuoteElement.calcOrder("> > hello"));
    Assert.assertEquals(new Integer(3), BlockQuoteElement.calcOrder("> > > hello"));
  }

  @Test
  public void testIsBlockQuoteELement() {
    Assert.assertTrue(BlockQuoteElement.isBlockQuoteElement("> > hello"));
    Assert.assertFalse(BlockQuoteElement.isBlockQuoteElement(" hello"));
    Assert.assertTrue(BlockQuoteElement.isBlockQuoteElement("> hello"));
  }



}
