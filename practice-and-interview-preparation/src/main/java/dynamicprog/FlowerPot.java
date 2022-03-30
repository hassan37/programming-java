package dynamicprog;

public class FlowerPot {

	public static void main(String[] args) {
//		System.out.println(maxHeight(new int[] {3,10,3,1,2}));
		System.out.println(maxHeight(new int[] {9,10,9}));
	}
	static int maxHeight(int[] fpots) {
		int a = 0; // f(i - 2)
		int b = 0; // f(i - 1)
		for (int i = fpots.length-1; i > -1; i--) {
			int newVal = a + fpots[i];
			a = b;
			b = Math.max(newVal, b);

			System.out.println("fpots[i]=" + fpots[i] + " | a=" + a + " | b=" + b);
		}

		return b;
	}
}
