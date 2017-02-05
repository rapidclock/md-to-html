package edu.neu.ccs.cs5004.seattle.assignment9.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Tag that has properties.
 * <p>
 * Properties are appended to the start tag.
 *
 * @author RT
 */
public class PropTag extends Tag {
	private Map<String, String> properties;

	/**
	 * Creates a new PropTag.
	 *
	 * @param name
	 * 		The Tags Name
	 * @param properties
	 * 		The Map containing the property's name-value pair mapping.
	 */
	public PropTag (String name, Map<String, String> properties) {
		super(name);
		this.properties = properties;
	}

	/**
	 * Creates a new PropTag.
	 *
	 * @param name
	 * 		The Tags Name
	 */
	public PropTag (String name) {
		super(name);
		this.properties = new HashMap<>();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getStartTag () {
		return DocElement.DefaultTagStrings.OPEN_ANG_BRACKET + this.getName() +
			   this.getPropertiesList() +
			   DocElement.DefaultTagStrings.CLOSE_ANG_BRACKET;
	}

	/**
	 * Returns the Map of Property name-value pairs as a String.
	 *
	 * @return the Map of Property name-value pairs as a String.
	 */
	private String getPropertiesList () {
		StringBuilder stringBuilder = new StringBuilder();
		for (Map.Entry<String, String> entry : this.properties.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			stringBuilder.append(DocElement.DefaultTagStrings.SINGLE_SPACE);
			stringBuilder.append(key);
			stringBuilder.append(DocElement.DefaultTagStrings.EQUAL_SIGN);
			stringBuilder.append(DocElement.DefaultTagStrings.QUOTE);
			stringBuilder.append(value);
			stringBuilder.append(DocElement.DefaultTagStrings.QUOTE);
		}
		return stringBuilder.toString();
	}

	/**
	 * Gets the properties of the Tag.
	 *
	 * @return Value of properties.
	 */
	public Map<String, String> getProperties () {
		return this.properties;
	}
}
