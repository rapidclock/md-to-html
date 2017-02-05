package edu.neu.ccs.cs5004.seattle.assignment9.impl;

/**
 * @author RT
 */
public class HeaderElement extends DynDocElement {
	private static final String HEADER_REGEX = "#";
	private static final String HEADER_REGEX_FULL = "^\\#+";
	private static final Integer HEADER_MAX_ORDER = 6;


	/**
	 * Creates a default Header Element with order as 1.
	 */
	public HeaderElement () {
		super(DefaultTagStrings.HEADER_TAG, DefaultTagStrings.DEFAULT_ORDER);
	}

	/**
	 * Calculates the order of the given line.
	 *
	 * @param line
	 * 		The string for which order is to be deduced.
	 *
	 * @return the order of the given line.
	 */
	public static Integer calcOrder (String line) {
		Integer order = (line.length()
						 - line.replaceAll(HeaderElement.HEADER_REGEX_FULL, DefaultTagStrings
				.BLANK_STRING).length());
		if (order < HeaderElement.HEADER_MAX_ORDER) {
			return order;
		} else {
			return HeaderElement.HEADER_MAX_ORDER;
		}
	}

	/**
	 * Test to see if the given String is a header or not.
	 *
	 * @param line
	 * 		the String to be checked.
	 *
	 * @return true if it is a header and false otherwise.
	 */
	public static Boolean isHeader (String line) {
		return line.startsWith(HeaderElement.HEADER_REGEX);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean addBlock (String line) {
		this.setOrder(HeaderElement.calcOrder(line));
		this.getTag().setName(DefaultTagStrings.HEADER_TAG + this.getOrder());
		line = this.extractString(line);
		this.getList().add(new PlainTextElement(line));
		return true;
	}

	/**
	 * Extracts the String from the Header.
	 *
	 * @param content
	 * 		The Header text from which the String is to be extracted.
	 *
	 * @return the String from the Header.
	 */
	public String extractString (String content) {
		content = content.replaceAll(HEADER_REGEX_FULL, DefaultTagStrings.BLANK_STRING);
		content = content.replaceFirst(DefaultTagStrings.SINGLE_SPACE, DefaultTagStrings
				.BLANK_STRING);
		return content;
	}

}
