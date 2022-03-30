package interview.leetCode.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class TwoSum {

	public static void main(String[] args) {
		var a = twoSum(new int[] {3,2,4}, 6);
		System.out.println(a[0] + "-" + a[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
		if (2 == nums.length)
			return new int[] { 0, 1 };

		Map<Integer, Integer> e = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			e.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int e2 = target - nums[i];
			if (e.containsKey(e2) && i != e.get(e2))
				return new int[] {i, e.get(e2)};
		}

		return null;
	}
}
