package edu.neu.ccs.cs5004.seattle.assignment9.impl;

import edu.neu.ccs.cs5004.seattle.assignment9.design.Block;
import edu.neu.ccs.cs5004.seattle.assignment9.utils.ImpedList;

/**
 * Represents a <b>Dyn</b>amic <b>Doc</b>ument <b>Element</b>.
 * <p>
 * Used to indicate the Blocks that form the Dynamic Content of the Html Document.
 *
 * @author RT
 */
public abstract class DynDocElement extends DocElement {
  private Integer order;
  private ImpedList<DocElement> list;

  /**
   * Constructs a new DynDocElement.
   *
   * @param tagType String representation of the DocElement's tag.
   * @param order Order of the Element.
   */
  public DynDocElement(String tagType, Integer order) {
    super(tagType);
    this.order = order;
    this.list = new ImpedList<>();
  }

  /**
   * Gets order.
   *
   * @return Value of order.
   */
  public Integer getOrder() {
    return this.order;
  }

  /**
   * Sets new order.
   *
   * @param order New value of order.
   */
  public void setOrder(Integer order) {
    this.order = order;
  }

  /**
   * Gets list.
   *
   * @return Value of list.
   */
  public ImpedList<DocElement> getList () {
    return this.list;
  }

  /**
   * Sets new list.
   *
   * @param list New value of list.
   */
  public void setList (ImpedList<DocElement> list) {
    this.list = list;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String printBlock() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(this.getTag().getStartTag());
    for (Block element : this.list) {
      stringBuffer.append(element.printBlock());
      stringBuffer.append("\n");
    }
    stringBuffer.append(this.getTag().getEndTag());
    return stringBuffer.toString();
  }

  /**
   * Determines if the given represents the termination of the current block.
   * <p>
   * By default, a Blank string is taken to mean the end of the current block.
   *
   * @param line The input line.
   *
   * @return a Boolean indicating the end of a Block.
   */
  protected Boolean isEnd(String line) {
    return line.equals(DefaultTagStrings.BLANK_STRING);
  }

  /**
   * replaces the strings in the line with tags
   *
   * @param input the line passed in as input
   * @return a string by replacing certain strings with tags
   */
  public String inLineTagger(String input) {
    Emphasizer emphasizer = Emphasizer.getInstance();
    HyperlinkElement hlElement = HyperlinkElement.getInstance();
    return hlElement.passIn(emphasizer.passIn(input));
  }
}
