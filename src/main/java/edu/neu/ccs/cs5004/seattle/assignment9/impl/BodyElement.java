package edu.neu.ccs.cs5004.seattle.assignment9.impl;

import java.util.List;

import edu.neu.ccs.cs5004.seattle.assignment9.design.Block;
import edu.neu.ccs.cs5004.seattle.assignment9.utils.ImpedList;

/**
 * @author RT
 */
public class BodyElement extends DocElement {
  private List<Block> bodyList;
  /**
   * Creates a new Body Element.
   */
  public BodyElement () {
    super(DefaultTagStrings.BODY_TAG);
    bodyList = new ImpedList<>();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String printBlock () {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(this.getTag().getStartTag());
    for (Block element : bodyList) {
      stringBuffer.append(element.printBlock());
      stringBuffer.append("\n");
    }
    stringBuffer.append(this.getTag().getEndTag());
    return stringBuffer.toString();
  }

  /**
   * Gets bodyList.
   *
   * @return Value of bodyList.
   */
  protected List<Block> getBodyList () {
    return bodyList;
  }
  
  /**
   * 
   * {@inheritDoc}
   */
  @Override
  public Boolean addBlock(String line) {
    return false;
  }
}
