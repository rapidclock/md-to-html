package edu.neu.ccs.cs5004.seattle.assignment9.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import edu.neu.ccs.cs5004.seattle.assignment9.design.Block;
import edu.neu.ccs.cs5004.seattle.assignment9.design.Buildable;

/**
 * @author RT
 */
public class HtmlDocument implements Buildable {
	private Block htmlBlock;

	/**
	 * Creates a New Html Document.
	 *
	 * @param htmlBlock
	 * 		Block that is the primary HtmlElement Block of the Document.
	 */
	public HtmlDocument (Block htmlBlock) {
		this.htmlBlock = htmlBlock;
	}

	/**
	 * Gets htmlBlock.
	 *
	 * @return Value of htmlBlock.
	 */
	protected Block getHtmlBlock () {
		return this.htmlBlock;
	}

	/**
	 * Sets new htmlBlock.
	 *
	 * @param htmlBlock
	 * 		New value of htmlBlock.
	 */
	protected void setHtmlBlock (Block htmlBlock) {
		this.htmlBlock = htmlBlock;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String asString () {
		return this.getHtmlBlock().printBlock();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void toFile (String fileName) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(new File(fileName)))) {
			writer.println(this.asString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
