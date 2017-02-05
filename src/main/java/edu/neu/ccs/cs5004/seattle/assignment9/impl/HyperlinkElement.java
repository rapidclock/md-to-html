package edu.neu.ccs.cs5004.seattle.assignment9.impl;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author RT
 */
public class HyperlinkElement {
  private static HyperlinkElement instance = null;
  private PropTag hyperlinkTag;

  /**
   * creates a new hyper link element
   */
  private HyperlinkElement() {
    this.hyperlinkTag = new PropTag(DocElement.DefaultTagStrings.HYPERLINK_TAG, new HashMap<>());
  }

  /**
   * constructs a singleton element object of this class
   *
   * @return a new hyper link element
   */
  public static HyperlinkElement getInstance() {
    if (HyperlinkElement.instance == null) {
      HyperlinkElement.instance = new HyperlinkElement();
    }
    return HyperlinkElement.instance;
  }

  /**
   * Passes the input string to the hyperLink function
   *
   * @param inputString the string to be passed in
   * @return string with all the mark down tags replaced by the HTML tags
   */
  public String passIn(String inputString) {
    return hyperLink(inputString);
  }


  /**
   *
   * @param inputString
   * @return
   */
  public String hyperLink(String inputString) {
    if (isHyperLinkElement(inputString)) {
      this.hyperlinkTag.getProperties().put(DocElement.DefaultTagStrings.HYPERLINK_PROP_HREF,
          this.getLink(inputString));
      return hyperLink(inputString.replaceFirst("\\[", this.hyperlinkTag.getStartTag())
          .replaceFirst("\\]", this.hyperlinkTag.getEndTag()).replaceFirst("\\([^\\(\\)]+\\)", ""));
    }
    return inputString;
  }

  /**
   * Checks if the given line is a hyper link element
   *
   * @param line the line to be checked
   * @return true if the give line has hyper link,else return false
   */
  public boolean isHyperLinkElement(String line) {
    return line.matches(".*\\[[^\\[\\]]+\\]\\([^()]+\\).*");
  }

  /**
   * Return the first website address found in the passed in line argument
   *
   * @param inputString the line to be checked
   * @return a new string which is the first web address in the passed in line
   */
  public String getLink(String inputString) {

    Pattern pattern = Pattern.compile("\\([^\\)\\(]+\\)");
    Matcher matcher = pattern.matcher(inputString);
    String link = "";
    if (matcher.find()) {
      link = matcher.group();
      link = link.replaceAll("[\\(\\)]", "");
    }
    return link;
  }

}
