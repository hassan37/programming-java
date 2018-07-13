package hackerrank.interview_prep_toolkit._1_arrays;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class _2_RightRotation {

	public int[] rotLeft(int[] a, int d) {
		if (null == a)
			return a;

		int totalElements = a.length;
		if (0 == totalElements)
			return a;

		int rotations = d % totalElements;
		if (rotations == 0)
			return a;

		int[] r = new int[totalElements];
		for (int i = 0; i < totalElements; i++) {
			int e = a[i];
			int eIndex = (i + d) % totalElements;

			r[eIndex] = e;
		}

		return r;
    }

//---------------------------------------------------  TEST CASES ---
// 1. Should_ExpectedBehavior_When_StateUnderTest
// 2. Feature to be tested (recommended)

	@Test
	public void should_returnNullArray_When_NullArrayPassed() {
		final int[] nullArr = null;
		_2_RightRotation lr = new _2_RightRotation();

		assertArrayEquals(nullArr, lr.rotLeft(nullArr, 5));
	}
	@Test
	public void should_returnEmptyArray_When_EmptyArrayPassed() {
		_2_RightRotation lr = new _2_RightRotation();
		final int[] emptyArr = new int[0];

		assertArrayEquals(emptyArr, lr.rotLeft(emptyArr, 5));
	}
	@Test
	public void should_returnSameArray_when_noOfRotationsAreMultipleOfTotalElements() {
		_2_RightRotation lr = new _2_RightRotation();
		final int[] arr = {3,2,1};

		assertArrayEquals(arr, lr.rotLeft(arr, 3));
		assertArrayEquals(arr, lr.rotLeft(arr, 6));
		assertArrayEquals(arr, lr.rotLeft(arr, 900));
	}
	@Test
	public void withinRangeLeftRotationsOnElements() {
		_2_RightRotation lr = new _2_RightRotation();
		final int[] arr = {1,2,3,4,5};

		assertArrayEquals(new int[] {5,1,2,3,4}, lr.rotLeft(arr, 1));
		assertArrayEquals(new int[] {4,5,1,2,3}, lr.rotLeft(arr, 2));
		assertArrayEquals(new int[] {3,4,5,1,2}, lr.rotLeft(arr, 3));
		assertArrayEquals(new int[] {2,3,4,5,1}, lr.rotLeft(arr, 4));
		assertArrayEquals(new int[] {1,2,3,4,5}, lr.rotLeft(arr, 5));
	}
	@Test
	public void outOfRangeLeftRotationsOnElements() {
		_2_RightRotation lr = new _2_RightRotation();
		final int[] arr = {1,2,3,4,5};

		assertArrayEquals(new int[] {5,1,2,3,4}, lr.rotLeft(arr, 1000001));
		assertArrayEquals(new int[] {4,5,1,2,3}, lr.rotLeft(arr, 2000002));
		assertArrayEquals(new int[] {3,4,5,1,2}, lr.rotLeft(arr, 3000003));
		assertArrayEquals(new int[] {2,3,4,5,1}, lr.rotLeft(arr, 4000004));
		assertArrayEquals(new int[] {1,2,3,4,5}, lr.rotLeft(arr, 5000005));
	}
}
