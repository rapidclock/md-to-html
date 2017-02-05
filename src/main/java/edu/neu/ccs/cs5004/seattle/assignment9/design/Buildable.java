package edu.neu.ccs.cs5004.seattle.assignment9.design;

/**
 * Buildable represents the Target of the {@link  edu.neu.ccs.cs5004.seattle.assignment9.design
 * .Builder Builder}.
 * <p>
 * The Buildable is the object that is to be finally Constructed. Represents a Blueprint that the
 * Builder references to construct the final desired object.
 *
 * @author RT
 */
public interface Buildable {
	/**
	 * String representation of the Buildable.
	 *
	 * @return a String representation of the Buildable.
	 */
	String asString ();

	/**
	 * Writes the Buildable to a file of the given fileName.
	 *
	 * @param fileName
	 * 		The name of the file to which the Buildable is to be written.
	 */
	void toFile (String fileName);
}
