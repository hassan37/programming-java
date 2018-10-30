package interview.codility.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.junit.Test;

public class StringToUpperCaseWithStreams {

	//@Test
	public void should_returnNullOrEmptyStr_when_StrIsNullOrEmpty() {
		assertEquals(null, convert(null));
		assertEquals("", convert(""));
	}

	//@Test
	public void single3LetterWordShouldBeConvertedToUpperCase() {
		assertEquals("ABC", convert("abc"));
	}

	@Test
	public void singleSentenceWithMixWordsShouldBeConvertedToUpperCase() {
		assertEquals("this IS beautiful CAT", convert("this is beautiful cat"));
	}

	public String convert(String str) {
		if (null == str || "" == str)
			return str;

		final String SPACE = " ";

		final Pattern pattern = Pattern.compile(SPACE);
		List<String> convertedWords = pattern.splitAsStream(str)
			.map(this::applyConversion)
			.collect(Collectors.toList());

		return String.join(SPACE, convertedWords);
	}

	private String applyConversion(final String s) {
		if (s.length() > 3)
			return s;
	
		return s.toUpperCase();
	}
}
