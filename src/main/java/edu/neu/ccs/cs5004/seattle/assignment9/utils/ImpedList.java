package edu.neu.ccs.cs5004.seattle.assignment9.utils;

import java.util.LinkedList;

/**
 * <p> Improvised version of {@link java.util.LinkedList LinkedList}. </p>
 * <p>
 * Modifies functionality of {@link java.util.LinkedList#get(int) get()} and {@link
 * java.util.LinkedList#getLast() getLast()}
 *
 * @param <X>
 * 		the type of elements held in this collection
 *
 * @author RT
 */
public class ImpedList<X> extends LinkedList<X> {

	/**
	 * Serial UID for Serialization
	 */
	private static final long serialVersionUID = - 4504073045739686490L;

	/**
	 * Default Constructor used to create a new ImpedList.
	 */
	public ImpedList () {
	}


	/**
	 * <p>
	 * Returns the last element in this list.
	 * <p>
	 * As a variation from the standard {@link java.util.LinkedList#getLast() getLast()}, this
	 * method returns {@code null} when the list is Empty instead of an
	 * {@link java.util.NoSuchElementException exception}.
	 *
	 * @return the last element in this list
	 */
	@Override
	public X getLast () {
		if (this.isEmpty()) {
			return null;
		}
		return super.getLast();
	}

	/**
	 * <p>
	 * Returns the element at the specified position in this list.
	 * <p>
	 * As a variation from the standard {@link java.util.LinkedList#get(int) get()}, returns {@code
	 * null} if the index is greater than the size of the list.
	 * <p>
	 * Another variation from {@link java.util.LinkedList#get(int) get()} is that the index begins
	 * with 1 and ends at {@code size()}.
	 *
	 * @param index
	 * 		index of the element to return
	 *
	 * @return the element at the specified position in this list
	 *
	 * @throws IndexOutOfBoundsException
	 * 		{@inheritDoc}
	 */
	@Override
	public X get (int index) {
		if (index > this.size()) {
			return null;
		}
		return super.get(index - 1);
	}


}