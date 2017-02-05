package edu.neu.ccs.cs5004.seattle.assignment9.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmphasizerTest {
  private Emphasizer emphasis;

  @Before
  public void setUp() throws Exception {
    this.emphasis = Emphasizer.getInstance();
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testPassIn() {
    Assert.assertEquals("hell<strong>ooo</strong>ssd", this.emphasis.passIn("hell*ooo*ssd"));
    Assert.assertEquals("hell<em>ooo</em>ssd", this.emphasis.passIn("hell_ooo_ssd"));
    Assert.assertEquals("hellooossd", "hellooossd");
    Assert.assertEquals("hell<strong>oo<em>o</strong>ss</em>d",
        this.emphasis.passIn("hell*oo_o*ss_d"));
  }

}
