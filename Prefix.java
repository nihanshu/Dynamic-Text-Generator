/**
 * Dynamic Generation Project
 * 
 * Prefix class that represents prefixes used in a Dynamic Text Generator. A
 * prefix can have a fixed but arbitrary number of context words.
 *
 * @author (Nihanshu Purohit) 
 *   
 * @version (27th March, 2013)
 *
 */
import java.util.*;

public class Prefix {

	public static int len = 3;
	String[] prefix;
	String[] suffix; 
	public static String[] updatePrefix; // check that it's private or not?
	
	

	/**
	 * The array of prefix strings that denote the start of a sentence is an
	 * array of empty strings. This method must be called and the array must be
	 * initialized every time the program is trained on a new file so that the
	 * array will have the correct length (i.e. correct number of elements).
	 * <P>
	 * If this method is not called every time a new file is trained, the
	 * program may inexplicably fail (especially if the length of the prefix has
	 * been changed).
	 */
	public static void initializeSentenceStartArray() {
		updatePrefix = new String[len];
		
		for (int i = 0; i < len; i++) {
			updatePrefix[i] = ""; 
		}
	}

	/**
	 * Returns a String[] whose contents are used to retrieve the
	 * Start-of-Sentence Prefix object.
	 * <P>
	 * This Start-of-Sentence Prefix object is special in that is used to
	 * determine the first word in a dynamically generated sentence.
	 * 
	 * @return A <b>copy</b> of the prefix strings array initialized by
	 *         {@link #initializeSentenceStartArray()}
	 */
	public static String[] getStartOfSentencePrefixes() {
		return Arrays.copyOf(updatePrefix, updatePrefix.length);
	}

	/**
	 * Constructor that takes an array of prefix strings as an argument
	 * 
	 * @param prefixStrings
	 *            The array of prefix strings
	 */
	public Prefix(String[] prefixStrings) {
		// INITIALIZE PREFIX ARRAY WITH PREFIX STRINGS.
		 
		this.prefix = Arrays.copyOf(prefixStrings, prefixStrings.length);
		this.suffix = new String[0];
		
	}

	/**
	 * Returns the number of suffixes that this Prefix object contains
	 * 
	 * @return The number of suffixes of this prefix object
	 */
	public int getNumSuffixes() {
		return suffix.length;
	}

	/**
	 * Returns the number of prefixes that this Prefix object contains
	 * 
	 * @return The number of of prefix strings of this prefix object
	 */
	public int getNumPrefixes() {
		return prefix.length;
	}

	/**
	 * Returns the prefix string at a specified index.
	 * 
	 * @param index
	 *            The location of the desired prefix string
	 * @return The prefix string at this given location
	 */
	public String getPrefixString(int index) {
		return prefix[index];
	}

	/**
	 * Returns the suffix string at a specified index
	 * 
	 * @param index
	 *            The location of the desired suffix string
	 * @return The suffix string at this given location
	 */
	public String getSuffixString(int index) {
		return suffix[index];
	}

	/**
	 * Selects a random suffix from the array of suffixes. This function is
	 * integral to the sentence generation stage. It should use Math.random() to
	 * select a valid index for the array of suffixes, and then return the
	 * string at that index.
	 * <P>
	 * Warning: If the suffix array is empty (i.e. suffixes.length == 0), this
	 * method will throw an {@link ArrayIndexOutOfBoundsException}. Therefore,
	 * before calling this method, you may want to check the number of suffixes
	 * first.
	 * 
	 * @return - A random suffix string (from the suffix strings array)
	 */
	public String getRandomSuffix() {
		Random random = new Random();
		int x = random.nextInt(suffix.length);
		return suffix[x];

	}

	/**
	 * Adds a suffix string to the array of all possible suffixes that appear
	 * after this prefix. This method allows for multiple copies of the same
	 * string to be added to the array.
	 * 
	 * @param str
	 *            The string suffix (word appearing directly after this prefix)
	 */
	public void addSuffix(String str) { // what is str? is replaceSuffix ,str?
		String[] replaceSuffix = new String[suffix.length + 1];
		for (int i = 0; i < replaceSuffix.length; i++) {
			if (i == replaceSuffix.length - 1) {
				replaceSuffix[i] = str;
			} else {
				replaceSuffix[i] = this.suffix[i];
			}
		}
		this.suffix = replaceSuffix;
	}

	/**
	 * Determines equality among Prefix objects. Two Prefix objects are
	 * considered equal if they both have the exact same string prefixes in the
	 * same order.
	 * 
	 * @param obj
	 *            Object to determine equality against
	 */
	public boolean equals(Object obj) {

		if (!(obj instanceof Prefix)) {
			return false;
		}

		Prefix p = (Prefix) obj;
		for (int i = 0; i < p.prefix.length; i++) {
			if (!(this.prefix[i].equals(p.prefix[i]))) {
				return false;
			}

		}

		return true;
	}

	/*
	 * boolean equal; for (int i = 0; i < obj.length; i++) { if (obj[i] ==
	 * prefix[i] && obj.length == prefix.length) { return true; } else { return
	 * false;
	 * 
	 * } } return equal;
	 */

	/**
	 * The string form of a prefix object is its list of prefixes converted to a
	 * whitespace delimited string
	 */
	// why isn't . add working?
	public String toString() {
		/*
		 * String s = Arrays.toString(prefix); s = s.substring(1, s.length() -
		 * 1); return s;
		 */

		// white space won't show up..

		String s = new String();

		for (int i = 0; i < prefix.length; i++) {

			s = s.concat(prefix[i] + " ");
			
		}
		
		return s;
	}

}
