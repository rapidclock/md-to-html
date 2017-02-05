package edu.neu.ccs.cs5004.seattle.assignment9.impl;

/**
 * @author RT
 */
public class HorizontalLineElement extends DynDocElement {


  /**
   * Creates a HorizontalLineElement.
   */
  public HorizontalLineElement() {
    super(DefaultTagStrings.HORIZONTAL_LINE_TAG, DefaultTagStrings.DEFAULT_ORDER);
  }

  /**
   * checks if the line passed in is a horizontal line
   *
   * @param line the line to be check
   * @return true if the line passed in is a horizontal line,else return false
   */
  public static Boolean isHorizontalLine(String line) {
    return line.matches(RegExStrings.HORIZONTAL_LINE_ID);
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public Boolean addBlock(String line) {
    return true;
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public String printBlock() {
    return this.getTag().getStartTag();
  }

}
