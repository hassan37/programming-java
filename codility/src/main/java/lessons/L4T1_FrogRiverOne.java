package lessons;

/**
 * COUNTING PROBLEM
 * USING another boolean array to keep track of positions where leaves have appeared
 * 
 * time complexity = O(N);
 * space complexity = O(X)
 * 
 * @see https://codility.com/programmers/task/frog_river_one/
 * 
 * @author hafiz.hassan
 *
 */
public class L4T1_FrogRiverOne {

	public int findEarliestTime(int[] A, int X) {
		int et = -1;
		boolean[] leavesAppeared = new boolean[X+1];
		int numOfLeavesToBeAppeared = X;
		for (int k = 0; k < A.length; k++) {
			
			if (!leavesAppeared[A[k]]) {
				leavesAppeared[A[k]] = true;
				numOfLeavesToBeAppeared--;
				if (numOfLeavesToBeAppeared == 0) {
					et = k;
					break;
				}
			}
		}
		
		return et;
	}
}
