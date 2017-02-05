package edu.neu.ccs.cs5004.seattle.assignment9.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author RT
 */
public class HeaderElementTest {
  HeaderElement header;


  @Before
  public void setUp() throws Exception {
    this.header = new HeaderElement();

  }

  @After
  public void tearDown() throws Exception {}


  @Test
  public void testIsEnd() {
    Assert.assertEquals(true, this.header.isEnd(""));
    Assert.assertEquals(false, this.header.isEnd("ashjs"));
  }


  @Test
  public void testCalcOrder() {
    Assert.assertEquals(new Integer(2), HeaderElement.calcOrder("## fkfdjv"));
    Assert.assertEquals(new Integer(4), HeaderElement.calcOrder("#### fkfdjv"));
    Assert.assertEquals(new Integer(6), HeaderElement.calcOrder("####### fkfdjv"));
  }

  @Test
  public void testIsHeader() {
    Assert.assertEquals(true, HeaderElement.isHeader("## cjdnckd"));
    Assert.assertEquals(false, HeaderElement.isHeader("cjdnckd"));
  }

  @Test
  public void testExtractString() {
    Assert.assertEquals("hello", this.header.extractString("## hello"));
  }



}
