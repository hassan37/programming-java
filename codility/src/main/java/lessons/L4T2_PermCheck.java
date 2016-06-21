package lessons;

import org.junit.Assert;
import org.junit.Test;

/**
 * Visiting Elements Tracking by another array
 * 
 * 
 * time complexity = O(N)
 * space complexity = O(N)
 * 
 * @see https://codility.com/programmers/task/perm_check/
 * @see https://codility.com/demo/results/trainingDRAKVQ-BYU/
 * 
 * @author hafiz.hassan
 *
 */
public class L4T2_PermCheck {

	public int verify(int[] A) {
		int n = A.length;
		boolean[] visitedElements = new boolean[n];

		for (int a : A) {
			if (a > n || visitedElements[a-1]) {
				return 0;
			} else {
				visitedElements[a-1] = true;
			}
		}

		return 1;
	}
	
	@Test
	public void testPermCheck() {
		
		Assert.assertEquals(1, verify(new int[]{10,9,8,7,6,5,4,3,2,1}));
		Assert.assertEquals(0, verify(new int[]{2,3}));
	}
}
