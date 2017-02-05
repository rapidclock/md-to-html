package edu.neu.ccs.cs5004.seattle.assignment9.impl;

/**
 * Represents a Html Tag.
 * <p>
 * The tag usually consists of two types, the start tag and the end tag. Both tags are enclosed in
 * angular brackets but the end tag has an additional forward slash before the name.
 *
 * @author RT
 */
public class Tag {
	private String name;

	/**
	 * Creates a new Tag Object.
	 *
	 * @param name
	 * 		value of the tag.
	 */
	public Tag (String name) {
		this.name = name;
	}

	/**
	 * Returns the start tag by enclosing the name in between angular brackets.
	 *
	 * @return the start Tag.
	 */
	public String getStartTag () {
		return DocElement.DefaultTagStrings.OPEN_ANG_BRACKET + this.name + DocElement
				.DefaultTagStrings.CLOSE_ANG_BRACKET;
	}

	/**
	 * Returns the end tag by enclosing the name inbetween angular brackets.
	 *
	 * @return the end Tag.
	 */
	public String getEndTag () {
		return DocElement.DefaultTagStrings.OPEN_ANG_BRACKET + DocElement.DefaultTagStrings
				.FORWARD_SLASH + this.name + DocElement.DefaultTagStrings.CLOSE_ANG_BRACKET;
	}

	/**
	 * Gets name.
	 *
	 * @return Value of name.
	 */
	public String getName () {
		return name;
	}

	/**
	 * Sets the name of the Tag.
	 *
	 * @param name
	 * 		the name to set
	 */
	public void setName (String name) {
		this.name = name;
	}
}
