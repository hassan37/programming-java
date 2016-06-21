package challenges;

public final class SparseNumber {

	private static final String REGEX = "(\\d*)([1]{2}+)(\\d*)";

	public boolean byBruteForce;

	public static SparseNumber getInstance() {
		return new SparseNumber();
	}

	public int next(int n) {
		int next = -1;
		if (byBruteForce) {
			next = byBruteForce(n);
		} else {

		}

		return next;
	}

	private int byBruteForce(int n) {
		int next = -1;
		while(n < Integer.MAX_VALUE) {
			if (isSparse(++n)) {
				next = n;
				break;
			}
		}

		return next;
	}

	public boolean isSparse(int n) {
		String binaryN = Integer.toBinaryString(n);
		return !binaryN.matches(REGEX);
	}

	public static void main(String[] args) {
		SparseNumber sn = getInstance();
		sn.byBruteForce = true;
		System.out.println("By brute force");
		System.out.println(sn.next(99999995));
	}

}