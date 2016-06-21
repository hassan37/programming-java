package sorting;

public class InsertionSort {

	public static void insertionSort(char[] arr) {
		if (null != arr && arr.length > 1) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = i+1; j > 0 && arr[j-1] > arr[j]; j--) {
					if (arr[i] > arr[j]) {
						char temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
	}
}
