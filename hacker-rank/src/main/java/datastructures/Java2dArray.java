package datastructures;

import java.util.Scanner;

/**
 * Created by hassan on 28/05/2016.
 * @see https://www.hackerrank.com/challenges/2d-array
 *
 */
public class Java2dArray {

	static Java2dArray getInstance() { return new Java2dArray(); }

	public static void main(String[] args) {
		Java2dArray j2a = getInstance();
		int[][] j2dArr = j2a.get2DArrayFromUser();
		int maxSum = j2a.findMaxSumHourGlass(j2dArr);
		System.out.println(maxSum);
	}

	private int findMaxSumHourGlass(int[][] j2dArr) {
		int maxSum = 0;
		int len = j2dArr.length;
		for (int row=0; row < len-2; row++) {
			for(int col = 0; col < j2dArr[row].length - 2; col++) {
				int sum =
						j2dArr[row][col] + j2dArr[row][col + 1] + j2dArr[row][col + 2] +
								j2dArr[row + 1][col + 1] +
						j2dArr[row + 2][col] + j2dArr[row + 2][col + 1] + j2dArr[row + 2][col+ 2];
				maxSum = (row == 0 && col == 0) ? sum : Math.max(maxSum, sum);
			}
		}

		return maxSum;
	}

	private int[][] get2DArrayFromUser() {
		int[][] j2dArr = new int[6][6];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				j2dArr[i][j] = sc.nextInt();
			}
		}
		sc.close();

		return j2dArr;
	}
}
