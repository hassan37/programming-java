package datastructures;

import java.util.Scanner;

/**
 * Created by hassan on 28/05/2016.
 * @see https://www.hackerrank.com/challenges/arrays-ds
 */
public class ArraysDS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		long[] arr = new long[size];

		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextLong();
		}

		StringBuilder sb = new StringBuilder("");

		for(int i = size-1; i >= 0; i--) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
