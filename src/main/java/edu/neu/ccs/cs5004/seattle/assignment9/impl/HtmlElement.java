package edu.neu.ccs.cs5004.seattle.assignment9.impl;

/**
 * @author RT
 */
public class HtmlElement extends DocElement {
	private HeadElement head;
	private BodyElement body;

	/**
	 * Creates a HtmlElement.
	 *
	 * @param head
	 * 		The Head Element.
	 * @param body
	 * 		The Body Element.
	 */
	public HtmlElement (HeadElement head, BodyElement body) {
		super(DefaultTagStrings.HTML_TAG);
		this.head = head;
		this.body = body;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String printBlock () {
		return DefaultTagStrings.DOCTYPE + DefaultTagStrings.NEWLINE + this.getTag().getStartTag()
			   + DefaultTagStrings.NEWLINE + this.getHead().printBlock() + DefaultTagStrings
					   .NEWLINE + this.getBody().printBlock() + this.getTag().getEndTag();
	}

	/**
	 * Gets body.
	 *
	 * @return Value of body.
	 */
	protected BodyElement getBody () {
		return body;
	}

	/**
	 * Gets head.
	 *
	 * @return Value of head.
	 */
	protected HeadElement getHead () {
		return head;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean addBlock (String line) {
		return false;
	}
}
