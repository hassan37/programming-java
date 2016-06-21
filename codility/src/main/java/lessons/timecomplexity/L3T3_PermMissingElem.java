package lessons.timecomplexity;

import org.junit.Assert;
import org.junit.Test;

/**
 * POWER OF SUM
 * SUM of finite SERIES of N Elements used
 * using the formula; we have found the MISSING ELEMENT
 * 
 * @see https://codility.com/programmers/task/perm_missing_elem/
 * 
 * @author hafiz.hassan
 *
 */
public class L3T3_PermMissingElem {
	
	public int find(int[] A) {
		int n = A.length;
		long seriesSum = ((n+1l) * (n+2l)) / 2;
		for (int i = 0; i < n; i++) {
			seriesSum -= A[i];
		}
		
		return (int) seriesSum;
	}
	
	@Test
	public void testFindingMissingElement() {
		Assert.assertEquals(4, find(new int[]{2,5,3,1}));
	}
}
