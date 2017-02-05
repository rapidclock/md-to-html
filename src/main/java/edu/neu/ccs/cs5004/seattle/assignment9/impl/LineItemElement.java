package edu.neu.ccs.cs5004.seattle.assignment9.impl;

import edu.neu.ccs.cs5004.seattle.assignment9.design.Block;

/**
 * @author RT
 */
public class LineItemElement extends DynDocElement {

	private DynDocElement hOElement;

	/**
	 * Constructs a new Line Item Element.
	 *
	 * @param order
	 * 		Order of the Line Item Element.
	 */
	public LineItemElement (Integer order) {
		super(DefaultTagStrings.LINE_ITEM, order);
		this.hOElement = null;
	}

	/**
	 * Returns the order of the given line.
	 *
	 * @param content
	 * 		The string for which order is to be deduced.
	 *
	 * @return the order of the given line.
	 */
	public static Integer order (String content) {
		Integer count = 0;
		String trimmedContent = content.replaceAll(RegExStrings.LI_ORDER_REGEX,
												   DocElement.DefaultTagStrings.BLANK_STRING);
		count = content.length() - trimmedContent.length();
		count = (count / 2) + 1;
		return count;
	}

	/**
	 * Returns the Higher Order Element.
	 *
	 * @return the hOElement
	 */
	public DynDocElement gethOElement () {
		return this.hOElement;
	}

	/**
	 * Sets the Higher Order Element.
	 *
	 * @param hOElement
	 * 		the hOElement to set
	 */
	public void sethOElement (DynDocElement hOElement) {
		this.hOElement = hOElement;
	}

	/**
	 * Extracts the String from the Line Item.
	 *
	 * @param line
	 * 		The text from which the String is to be extracted.
	 *
	 * @return the String from the Line Item.
	 */
	public String extractString (String line) {
		if (OrderedListElement.isOrderedListElement(line)) {
			line = line.replaceAll(RegExStrings.OL_REGEX, DefaultTagStrings.BLANK_STRING);
			line = line.replaceFirst(DefaultTagStrings.SINGLE_SPACE, DefaultTagStrings
					.BLANK_STRING);
		} else {
			line = line.replaceAll(RegExStrings.UL_REGEX, DefaultTagStrings.BLANK_STRING);
		}
		return line;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean addBlock (String line) {
		if (LineItemElement.order(line).equals(this.getOrder())) {
			line = this.extractString(line);
			this.getList().add(new PlainTextElement(this.inLineTagger(line)));
		} else if (this.gethOElement() == null) {
			if (OrderedListElement.isOrderedListElement(line)) {
				this.sethOElement(new OrderedListElement(this.getOrder() + 1));
				this.gethOElement().addBlock(line);
			} else {
				this.sethOElement(new UnorderedListElement(this.getOrder() + 1));
				this.gethOElement().addBlock(line);
			}
		} else {
			this.gethOElement().addBlock(line);
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String printBlock () {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(this.getTag().getStartTag());
		for (Block element : this.getList()) {
			stringBuffer.append(element.printBlock());
		}
		if (this.gethOElement() != null) {
			stringBuffer.append(this.gethOElement().printBlock());
		}
		stringBuffer.append(this.getTag().getEndTag());
		return stringBuffer.toString();
	}

}
