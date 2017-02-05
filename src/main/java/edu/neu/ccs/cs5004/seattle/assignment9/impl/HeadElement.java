package edu.neu.ccs.cs5004.seattle.assignment9.impl;

/**
 * @author RT
 */
public class HeadElement extends DocElement {
	private TitleElement title;

	/**
	 * Creates a new HeadElement.
	 *
	 * @param title
	 * 		The title element that is part of the HeadElement.
	 */
	public HeadElement (TitleElement title) {
		super(DocElement.DefaultTagStrings.HEAD_TAG);
		this.title = title;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String printBlock () {
		return this.getTag().getStartTag() + this.getTitle().printBlock() + this.getTag()
																				.getEndTag();
	}

	/**
	 * Gets title.
	 *
	 * @return Value of title.
	 */
	protected TitleElement getTitle () {
		return title;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean addBlock (String line) {
		return false;
	}
}
