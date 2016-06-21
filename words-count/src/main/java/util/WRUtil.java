package util;

import java.util.regex.Pattern;

public abstract class WRUtil {

	public static void print(final String msg) {
		System.out.println(msg);
	}

	public static boolean isNullOrEmptyStr(final String str) {
		boolean nullOrEmptyStr = false;

		if (null == str || str.length() == 0) {
			nullOrEmptyStr = true;
		}

		return nullOrEmptyStr;
	}


	/**
	 * Qualified Word can be <br>
	 * <li>Numeric</li>
	 * <li>Alphabets</li>
	 * <li>AlphaNumeric</li>
	 * <li>An apostrophe word</li>
	 *
	 * @param word to be qualified
	 * @return whether the provided word is qualified word according to the requirement or not
	 * @since Oct 18, 2013
	 */
	public static boolean isThisAQualifiedWord(final String word) {
		boolean isQualifiedWord = false;
		if (Pattern.matches(WRConstants.NUM_REGEX, word) ||
				Pattern.matches(WRConstants.ALPHA_REGEX, word) ||
				Pattern.matches(WRConstants.ALPHA_NUM_REGEX, word) ||
				Pattern.matches(WRConstants.APOSTROPHE_WORD_REGEX, word)) {
			isQualifiedWord = true;
		}

		return isQualifiedWord;
	}

	public static String prepareQualifiedWordValue(String value) {
		String resultStr = value;

		if (!WRUtil.isNullOrEmptyStr(resultStr)) {
			resultStr = resultStr.trim();
			resultStr = resultStr.toLowerCase();
			resultStr = resultStr.contains("'s") ? resultStr.replace("'s", "") : resultStr;
		}

		return resultStr;

	}

}
