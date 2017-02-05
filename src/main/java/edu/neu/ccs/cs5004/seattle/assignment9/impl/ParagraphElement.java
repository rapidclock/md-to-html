package edu.neu.ccs.cs5004.seattle.assignment9.impl;

/**
 * @author RT
 */
public class ParagraphElement extends DynDocElement {
  public static final String SEPARATOR_REGEX = "[^*]+|\\*[^*].[^*]+\\*|\\*";
  public static final String CONVERT_DOCELEM_REGEX = "^[*]|[*]$";


  /**
   * Creates a Paragraph Element.
   */
  public ParagraphElement() {
    super(DocElement.DefaultTagStrings.PARAGRAPH_TAG, 1);
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean addBlock(String line) {
    this.getList().add(new PlainTextElement(this.inLineTagger(line)));
    return this.isEnd(line);
  }
}
