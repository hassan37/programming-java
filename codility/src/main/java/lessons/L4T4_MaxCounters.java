package lessons;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * time complexity = O(N+M)
 * space complexity is O(N)
 * 
 * @see https://codility.com/programmers/task/max_counters/
 * 
 * @author hafiz.hassan
 *
 */
public class L4T4_MaxCounters {

	/**
	 * NOT 100%
	 * Time Complexity = O (N*M)
	 * 
	 * @see https://codility.com/demo/results/trainingHJEF9G-DP2/
	 * 
	 * @param N
	 * @param A
	 * @return
	 */
	public int[] findSlow(int N, int[] A) {
		int[] r = new int[N];
		int max = 0;
		for (int a : A) {
			if (a <= N) {
				
				r[a-1]++;
				max = Math.max(max, r[a-1]);
			} else {
				for (int i = 0; i < N; i++) {
					r[i] = max;
				}
			}
		}
		
		return r;
	}
	
	/**
	 * 100%
	 * Time Complexity = O (N+M)
	 * 
	 * @see https://codility.com/demo/results/trainingXT7QEM-PCR/
	 * 
	 * @param N
	 * @param A
	 * @return
	 */
	public int[] find(int N, int[] A) {
		int[] counters = new int[N];
		int max = 0;
		int prevMax = 0;
		for (int a : A) {
			
			if (a <= N) {
				int counterIndex = a-1;
				counters[counterIndex] = Math.max(prevMax, counters[counterIndex]);
				counters[counterIndex]++;
				max = Math.max(max, counters[counterIndex]);
			} else {
				prevMax = max;
			}
		}

		for (int i = 0; i < N; i++) {
			counters[i] = Math.max(prevMax, counters[i]);
		}
		
		return counters;
	}
	
	
	@Test
	public void testFindMaxCounters() {
		Assert.assertArrayEquals(new int[]{3,2,2,4,2}, find(5, new int[]{3,4,4,6,1,4,4}));
	}
}
