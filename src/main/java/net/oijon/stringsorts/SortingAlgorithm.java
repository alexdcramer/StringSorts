package net.oijon.stringsorts;

import java.util.ArrayList;

/**
 * Provides all needed methods for all sorting algorithms.
 */
public abstract class SortingAlgorithm {

	/**
	 * Sorts an ArrayList from A -> Z
	 * @param list the ArrayList to be sorted
	 * @return the sorted ArrayList
	 */
	public abstract ArrayList<String> sort(ArrayList<String> list);
	/**
	 * Sorts a string array from A -> Z
	 * @param list the string array to be sorted
	 * @return the sorted string array
	 */
	public abstract String[] sort(String[] list);
	/**
	 * Sorts an ArrayList from a set comparison mode
	 * @param list the ArrayList to be sorted
	 * @param mode the comparison mode to be used
	 * @return the sorted ArrayList
	 */
	public abstract ArrayList<String> sort(ArrayList<String> list, Comparison mode);
	/**
	 * Sorts a string array from a set comparison mode
	 * @param list the string array to be sorted
	 * @param mode the comparison mode to be used
	 * @return the sorted string array
	 */
	public abstract String[] sort(String[] list, Comparison mode);
	
}
