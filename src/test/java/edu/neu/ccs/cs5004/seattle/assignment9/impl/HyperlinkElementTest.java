package edu.neu.ccs.cs5004.seattle.assignment9.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HyperlinkElementTest {
  private HyperlinkElement hlElement;

  @Before
  public void setUp() throws Exception {
    this.hlElement = HyperlinkElement.getInstance();
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testIsHyperlinkElement() {
    Assert.assertTrue(this.hlElement.isHyperLinkElement(
        "You can see an example [Confused](https://media.giphy.com/media/wi9yHmX7Sztuw/giphy.gif). "));
    Assert
        .assertFalse(this.hlElement.isHyperLinkElement("You can see an example [Confused](https "));
  }

  @Test
  public void testGetLink() {
    Assert.assertEquals("https://media.giphy.com/media/wi9yHmX7Sztuw/giphy.gif",
        this.hlElement.getLink(
            "You can see an example [Confused](https://media.giphy.com/media/wi9yHmX7Sztuw/giphy.gif)."));

  }

  @Test
  public void testPassIn() {
    Assert.assertEquals(
        "You can see an example <a href=\"https://media.giphy.com/media/wi9yHmX7Sztuw/giphy.gif\">Confused</a>.",
        this.hlElement.passIn(
            "You can see an example [Confused](https://media.giphy.com/media/wi9yHmX7Sztuw/giphy.gif)."));
  }



}
