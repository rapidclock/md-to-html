package edu.neu.ccs.cs5004.seattle.assignment9.impl;

/**
 * @author RT
 */
public class PlainTextElement extends DocElement {
	private String value;

	/**
	 * Creates a new TextElement.
	 *
	 * @param value
	 * 		String value of the TextElement.
	 */
	public PlainTextElement (String value) {
		super(DefaultTagStrings.BLANK_STRING);
		this.value = value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean addBlock (String line) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String printBlock () {
		return value;
	}
}
