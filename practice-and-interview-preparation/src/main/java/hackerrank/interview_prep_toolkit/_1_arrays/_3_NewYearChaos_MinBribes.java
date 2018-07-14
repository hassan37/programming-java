package hackerrank.interview_prep_toolkit._1_arrays;

/**
 * HR > PR > IPK65 > Arr5 > 5.3 | New Year Chaos - Minimum Bribes
 * @see https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=playlist&slugs%5B%5D=interview&slugs%5B%5D=interview-preparation-kit&slugs%5B%5D=arrays
 * 
 */
public class _3_NewYearChaos_MinBribes {

	public void minimumBribes(int[] q) {
		int minimumBribes = calculateMinBribes(q);
		if (-1 == minimumBribes)
			System.out.println("Too chaotic");
		else
			System.out.println(minimumBribes);
    }

	public int calculateMinBribes(int[] a) {
		if (null == a || a.length == 0)
			return 0;

		int totalElements = a.length;
		if (0 == totalElements)
			return 0;

		int totalBribes = 0;
		for (int right = (totalElements - 1); right >= 0; right--) {
			int currentElement = a[right];
			int bribesGivenByCurrentElement = currentElement - (right + 1);
			if (bribesGivenByCurrentElement > 2)
				return -1;

			//no. of people swapped the current element upto 2 position left
			for (int left = Math.max(0, currentElement - 2); left < right; left++)
	            if (a[left] > currentElement)
	            	totalBribes++;
		}
		return totalBribes;
	}

//--------------------------- TEST CASES
	
}
