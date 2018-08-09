package hackerrank.interview_prep_toolkit._1_arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *************************************************************
 * HR > PR > IPK65 > Arr5 > 5.5 | Array Manipulation
 *************************************************************
 * http://hr.gs/deabde
 *************************************************************
 * queries - a two dimensional array of queries where each 
 *	queries[i] contains three integers, a, b, and k.
 *
 * n - the number of elements in your array | 3 <= n <= 10^7
 * 'a' = start-index			| 1 <= a <= 9
 * 'b' = end-index				| a <= b <= n
 * 'k' = number to be added		| 0 <= k <= 10*9
 *************************************************************
 * Sample:
 * when n = 10:
 * queries:
 *  a b k
	-----
    1 5 3
    4 8 7
    6 9 1
	-----
 * the array will be:
 *   0	1 2 3  4  5 6 7 8 9 10
	[0, 0,0,0, 0, 0,0,0,0,0, 0]
	[0, 3,3,3, 3, 3,0,0,0,0, 0]
	[0, 3,3,3,10,10,7,7,7,0, 0]
	[0, 3,3,3,10,10,8,8,8,1, 0]
 *************************************************************
 */
public class _5_ArrayManipulation_MaxSum {

	public long arrayManipulation(int n, int[][] queries) {
		long prefixSum =0, maxSum = 0;
		long[] ranges = new long[n+1];
		for (int i = 0; i < queries.length; i++) {
			int a = queries[i][0];
			int b = queries[i][1];
			int k = queries[i][2];

			ranges[a] += k;
			if((b + 1) <= n)
				ranges[b + 1] -= k;
		}
		for (int i = 1; i <= n; i++) {
			prefixSum += ranges[i];
			maxSum = Math.max(maxSum, prefixSum);
		}

		return maxSum;
	}
	public long arrayManipulationByN_2(int n, int[][] queries) {
		long maxSum = 0;
		long[] sums = new long[n];
		for (int i = 0; i < queries.length; i++) {
			int a = queries[i][0];
			int b = queries[i][1];
			int k = queries[i][2];

			for (int j = a-1; j < b; j++) {
				sums[j] = sums[j] + k;
				maxSum = Math.max(maxSum, sums[j]);
			}
		}

		return maxSum;
	}

/****************************UNIT***TEST***CASES**************/

	public static _5_ArrayManipulation_MaxSum am = new _5_ArrayManipulation_MaxSum();

	@Test
	@SuppressWarnings("unused")
	public void testHackerRankSamples() {
		int n = 5, a, b, k = 0;
		assertEquals(200, am.arrayManipulation(n, new int[][] {
			 {a = 1, b = 2, k = 100}
			,{a = 2, b = 5, k = 100}
			,{a = 3, b = 4, k = 100}
			}));

		n = 10;
		assertEquals(10, am.arrayManipulation(n, new int[][] {
			 {a = 1, b = 5, k = 3}
			,{a = 4, b = 8, k = 7}
			,{a = 6, b = 9, k = 1}
			}));
		n = 10;
		assertEquals(10, am.arrayManipulation(n, new int[][] {
			 {a = 1, b = 5, k = 3}
			,{a = 4, b = 8, k = 7}
			,{a = 6, b = 9, k = 1}
			}));
	}
	@Test
	@SuppressWarnings("unused")
	public void testMaxSumOn10Elements() {
		int n = 10, a, b, k = 0;
		assertEquals(2, am.arrayManipulation(n, new int[][] {
			 {a = 1, b = 2, k = 2}
			}));

		assertEquals(5, am.arrayManipulation(n, new int[][] {
			 {a = 1, b = 2, k = 2}
			,{a = 6, b = 7, k = 5}
			}));
		assertEquals(9, am.arrayManipulation(n, new int[][] {
			 {a = 1, b = 2, k = 2}
			,{a = 6, b = 7, k = 5}
			,{a = 9, b = 10, k = 9}
			}));
		assertEquals(9, am.arrayManipulation(n, new int[][] {
			 {a = 1, b = 2, k = 9}
			,{a = 6, b = 7, k = 5}
			,{a = 9, b = 10, k = 2}
			}));
	}
	@Test
	@SuppressWarnings("unused")
	public void testMaxSumOf3ElementsN3And2Queries() {
		int n = 3, a, b, k = 0;
		assertEquals(30, am.arrayManipulation(n, new int[][] {
			 {a = 1, b = n, k = 10}
			,{a = 2, b = n, k = 20}
			}));
		assertEquals(50, am.arrayManipulation(n, new int[][] {
			 {a = 1, b = n, k = 10}
			,{a = n, b = n, k = 40}
			}));
	}
	@Test
	public void testMaxSumOf3ElementsN3And1Query() {
		int n = 3;
		int k = 10;
		assertEquals(k, am.arrayManipulation(n, new int[][] {
			{1,n,k}
			}));
		assertEquals(k, am.arrayManipulation(n, new int[][] {
			{2,n,k}
			}));
		assertEquals(k, am.arrayManipulation(n, new int[][] {
			{n,n,k}
			}));
		
		k = 0;
		assertEquals(k, am.arrayManipulation(n, new int[][] {
			{1,n,k}
			}));
		assertEquals(k, am.arrayManipulation(n, new int[][] {
			{2,n,k}
			}));
		assertEquals(k, am.arrayManipulation(n, new int[][] {
			{n,n,k}
			}));
	}
}
