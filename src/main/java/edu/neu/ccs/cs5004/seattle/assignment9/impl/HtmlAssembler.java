package edu.neu.ccs.cs5004.seattle.assignment9.impl;

import edu.neu.ccs.cs5004.seattle.assignment9.design.Assembler;

/**
 * Represents the custom implementation of the
 * {@link  edu.neu.ccs.cs5004.seattle.assignment9.design.Assembler Assembler}.
 *
 * @author RT
 */
public class HtmlAssembler extends Assembler {
	Boolean completedFlag;
	DynDocElement element;

	/**
	 * Creates a HtmlAssembler.
	 *
	 * @param fileName
	 * 		The filename which represents the filename of the File.
	 */
	public HtmlAssembler (String fileName) {
		super(new HtmlBuilder(fileName));
		this.completedFlag = true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void passToBuilder () {
		this.getBuilder().addToBuilding(this.element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void receiveInput (String line) {
		if (this.element != null) {
			if ((OrderedListElement.isOrderedListElement(line) || UnorderedListElement
					.isUnOrderedListElement(line)) && ! completedFlag) {
				this.completedFlag = this.element.isEnd(line);
				if (this.completedFlag) {
					this.passToBuilder();
				}
			}
		}
		if (this.completedFlag) {
			this.element = createElement(line);
			this.completedFlag = this.element.addBlock(line);
		} else {
			this.completedFlag = this.element.addBlock(line);
		}
		if (this.completedFlag) {
			this.passToBuilder();
		}
	}

	/**
	 * Returns a Block representation of the String.
	 *
	 * @param line
	 * 		String from which a Block is to be created.
	 *
	 * @return a Block representation of the String.
	 */
	private DynDocElement createElement (String line) {
		if (HeaderElement.isHeader(line)) {
			return new HeaderElement();
		}
		if (HorizontalLineElement.isHorizontalLine(line)) {
			return new HorizontalLineElement();
		}
		if (BlockQuoteElement.isBlockQuoteElement(line)) {
			return new BlockQuoteElement();
		}
		if (OrderedListElement.isOrderedListElement(line)) {
			return new OrderedListElement(1);
		}
		if (UnorderedListElement.isUnOrderedListElement(line)) {
			return new UnorderedListElement(1);
		} else {
			return new ParagraphElement();
		}
	}
}
