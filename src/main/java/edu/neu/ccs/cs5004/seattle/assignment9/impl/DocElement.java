package edu.neu.ccs.cs5004.seattle.assignment9.impl;

import edu.neu.ccs.cs5004.seattle.assignment9.design.Block;

/**
 * Represents a <b>Doc</b>ument <b>Element</b>.
 * <p>
 * DocElement is an implementation of a Block for the purpose of converting md files to html.
 * <p>
 * Represents the parent class of all Block components of the html file.
 *
 * @author RT
 */
public abstract class DocElement implements Block {
  private final Tag tag;

  /**
   * Creates a DocElement with a String value of the DocElement's Tag.
   *
   * @param tagType String value of the tag for the DocElement.
   */
  public DocElement(String tagType) {
    this.tag = new Tag(tagType);
  }

  /**
   * Gets tag.
   *
   * @return Value of tag.
   */
  protected Tag getTag() {
    return this.tag;
  }

  /**
   * Adds a Block using the input line and returns a Boolean signifying the addition to the calling
   * function.
   * <p>
   * The Boolean has special significance only to the calling method. Its implementation depends on
   * what signal the calling method wants to receive when a Line is added as a Block to the
   * DocElement.
   *
   * @param line The input line.
   *
   * @return a Boolean indicating required signal to the calling function.
   */
  public abstract Boolean addBlock(String line);

  /**
   * Class that has the Default Strings for various Html Tags.
   *
   * @author RT
   */
  public static class DefaultTagStrings {
    public static final String NEWLINE = "\n";
    public static final String BLANK_STRING = "";
    public static final Integer DEFAULT_ORDER = new Integer(1);
    public static final String DOCTYPE = "<!DOCTYPE html>";
    public static final String OPEN_ANG_BRACKET = "<";
    public static final String CLOSE_ANG_BRACKET = ">";
    public static final String FORWARD_SLASH = "/";
    public static final String HTML_TAG = "html";
    public static final String HEAD_TAG = "head";
    public static final String TITLE_TAG = "title";
    public static final String BODY_TAG = "body";
    public static final String PARAGRAPH_TAG = "p";
    public static final String HEADER_TAG = "h";
    public static final String BOLD_TAG = "strong";
    public static final String ORDERED_LIST_TAG = "ol";
    public static final String UNORDERED_LIST_TAG = "ul";
    public static final String LINE_ITEM = "li";
    public static final String HORIZONTAL_LINE_TAG = "hr";
    public static final String BLOCKQUOTE = "blockquote";
    public static final String ITALIC_TAG = "em";
    public static final String SINGLE_SPACE = " ";
    public static final String QUOTE = "\"";
    public static final String HYPERLINK_TAG = "a";
    public static final String EQUAL_SIGN = "=";
    public static final String HYPERLINK_PROP_HREF = "href";
  }

  /**
   * Class that has the Regular Expression Strings used for identifying and creating various Html
   * Elements.
   */
  public static class RegExStrings {
    public static final String IS_BOLD = ".*\\*[^*]+\\*.*";
    public static final String IS_ITALICS = ".*_[^_]+_.*";
    public static final String BOLD_ID = "\\*";
    public static final String ITALIC_ID = "_";
    public static final String HORIZONTAL_LINE_ID = "[*]{4,}[\\s]*$";
    public static final String BLOCK_QUOTE_REGEX_FULL = "^[>]+.*";
    public static final String BLOCK_QUOTE_REGEX = "([>]\\s)+";
    public static final String BLOCK_QUOTE_ORDER_REDUCE = ">\\s";
    public static final String LI_ORDER_REGEX = "^\\s+";
    public static final String OL_REGEX = "^\\s*[1]\\.";
    public static final String UL_REGEX = "\\s*\\*\\s";
    public static final String LIST_TRIM = "^\\s*";
    public static final String UL_TRIM_STARTING = "* ";
    public static final String OL_TRIM_STARTING = "1.";

  }
}
