package de.wbbcoder.jsuba.util;

public class StringUtil {

	/**
	 * Returns if a string is empty. A string is empty when it is NULL, or
	 * contains whitespaces only.
	 * 
	 * @param string
	 * @return boolean
	 */
	public static boolean isEmpty(String string) {
		return (string == null || string.trim().length() == 0);
	}

	public static String castToString(Object o) {
		return String.valueOf(o);
	}
}
