package edu.neu.ccs.cs5004.seattle.assignment9.design;

/**
 * Represents an Assembler.
 * <p>
 * The Assembler works on processing data external to the system and passes the processed {@link
 * edu.neu.ccs.cs5004.seattle.assignment9.design.Block  Blocks} to the {@link
 * edu.neu.ccs.cs5004.seattle.assignment9.design.Builder  Builder}.
 *
 * @author RT
 */
public abstract class Assembler {
	private Builder builder;

	/**
	 * Creates an Assembler.
	 *
	 * @param builder
	 * 		The builder that is part of the Assembler.
	 */
	public Assembler (Builder builder) {
		this.builder = builder;
	}


	/**
	 * Gets builder.
	 *
	 * @return Value of builder.
	 */
	public Builder getBuilder () {
		return this.builder;
	}

	/**
	 * Sends data/signals to the Builder.
	 */
	protected abstract void passToBuilder ();

	/**
	 * Recieves the input string from the Invoker of the Assembler.
	 *
	 * @param input
	 * 		The Input String that is to be processed by the Assembler.
	 */
	public abstract void receiveInput (String input);
}
