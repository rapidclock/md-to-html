package edu.neu.ccs.cs5004.seattle.assignment9.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class HorizontalLineElementTest {


  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testIsHorizontalLineElement() {
    Assert.assertTrue(HorizontalLineElement.isHorizontalLine("******  "));
    Assert.assertTrue(HorizontalLineElement.isHorizontalLine("****** "));
    Assert.assertFalse(HorizontalLineElement.isHorizontalLine("**           "));
  }

}
