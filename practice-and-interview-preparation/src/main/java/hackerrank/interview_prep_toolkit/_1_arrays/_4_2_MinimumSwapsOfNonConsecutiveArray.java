package hackerrank.interview_prep_toolkit._1_arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 * Minimum Swaps to sort an unsorted array of n elements
 * 1 <= n <= 100000
 * @author C.HafizHassan
 *
 */
public class _4_2_MinimumSwapsOfNonConsecutiveArray {
	
	public int minimumSwaps(int[] arr) {
		if (arr.length < 2) return 0;
		int[] sortedArr = getSortedArray(arr);
		Map<Integer, Integer> elementsByIndexes = getElementsByPositions(sortedArr);

		return calculateMinSwaps(arr, sortedArr, elementsByIndexes);
	}
	public int[] getSortedArray(int[] arr) {
		int[] clonedArray = Arrays.copyOf(arr, arr.length);
		Arrays.sort(clonedArray);

		return clonedArray;
	}
	public Map<Integer, Integer> getElementsByPositions(int[] sortedArr) {
		Map<Integer, Integer> elementsPositions = new HashMap<>(sortedArr.length);
		for (int i = 0; i < sortedArr.length; i++)
			elementsPositions.put(sortedArr[i], i);

		return elementsPositions;
	}
	public void swap(int[] arr, int leftIndex, int rightIndex) {
		int temp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = temp;
	}

	/*
| 3 2 0 1 |                 | 1 2 0 3 |                 | 0 2 1 3 |                 | 0 1 2 3 |
| ------- |                 | ------- |                 | ------- |                 | ------- |
| 4 3 1 2 | swap(arr, 0, 3) | 2 3 1 4 | swap(arr, 0, 2) | 1 3 2 4 | swap(arr, 1, 2) | 1 2 3 4 |
| ------- |                 | ------- |                 | ------- |                 | ------- |
| 0 1 2 3 |                 | 0 1 2 3 |                 | 0 1 2 3 |                 | 0 1 2 3 |
| ------- |                 | ------- |                 | ------- |                 | ------- |
	 */
	public int calculateMinSwaps(int[] arr, int[] sortedArr, Map<Integer, Integer> elementsByIndexes) {
		int swaps = 0;
		int curInd = 0;
		while (curInd < sortedArr.length) {
			int curElement = arr[curInd];
			if (curElement == sortedArr[curInd]) {
				curInd++;
				continue;
			}

			swap(arr, curInd, elementsByIndexes.get(curElement));
			swaps++;
		}

		return swaps;
	}

//	---------------------------------------------------------------------
	
	public static final _4_2_MinimumSwapsOfNonConsecutiveArray inst = new _4_2_MinimumSwapsOfNonConsecutiveArray();

	@Test
	public void should_returnNewSortedArray_when_ArrayUnsorted() {
		int[] unsortedArray = new int[] {4, 3, 2, 1};
		int[] expectedSortedArray = new int[] {1,2,3,4};
		int[] sortedArray = inst.getSortedArray(unsortedArray);

		assertNotEquals(expectedSortedArray, sortedArray);
		assertArrayEquals(expectedSortedArray, sortedArray);
	}
	@Test
	public void testElementsByPositionMap() {
		Map<Integer, Integer> ep = new HashMap<>();
		int[] arr = new int[] {5,6,7,8};
		for (int i = 0; i < arr.length; i++) {
			ep.put(arr[i], i);
		}
		Map<Integer, Integer> res = inst.getElementsByPositions(arr);

		assertEquals(ep.get(5), res.get(5));
		assertEquals(ep.get(8), res.get(8));
		assertEquals(ep.get(7), res.get(7));
	}
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
				{1, 3, 5, 2, 4, 6, 8}));
	}

}
