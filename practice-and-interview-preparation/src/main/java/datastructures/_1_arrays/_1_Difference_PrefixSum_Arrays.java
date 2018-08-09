package datastructures._1_arrays;

import java.util.Arrays;

/**
 * 
 * Article: https://wcipeg.com/wiki/Prefix_sum_array_and_difference_array
 *
 */
public class _1_Difference_PrefixSum_Arrays {

	public int[] getDifferenceArray(int[] A) {
		int[] D = new int[A.length-1];
		StringBuilder sb = new StringBuilder("D=[");
		for (int i = 0; i < A.length-1; i++) {
			D[i] = A[i+1] - A[i];
			sb.append(A[i+1]).append("-").append(A[i]).append("=").append(D[i]).append(", ");
		}
		System.out.println(sb.append("]").toString());

		return D;
	}
	public int[] getPrefixSumArray(int[] A, int K) {
		int[] P = new int[A.length+1];
		P[0] = K;
		for (int i = 1; i <= A.length; i++)
			P[i] = P[i-1] + A[i-1];

		return P;
	}

	public static _1_Difference_PrefixSum_Arrays inst = new _1_Difference_PrefixSum_Arrays();
	public static void main(String[] args) {
		int[] A = new int[] {9,2,6,3,1,5,0,7};
		System.out.println("A = " + Arrays.toString(A));
		System.out.println("----\nD(A) = " + Arrays.toString(inst.getDifferenceArray(A)));
		System.out.println("----\nP(-8, A) = " + Arrays.toString(inst.getPrefixSumArray(A, -8)));
		System.out.println("----\nP(0, A) = " + Arrays.toString(inst.getPrefixSumArray(A, 0)));
		
		System.out.println("----\nD(P(0, A)) = " + Arrays.toString(inst.getDifferenceArray(inst.getPrefixSumArray(A, 0))));
		System.out.println("----\nD(P(-8, A)) = " + Arrays.toString(inst.getDifferenceArray(inst.getPrefixSumArray(A, -8))));
		
		System.out.println("----\nP(0, D(A)) = " + Arrays.toString(inst.getDifferenceArray(inst.getPrefixSumArray(A, 0))));
		System.out.println("----\nP(-8, D(A)) = " + Arrays.toString(inst.getDifferenceArray(inst.getPrefixSumArray(A, -8))));
	}
}
