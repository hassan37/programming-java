package interview.codility.lessons.countingelements;

import java.util.HashSet;
import java.util.Set;

/**
 * Store numbers in Set
 * and Looping from 1 until we find first minimum missing integer
 * 
 * time complexity = O(N)
 * space complexity = O(N)
 * 
 * @see https://codility.com/programmers/task/missing_integer/
 * @see https://codility.com/demo/results/training6PKKBG-4N4/
 * 
 * @author hafiz.hassan
 *
 */
public class L4T3_MissingInteger {
	
	public int find(int[] A) {
		int r = 0;
		Set<Integer> nums = new HashSet<>();
		for (int a : A) {
			nums.add(a);
		}

		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			if (!nums.contains(i)) {
				r = i;
				break;
			}
		}

		return r;
	}

}
