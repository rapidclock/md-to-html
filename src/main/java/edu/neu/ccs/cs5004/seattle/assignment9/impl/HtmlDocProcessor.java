package edu.neu.ccs.cs5004.seattle.assignment9.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import edu.neu.ccs.cs5004.seattle.assignment9.design.Assembler;

/**
 * @author RT
 */
public class HtmlDocProcessor {

	public static void main (String[] args) {

		CommandLineChecks cLCheck = new CommandLineChecks(args);
		if (! cLCheck.verifyArgs()) {
			throw new InvalidArgumentException();
		}

		Assembler assembler = new HtmlAssembler(args[0]);

		String line;
		try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {

			while ((line = reader.readLine()) != null) {
				assembler.receiveInput(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		assembler.getBuilder().getBuilding().toFile(HtmlDocProcessor.changeFileName(args[0]));
	}

	/**
	 * Returns the filename of the file to be created.
	 *
	 * @param fileName
	 * 		required fileName of the output file.
	 *
	 * @return the filename of the file to be created.
	 */
	public static String changeFileName (String fileName) {
		return fileName.replaceAll(StringConstants.FILE_REGEX, StringConstants.OUTPUT_EXTENSION);

	}


	/**
	 * Class used to Check the Command Line arguments if they agree with the preset conditions.
	 */
	protected static class CommandLineChecks {
		String[] args;

		/**
		 * Creates a new object of CommandLineChecks.
		 *
		 * @param args
		 * 		The Array of String that holds all the command line arguments passed to the
		 * 		program.
		 */
		public CommandLineChecks (String[] args) {
			this.args = args;
		}

		/**
		 * Used to verify if the input Arguments are valid.
		 *
		 * @return true if the arguments are valid and false otherwise.
		 */
		protected Boolean verifyArgs () {
			return verifyFileExists();
		}

		/**
		 * Used to verify if the given input file exists.
		 *
		 * @return true if the input argument exists and false otherwise.
		 */
		private Boolean verifyFileExists () {
			if (verifyArgsExists()) {
				File file = new File(this.args[0]);
				return file.exists() && file.isFile();
			} else {
				return false;
			}
		}

		/**
		 * Determines if the Args are valid, i.e. not null and length is greater than zero.
		 *
		 * @return true if the arguments are valid and false otherwise.
		 */
		private Boolean verifyArgsExists () {
			return ! (this.args[0] == null) && (this.args[0].length() > 0);
		}
	}


	/**
	 * Used to store String Constants that relate to TextProcessor.class
	 */
	private static class StringConstants {
		public static final String STD_ERR_MESSAGE = "File Name not Entered or No Such File " +
													 "Exists"
													 + ".\nPlease Ensure that the file exists";
		public static final String FILE_REGEX = "\\..*";
		public static final String OUTPUT_EXTENSION = ".html";
	}
}
