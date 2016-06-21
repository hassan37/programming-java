package lessons;

import org.junit.Assert;
import org.junit.Test;

/**
 * Power of SUMS
 * Calculating MIN TAPE SECTION by subtracting the array sum from the sum of current number of elements
 * 
 * @see https://codility.com/programmers/task/tape_equilibrium/
 * 
 * @author hafiz.hassan
 *
 */
public class L3T2_TapeEquilibrium {

	public int findMinDiff(int[] A) {
		int minDif = 0;
		int len = A.length;
		int arraySum = 0;
		for (int i = 0; i < len; i++) { arraySum += A[i]; }
		
		int curSum = 0;
		for (int i = 0; i < len; i++) {
			curSum += A[i];
			arraySum -= A[i];
			int dif = Math.abs(curSum - arraySum);
			minDif = i == 0 ? dif : Math.min(minDif, dif);
		}

		return minDif;
	}

	@Test
	public void testTapeEq() {
		Assert.assertEquals(1, findMinDiff(new int[]{3,1,2,4,3}));
	}
}
