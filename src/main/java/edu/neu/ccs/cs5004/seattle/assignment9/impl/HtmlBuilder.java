package edu.neu.ccs.cs5004.seattle.assignment9.impl;

import edu.neu.ccs.cs5004.seattle.assignment9.design.Block;
import edu.neu.ccs.cs5004.seattle.assignment9.design.Builder;

/**
 * Represents the HtmlBuilder, a custom implementation of
 * {@link  edu.neu.ccs.cs5004.seattle.assignment9.design.Builder Builder} for HTML Document
 * Building.
 *
 * @author RT
 */
public class HtmlBuilder extends Builder {
	private final HtmlElement htmlElement;
	private final HeadElement headElement;
	private final TitleElement titleElement;
	private final BodyElement bodyElement;

	/**
	 * Creates a HtmlBuilder.
	 *
	 * @param fileName
	 * 		String representing the title of the Html page.
	 */
	public HtmlBuilder (String fileName) {
		super(null);
		this.bodyElement = new BodyElement();
		this.titleElement = new TitleElement(fileName);
		this.headElement = new HeadElement(titleElement);
		this.htmlElement = new HtmlElement(headElement, bodyElement);
		this.setBuilding(new HtmlDocument(htmlElement));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addToBuilding (Block block) {
		this.bodyElement.getBodyList().add(block);
	}
}