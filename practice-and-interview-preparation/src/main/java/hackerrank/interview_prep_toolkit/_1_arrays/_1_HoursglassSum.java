package hackerrank.interview_prep_toolkit._1_arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _1_HoursglassSum {

	// Complete the hourglassSum function below.
	public int hourglassSum(int[][] arr) {
		int sum = Integer.MIN_VALUE;
		int size = arr.length;
		int max_row = size - 2;
		int max_col = max_row;

		for (int i = 0; i < max_row; i++) {
			for (int j = 0; j < max_col; j++) {
				int hgs = 
					  arr[i][j] +	arr[i][j+1]		+ arr[i][j+2]
					+ 				arr[i+1][j+1]
					+ arr[i+2][j] + arr[i+2][j+1]	+ arr[i+2][j+2];
				
				sum = Math.max(sum, hgs);
			}
		}

		return sum;
	}

	@Test
	public void testZeroSum() {
		int[][] arr = 
		{
			 {0,   0,   0,   0,   0,   0}
			,{0,   0,   0,   0,   0,   0}
			,{0,   0,   0,   0,   0,   0}
			,{0,   0,   0,   0,   0,   0}
			,{0,   0,   0,   0,   0,   0}
			,{0,   0,   0,   0,   0,   0}
		};

		_1_HoursglassSum app = new _1_HoursglassSum();
		assertEquals(0, app.hourglassSum(arr));
	}

	@Test
	public void testEndCornerSum() {
		int[][] arr = 
		{
			 {0,   0,   0,   0,   0,   0}
			,{0,   0,   0,   0,   0,   0}
			,{0,   0,   0,   0,   0,   0}
			,{0,   0,   0,   0,   0,   0}
			,{0,   0,   0,   0,   0,   0}
			,{0,   0,   0,   0,   0,   1}
		};

		_1_HoursglassSum app = new _1_HoursglassSum();
		assertEquals(1, app.hourglassSum(arr));
	}

	@Test
	public void testSumOf4SameGlassHoursEqualsTo7() {
		int[][] arr = 
		{
			 {0,   0,   0,   0,   0,   0}
			,{0,   0,   0,   0,   0,   0}
			,{1,   1,   1,   1,   1,   1}
			,{0,   1,   0,   0,   1,   0}
			,{1,   1,   1,   1,   1,   1}
			,{0,   0,   0,   0,   0,   0}
		};

		_1_HoursglassSum app = new _1_HoursglassSum();
		assertEquals(7, app.hourglassSum(arr));
	}
	@Test
	public void testSumOf1MaxHourGlassIn4GlassHoursEqualsToMax() {
		int[][] arr = 
		{
			 {0,   0,   0,   0,   0,   0}
			,{0,   0,   0,   0,   0,   0}
			,{1,   1,   1,   1,   1,   1}
			,{0,  24,   0,   0, -24,   0}
			,{1,   1,   1,   1,   1,   1}
			,{0,   0,   0,   0,   0,   0}
		};

		_1_HoursglassSum app = new _1_HoursglassSum();
		assertEquals(30, app.hourglassSum(arr));
	}

//----------------------------------------------------------------------------

}
