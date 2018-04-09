import java.util.Arrays;
import java.util.Scanner;

public class dareToCompete {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		//
		int n = scn.nextInt();
		//
		// int[][] arr = new int[n][n];
		//
		// for (int i = 0; i < arr.length; i++) {
		// for (int j = 0; j < arr.length; j++) {
		// arr[i][j] = scn.nextInt();
		// }
		// }
		// // new int[][] { { -1, 0, 0 }, { 0, -1, 1 }, { 0, 2, -1 } }
		// carsCollide(arr);

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		disappointed(arr);
	}

	public static void carsCollide(int[][] arr) {
		boolean[] boolArr = new boolean[arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == -1) {
					continue;
				} else if (arr[i][j] == 0) {
					continue;
				} else if (arr[i][j] == 1) {
					boolArr[i] = true;
				} else if (arr[i][j] == 2) {
					boolArr[j] = true;
				} else if (arr[i][j] == 3) {
					boolArr[i] = true;
					boolArr[j] = true;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < boolArr.length; i++) {
			if (!boolArr[i]) {
				count += 1;
			}
		}
		System.out.println(count);
		for (int i = 0; i < boolArr.length; i++) {
			if (!boolArr[i]) {
				System.out.print((i + 1) + " ");
			}
		}
	}

	public static void disappointed(int[] arr) {
		Arrays.sort(arr);
		int count = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (sum <= arr[i]) {
				count++;
			}
			sum += arr[i];

		}
		System.out.println(count);
	}

	private static class treeCutClass {
		int x;
		int h;
		String LR;

		public treeCutClass(int x, int h, String LR) {
			this.x = x;
			this.h = h;
			this.LR = LR;
		}
	}

	public static int treeCut(treeCutClass[] arr, int i) {
		arr[i].LR = "left";
		int count = treeCut(arr, i);
		
	}

}
