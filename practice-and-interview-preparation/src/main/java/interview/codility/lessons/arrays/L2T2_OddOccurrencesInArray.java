package interview.codility.lessons.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * XOR magic to extract odd occurrence of an element
 * 
 * @see https://codility.com/programmers/task/odd_occurrences_in_array/
 * 
 * @author hafiz.hassan
 *
 */
public class L2T2_OddOccurrencesInArray {

	public int find(int[] A) {
		int unpaired = 0;
		for (int i = 0; i < A.length; i++) {
			unpaired ^= A[i];
		}

		return unpaired;
	}

	@Test
	public void testOddOccurencesInArray() {
		//[9, 3, 9, 3, 9, 7, 9]
		Assert.assertEquals(7, find(new int[]{9, 3, 9, 3, 9, 7, 9}));
		Assert.assertEquals(3, find(new int[]{1,2,3,2,1}));
		Assert.assertEquals(99, find(new int[]{95,96,97,98,98,97,96,95,99}));
	}

}
