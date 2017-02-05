package edu.neu.ccs.cs5004.seattle.assignment9.impl;

/**
 * @author RT
 */
public class OrderedListElement extends DynDocElement {

  /**
   * Creates an OrderedListElement.
   *
   * @param order The order of the OrderedListElement.
   */
  public OrderedListElement(Integer order) {
    super(DefaultTagStrings.ORDERED_LIST_TAG, order);
  }

  /**
   * Tests whether the given line is an Ordered List or not.
   *
   * @param line The line which is to be tested.
   *
   * @return true if the line is an OrderedListElement and false otherwise.
   */
  public static boolean isOrderedListElement(String line) {
    String trimmedContent = line.replaceAll(RegExStrings.LIST_TRIM, DefaultTagStrings.BLANK_STRING);
    return trimmedContent.startsWith(RegExStrings.OL_TRIM_STARTING);
  }

  @Override
  public Boolean addBlock(String line) {
    DocElement newLI;
    if (this.isEnd(line)) {
      return true;
    }
    if (LineItemElement.order(line).equals(this.getOrder())) {
      newLI = new LineItemElement(this.getOrder());
      newLI.addBlock(line);
      this.getList().add(newLI);
    } else {
      newLI = this.getList().getLast();
      newLI.addBlock(line);
    }
    return false;
  }

  /**
   * checks if the line is a unordered list element and of order 1
   * 
   * @param line the line to be checked
   * @return true if the line is a unordered list element and of order 1 and the order of current
   *         object is 1,else return false
   */
  private Boolean isDiffListOfUnitOrder(String line) {
    return (this.getOrder().equals(1) && LineItemElement.order(line).equals(1)
        && (UnorderedListElement.isUnOrderedListElement(line)));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Boolean isEnd(String line) {
    return super.isEnd(line) || isDiffListOfUnitOrder(line);
  }
}
