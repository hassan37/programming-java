package hackerrank.interview_prep_toolkit._1_arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _4_1_MinimumSwapsOfConsecutiveArray {

	public int minimumSwaps(int[] arr) {
		int len = arr.length;
		if (len < 2) return 0;

		int minimumSwaps = 0;
		int ind = 0;
		while (ind < len) {
			if (arr[ind] == (ind+1)) {
				ind++;
				continue;
			}
			swap(arr, ind, (arr[ind]-1));
			minimumSwaps++;
		}

		return minimumSwaps;
    }
	public void swap(int[] arr, int leftIndex, int rightIndex) {
		int temp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = temp;
	}

//------------------------------------------------------ TEST CASES

	public static final _4_1_MinimumSwapsOfConsecutiveArray inst = new _4_1_MinimumSwapsOfConsecutiveArray();

	@Test
	public void testTheSwappingOf2ElementsInArray() {
		int[] arr = new int[] {5,6,7,8};
		inst.swap(arr, 0, 3);
		assertArrayEquals(new int[] {8,6,7,5}, arr);
		inst.swap(arr, 0, 3);
		assertArrayEquals(new int[] {5,6,7,8}, arr);
		inst.swap(arr, 1, 2);
		assertArrayEquals(new int[] {5,7,6,8}, arr);
	}
	@Test
	public void should_returnZero_when_ArrayAlreadySorted() {
		assertEquals(0, inst.minimumSwaps(new int[] 
				{1}
			));
		assertEquals(0, inst.minimumSwaps(new int[] 
				{-999}
			));

		assertEquals(0, inst.minimumSwaps(new int[] 
			{1,2,3,4,5,6,7,8,9,10}
		));
	}
	@Test
	public void testHackerRankSamples() {
		assertEquals(5, inst.minimumSwaps(new int[] 
				{7, 1, 3, 2, 4, 5, 6}));
		assertEquals(3, inst.minimumSwaps(new int[] 
				{4, 3, 1, 2}));
		assertEquals(3, inst.minimumSwaps(new int[] 
				{2, 3, 4, 1, 5}));
		assertEquals(3, inst.minimumSwaps(new int[] 
				{1, 3, 5, 2, 4, 6, 7}));
	}

}
