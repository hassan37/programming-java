package interview.codility.lessons.iterations;

/**
 * 1. Bitwise Shift Operator to drop bits
 * 2. Bitwise AND Operator to check for 1 or 0
 * 
 * @see https://codility.com/programmers/task/binary_gap/
 * @author hafiz.hassan
 *
 */
public class L1T1_BinaryGap {

	public int solution(int N) {
		// write your code in Java SE 8
		return getByBitManipulation(N);
	}

	public int getByLoopOnCharArr(int N) {
		int maxBinGap = 0;
		String binStr = Integer.toBinaryString(N);
		char[] binArr = binStr.toCharArray();
		int binGap = 0;
		for (int i = 0; i < binArr.length; i++) {
			if (binArr[i] == '0') {
				binGap++;
			} else {
				maxBinGap = Math.max(binGap, maxBinGap);
				binGap = 0;
			}
		}

		return maxBinGap;
	}

	public int getByBitManipulation(int N) {
		int maxBinGap = 0;
		int binGap = 0;
		
		while (N > 0 && 0 == (N & 1)) {
			N >>= 1;
		}
		
		while (N > 0) {
			if (1 == (N & 1)) {
				maxBinGap = Math.max(maxBinGap, binGap);
				binGap = 0;
			} else {
				binGap++;
			}
			N >>= 1;
		}

		return maxBinGap;
	}

	public static void main(String[] args) {
		L1T1_BinaryGap bg = new L1T1_BinaryGap();
		
//----------------------------- Looping on Char Array --------------------

		long startTime = System.nanoTime();
		for (int i = 1610612900; i <= 1610612999; i++) {
			bg.getByLoopOnCharArr(i);
		}
		long endTime = System.nanoTime();
		System.out.println("Loop Char Array Total time in nanoSec: " + (endTime - startTime));		
		
//----------------------------- Looping on Bit Manipulation --------------------
		
		startTime = System.nanoTime();
		for (int i = 1610612900; i <= 1610612999; i++) {
			bg.getByBitManipulation(i);
		}
		endTime = System.nanoTime();
		System.out.println("Bit Manipulation Total time in nanoSec: " + (endTime - startTime));		
	}


}
