package lessons;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class TEST_PermStringReplacement {

	/**
	 * 
		You are given Strings , You need to find all possible permutations of that given string by below mentioned permutation Rules.<br />
		Permutation rules are basically replacing one string with another one: <br />
		"AB" -> "AA" <br />
		"BC" -> "CC" <br />
		"AA" -> "A" <br />
		"CC" -> "C" <br />
		Example: String s="ABBCC" and output should be "AC"
	 * 
	 * @param s
	 * @return
	 */
	public String perform(String s) {
		String r = s;
		Map<String, String> rules = new HashMap<>();
		rules.put("AB", "AA");
		rules.put("BC", "CC");
		rules.put("AA", "A");
		rules.put("CC", "C");
		boolean allToBeReplaced = true;
		while(allToBeReplaced) {
			String cr = replace(r, rules);
			if (cr.equals(r)) {
				break;
			} else {
				r = cr;
			}
		}

		return r;
	}
	
	public String replace(String s, Map<String, String> rules) {
		String r = s;
		for(Entry<String, String> e : rules.entrySet()) {
			String k = e.getKey();
			String v = e.getValue();
			if (s.contains(k)) {
				r = s.replace(k, v);
			}
		}
		return r;
	}

	@Test
	public void testStringReplacement() {
		Assert.assertEquals("AC", perform("ABBCC"));
	}

}
