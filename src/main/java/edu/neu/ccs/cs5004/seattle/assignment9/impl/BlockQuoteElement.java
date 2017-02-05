package edu.neu.ccs.cs5004.seattle.assignment9.impl;

/**
 * @author RT
 */
public class BlockQuoteElement extends DynDocElement {

  /**
   * Creates a default Block Quote Element with order as 1.
   */
  public BlockQuoteElement() {
    super(DefaultTagStrings.BLOCKQUOTE, DefaultTagStrings.DEFAULT_ORDER);
  }

  /**
   * Calculates the order of the given line.
   *
   * @param line The string for which order is to be deduced.
   *
   * @return the order of the given line.
   */
  public static Integer calcOrder(String line) {
    Integer order = (line.length()
        - line.replaceAll(RegExStrings.BLOCK_QUOTE_REGEX, DefaultTagStrings.BLANK_STRING).length());
    return order / 2;
  }

  /**
   * Test to see if the given String is a block quote or not.
   *
   * @param line the String to be checked.
   *
   * @return true if it is a block quote and false otherwise.
   */
  public static boolean isBlockQuoteElement(String line) {
    return line.startsWith("> ");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean addBlock(String line) {
	  this.setOrder(BlockQuoteElement.calcOrder(line));
	  if (this.getOrder().equals(DefaultTagStrings.DEFAULT_ORDER)) {
		line = this.extractString(line);
		ParagraphElement paragraphElement = new ParagraphElement();
      paragraphElement.getList().add(new PlainTextElement(this.inLineTagger(line)));
      this.getList().add(paragraphElement);
    } else {
      BlockQuoteElement blockQuoteElement = new BlockQuoteElement();
      blockQuoteElement.addBlock(reduceStringOrder(line));
      this.getList().add(blockQuoteElement);
    }
    return true;
  }

  /**
   * Extracts the String from the block quote.
   *
   * @param content The block quote text from which the String is to be extracted.
   *
   * @return the String from the block quote.
   */
  private String extractString(String content) {
    content = content.replaceAll(RegExStrings.BLOCK_QUOTE_REGEX, DefaultTagStrings.BLANK_STRING);
    return content;
  }

  /**
   * Returns the block quote with order reduced by one
   *
   * @param line the original block quote
   * @return the block quote with order reduced by one
   */
  private String reduceStringOrder(String line) {
    return line.replaceFirst(RegExStrings.BLOCK_QUOTE_ORDER_REDUCE, DefaultTagStrings.BLANK_STRING);
  }

}
