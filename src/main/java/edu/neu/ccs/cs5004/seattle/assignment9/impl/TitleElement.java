package edu.neu.ccs.cs5004.seattle.assignment9.impl;

/**
 * @author RT
 */
public class TitleElement extends DocElement {
	private String value;

	/**
	 * Creates a TitleElement.
	 *
	 * @param value
	 * 		String that represents the title of the Html Document.
	 */
	public TitleElement (String value) {
		super(DocElement.DefaultTagStrings.TITLE_TAG);
		this.value = value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String printBlock () {
		return this.getTag().getStartTag() + value + this.getTag().getEndTag();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean addBlock (String line) {
		return false;
	}
}
