package SearchingSorting;

public class Searching {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };

		System.out.println(jumpSearch(arr, 4));

	}

	// FOR SORTED ARRAYS.
	public static int binarySearch(int[] arr, int k) {
		int left = 0, right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (k == arr[mid]) {
				return mid;
			} else if (k < arr[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return -1;

	}

	public static int jumpSearch(int[] arr, int k) {
		int step = (int) Math.sqrt(arr.length);

		int initStep = 0;

		while (arr[initStep + step] < k && (initStep + step) < arr.length - 1) {
			initStep += step;
		}

		int n = step;
		while (n >= 0) {
			if (arr[initStep] == k) {
				return initStep;
			}

			initStep++;
			n--;
		}
		return -1;
	}

}
