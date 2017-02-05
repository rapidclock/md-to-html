package edu.neu.ccs.cs5004.seattle.assignment9.impl;

/**
 * @author RT
 */
public class UnorderedListElement extends DynDocElement {

  /**
   * Creates an UnorderedListElement of the given order.
   *
   * @param order The order of the UnorderedListElement.
   */
  public UnorderedListElement(Integer order) {
    super(DefaultTagStrings.UNORDERED_LIST_TAG, order);
  }

  /**
   * Tests whether the given line is an UnOrdered List or not.
   *
   * @param line The line which is to be tested.
   *
   * @return true if the line is an UnOrderedListElement and false otherwise.
   */
  public static boolean isUnOrderedListElement(String line) {
    String trimmedContent = line.replaceAll(RegExStrings.LIST_TRIM, DefaultTagStrings.BLANK_STRING);
    return trimmedContent.startsWith(RegExStrings.UL_TRIM_STARTING);
  }


  /**
   * {@inheritDoc}
   */
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
   * checks if the line is a ordered list element and of order 1
   *
   * @param line the line to be checked
   * @return true if the line is a ordered list element and of order 1 and the order of current
   *         object is 1,else return false
   */
  private Boolean isDiffListOfUnitOrder(String line) {
    return (this.getOrder().equals(1) && LineItemElement.order(line).equals(1)
        && (OrderedListElement.isOrderedListElement(line)));
  }


  /**
   * {@inheritDoc}
   */
  @Override
  protected Boolean isEnd(String line) {
    return super.isEnd(line) || isDiffListOfUnitOrder(line);
  }
}
