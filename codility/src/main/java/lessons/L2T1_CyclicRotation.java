package lessons;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Calculating Indices by using REMAINDER OPERATOR. Like Clock 
 * 
 * @see https://codility.com/programmers/task/cyclic_rotation/
 * 
 * @author hafiz.hassan
 *
 */
public class L2T1_CyclicRotation {
	
	public int[] perform(int[] A, int k) {
		int[] res = null;
		int len = A.length;
		if (len <= 1 || (k % len) == 0) {
			res = A;
		} else {
			res = new int[len];
			for (int i = 0; i < len; i++) {
				res[(i+k)%len] = A[i];
			}
		}

		return res;
	}
	
	@Test
	public void testCyclicRotation() {
		Assert.assertArrayEquals(new int[]{1}, perform(new int[]{1}, 500));
		Assert.assertArrayEquals(new int[]{9,8,7}, perform(new int[]{9,8,7}, 33));
		Assert.assertArrayEquals(new int[]{7,9,8}, perform(new int[]{9,8,7}, 1));
		Assert.assertArrayEquals(new int[]{300,400,500,100,200,}, perform(new int[]{100,200,300,400,500}, 3));
	}
}
