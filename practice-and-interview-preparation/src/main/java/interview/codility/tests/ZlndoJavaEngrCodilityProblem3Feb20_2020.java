package interview.codility.tests;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Test to Sara
 * {@link} https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
 * @author hassan.muhammad
 *
 */
public class ZlndoJavaEngrCodilityProblem3Feb20_2020 {

    public static void main(String[] args) {
    	ZlndoJavaEngrCodilityProblem3Feb20_2020 s = new ZlndoJavaEngrCodilityProblem3Feb20_2020();
		System.out.println(s.solution(new int[] {2,-2,3,0,4,-7}));
		System.out.println(s.solution(new int[] {1}));
		System.out.println(s.solution(new int[] {0}));
		System.out.println(s.solution(new int[] {1, 0, -1}));
	}

	public static class SubArray {
		public final int left;
		public final int right;
		public SubArray(int left, int right) {
			this.left = left;
			this.right = right;
		}
		@Override
		public String toString() {
			return "l=" + left + ":r=" + right;
		}
		
	}

	public int solution(int[] A) {
		// write your code in Java SE 8
		if (null == A || A.length == 0 || A.length >= 10000)
			return -1;

		Map<Integer, List<Integer>> sumIndices = new LinkedHashMap<>();
		List<SubArray> zeroSumSubArrays = new LinkedList<>();

		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];

			if (0 == sum)
				zeroSumSubArrays.add(new SubArray(0, i));


			List<Integer> subArr;

			if (sumIndices.containsKey(sum)) {
				subArr = sumIndices.get(sum);
				for (int j = 0; j < subArr.size(); j++)
					zeroSumSubArrays.add(new SubArray(subArr.get(j) + 1, i));
			} else {
				subArr = new LinkedList<>();
			}

			subArr.add(i);
			sumIndices.put(sum, subArr);
		}

		System.out.println(zeroSumSubArrays);
		return zeroSumSubArrays.size();
	}

}
