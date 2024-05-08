package net.oijon.stringsorts;

/**
 * Compares two different strings. Used in the various sorting algorithms.
 */
public class Comparer {
	
	private Comparison comparison;
	
	/**
	 * Creates the comparer, and sets a comparison mode
	 * @param comparison The mode of comparison the comparer should use
	 */
	public Comparer(Comparison comparison) {
		this.comparison = comparison;
	}
	
	/**
	 * Sets the comparison mode
	 * @param comparison The mode of comparison the comparer should use
	 */
	public void setComparisonMode(Comparison comparison) {
		this.comparison = comparison;
	}
	
	/**
	 * Compares the two strings using the set comparison mode.
	 * @param a The first string to compare
	 * @param b The second string to compare
	 * @return 0 if a == b; 1 if a > b, -1 if a < b
	 */
	public int compare(String a, String b) {
		switch (comparison) {
			case ALPHABETICAL:
				return compareAlphabetically(a, b);
			case REVERSE_ALPHABETICAL:
				return compareAlphabetically(a, b) * -1;
			case SIZE:
				return compareSize(a, b);
			case REVERSE_SIZE:
				return compareSize(a, b) * -1;
			default:
				return compareAlphabetically(a, b);
		}
	}
	
	/**
	 * Compares two strings alphabetically
	 * @param a The first string
	 * @param b The second string
	 * @return 0 if a == b; 1 if a > b, -1 if a < b
	 */
	private int compareAlphabetically(String a, String b) {
		// get the index that past which only comparison by size is possible
		int smallestMax = -1;
		if (a.length() < b.length()) {
			smallestMax = a.length();
		} else {
			smallestMax = b.length();
		}
		
		// go through each character, and check if they are equal. if not, find the larger one, and return as that string being larger
		for (int i = 0; i < smallestMax; i++) {
			char charA = a.charAt(i);
			char charB = b.charAt(i);
			if (charA != charB) {
				if (charA > charB) {
					return 1;
				} else {
					return -1;
				}
			}
		}
		
		// comparison via alphanumericallity has failed, compare via size instead
		return compareSize(a, b);
	}
	
	
	/**
	 * Compares two strings by size
	 * @param a The first string
	 * @param b The second string
	 * @return 0 if a == b; 1 if a > b, -1 if a < b
	 */
	private int compareSize(String a, String b) {
		return a.compareTo(b);
	}
	
}
