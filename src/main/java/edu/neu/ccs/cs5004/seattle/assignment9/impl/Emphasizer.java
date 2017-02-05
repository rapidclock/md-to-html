package edu.neu.ccs.cs5004.seattle.assignment9.impl;

/**
 * @author RT
 */
public class Emphasizer {
  private static Emphasizer instance = null;
  private Tag boldTag;
  private Tag italicTag;

  /**
   * Default Instance of Emphasizer.
   */
  private Emphasizer() {
    this.boldTag = new Tag(DocElement.DefaultTagStrings.BOLD_TAG);
    this.italicTag = new Tag(DocElement.DefaultTagStrings.ITALIC_TAG);
  }

  /**
   * returns the singleton instance of Emphasizer
   *
   * @return the singleton instance of Emphasizer
   */
  public static Emphasizer getInstance() {
    if (Emphasizer.instance == null) {
      Emphasizer.instance = new Emphasizer();
    }
    return Emphasizer.instance;
  }

  /**
   * passes the string to the bold emphasis and italic emphasis function
   *
   * @param inputString the string to be passed in
   * @return a string with tags wrapped around bold and italic emphasizes
   */
  public String passIn(String inputString) {
    return italicEmphasis(boldEmphasis(inputString));
  }


  /**
   * Replaces the mark down tags to HTML bold tags
   *
   * @param inputString the string to be passed in
   * @return a string in which the mark down tags are replaced by HTML tags
   */
  public String boldEmphasis(String inputString) {
    if (isBold(inputString)) {
      return boldEmphasis(
          inputString.replaceFirst(DocElement.RegExStrings.BOLD_ID, this.boldTag.getStartTag())
              .replaceFirst(DocElement.RegExStrings.BOLD_ID, this.boldTag.getEndTag()));
    }
    return inputString;
  }

  /**
   * checks if the string passed is a bold emphasis
   *
   * @param inputString the string to be passed in
   * @return true if the string passed is a bold emphasis,else return false
   */
  private boolean isBold(String inputString) {
    return inputString.matches(DocElement.RegExStrings.IS_BOLD);
  }


  /**
   * checks if the string passed is a italic emphasis
   *
   * @param inputString the string to be passed in
   * @return true if the string passed is a italic emphasis,else return false
   */
  public String italicEmphasis(String inputString) {
    if (isItalic(inputString)) {
      return italicEmphasis(
          inputString.replaceFirst(DocElement.RegExStrings.ITALIC_ID, this.italicTag.getStartTag())
              .replaceFirst(DocElement.RegExStrings.ITALIC_ID, this.italicTag.getEndTag()));
    }
    return inputString;
  }

  /**
   * checks if the string passed is a italic emphasis
   *
   * @param inputString the string to be passed in
   * @return true if the string passed is a italic emphasis,else return false
   */
  private boolean isItalic(String inputString) {
    return inputString.matches(DocElement.RegExStrings.IS_ITALICS);
  }
}
