package edu.neu.ccs.cs5004.seattle.assignment9.design;

/**
 * Builder represents the creator of the
 * {@link  edu.neu.ccs.cs5004.seattle.assignment9.design.Buildable Buildable}.
 * <p>
 * The Buildable receives Blocks via the
 * {@link  edu.neu.ccs.cs5004.seattle.assignment9.design.Builder#addToBuilding(Block)
 * addToBuilding(Block)}
 * method. Implementations of this method seek to integrate the blocks into the Buildable building.
 *
 * @author RT
 */
public abstract class Builder {
	private Buildable building;

	/**
	 * Creates a Builder Object
	 *
	 * @param building
	 * 		The Buildable object to build
	 */
	public Builder (Buildable building) {
		this.building = building;
	}

	/**
	 * Gets building.
	 *
	 * @return Value of building.
	 */
	public Buildable getBuilding () {
		return this.building;
	}

	/**
	 * Sets new building.
	 *
	 * @param building
	 * 		New value of building.
	 */
	protected void setBuilding (Buildable building) {
		this.building = building;
	}

	/**
	 * Adds the given Block to the Building.
	 *
	 * @param block
	 * 		The Block to add to the Buildable.
	 */
	public abstract void addToBuilding (Block block);
}
