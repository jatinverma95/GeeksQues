package Arrrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Arrayss {

	public static void main(String[] args) {
		// int[] arr = new int[] { 16, 17, 114, 0, 5, 2 };
		// reverseArr(arr, 0, 5);
		//
		// pairSumWHashMap(arr, 33);
		// for (int i = 0; i < arr.length; i++) {
		// System.out.print(arr[i] + ",");
		// }
		// System.out.println();
		// System.out.println("----------------majority----------");
		// int a[] = new int[] { 1, 3, 3, 1, 2 };
		// majorityElement(a);

		// oddNo(new int[] { 1, 3, 2, 2, 3, 3, 1, 2, 3 });

		// largestSumKADANE(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 });

		// System.out.println(searchInSortedRotatedArr(new int[] { 30, 40, 50,
		// 10, 20 }, 0, 4, 10));

		// int[] arrr = (arrMpN(new int[] { 2, 8, -1, -1, -1, 13, -1, 15, 20 },
		// new int[] { 5, 7, 9, 25 }));
		//
		// for (int i = 0; i < arrr.length; i++) {
		// System.out.print(arrr[i] + ",");
		// }

		// Integer ar1[] = { 1, 3, 4, 8 };
		// Integer ar2[] = { 2, 5, 6, 7 };
		//
		// System.out.println("Median is" + medainOfArr(ar1, ar2));

		// int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// reversalAlgoArrRotatn(arr, arr.length, 6);
		//
		// for (int i = 0; i < arr.length; i++) {
		// System.out.print(arr[i] + ",");
		// }

		// maxSumWOAdjacent(new int[] { 3, 2, 5, 10, 7 });

		// sortByFreq(new int[] { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 });

		System.out.println(countInversionByEnhanceMergeSort(new int[] { 1, 20, 6, 4, 5 }, 0, 4).inv_count);
	}

	public static void reverseArr(int[] arr, int l, int r) {
		if (l >= r) {
			return;
		}

		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;

		reverseArr(arr, l + 1, r - 1);

	}

	public static void leadersInArr(int[] arr) {
		int maxTillNow = arr[arr.length - 1];
		System.out.println(maxTillNow);
		int n = arr.length - 2;
		while (n != 0) {
			if (arr[n] > maxTillNow) {
				maxTillNow = arr[n];
				System.out.println(maxTillNow);
			}
			n--;
		}

	}

	private static void QuickSort(int[] arr, int l, int r) {
		if (l >= r) {
			return;

		}

		int left = l, right = r;

		int pivot = arr[(left + right) / 2];

		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		QuickSort(arr, l, right);
		QuickSort(arr, left, r);

	}

	public static void pairSum(int[] arr, int sum) {

		QuickSort(arr, 0, arr.length - 1);

		int left = 0, right = arr.length - 1;

		while (left < right) {
			int innerSum = arr[left] + arr[right];
			if (innerSum == sum) {
				System.out.println(arr[left] + "," + arr[right]);
				return;
			} else if (innerSum > sum) {
				right--;
			} else {
				left++;
			}
		}

	}

	public static void pairSumWHashMap(int[] arr, int sum) {
		HashMap<Integer, Boolean> hm = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			hm.put(arr[i], false);
		}

		Set<Integer> keys = hm.keySet();
		for (int key : keys) {
			if (hm.containsKey(sum - key)) {
				System.out.println(key + "," + (sum - key));
			}
		}
	}

	public static void majorityElement(int[] arr) {
		// by cancelling the majNo elements with nonMajNo elements
		int majIndex = 0;
		int count = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[majIndex] == arr[i]) {
				count++;
			} else {
				count--;
				if (count == 0) {
					majIndex = i;
					count = 1;
				}

			}
		}
		System.out.println(arr[majIndex]);
	}

	public static void oddNo(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum ^ arr[i];
		}

		System.out.println(sum);
	}

	public static void largestSumKADANE(int[] arr) {
		int max = Integer.MIN_VALUE;
		int tempMax = 0;

		for (int i = 0; i < arr.length; i++) {
			tempMax += arr[i];
			if (tempMax < arr[i]) {
				tempMax = arr[i];
			}
			if (tempMax > max) {
				max = tempMax;
			}
		}
		System.out.println(max);

	}

	private static int glo = -1, ghi = -1;

	public static int searchInSortedRotatedArr(int[] arr, int lo, int hi, int key) {
		if (lo == hi) {
			if (arr[lo] == key) {
				return lo;
			} else {
				return -1;
			}
		}

		int left = lo;
		int right = hi;

		int mid = (left + right) / 2;

		if (arr[mid] == key || arr[lo] == key || arr[hi] == key) {
			if (arr[mid] == key) {
				return mid;
			} else if (arr[lo] == key) {
				return lo;
			} else {
				return hi;
			}
		}

		if (arr[mid] > arr[mid + 1]) {
			ghi = mid;
			glo = mid + 1;

			if (key < mid && key > lo) {
				return binarySearchMod(arr, lo, mid - 1, key);
			} else {
				return binarySearchMod(arr, mid + 1, hi, key);
			}
		}

		if (arr[lo] > arr[mid]) {
			return searchInSortedRotatedArr(arr, lo, mid, key);
		} else if (arr[mid] > arr[right]) {
			return searchInSortedRotatedArr(arr, mid, hi, key);
		} else {
			return binarySearchMod(arr, lo, hi, key);
		}

	}

	public static int binarySearchMod(int[] arr, int lo, int hi, int key) {
		if (lo >= hi) {
			if (arr[lo] == key) {
				return lo;
			} else {
				return -1;
			}
		}
		int left = lo;
		int right = hi;
		int mid = (left + right) / 2;

		if (arr[mid] == key) {
			return mid;
		} else if (arr[mid] > key) {

			return binarySearchMod(arr, lo, mid - 1, key);
		} else {

			return binarySearchMod(arr, mid + 1, hi, key);
		}
	}

	public static int[] arrMpN(int[] arr1, int[] arr2) {

		int bhara = arr1.length - 1;

		int idx = arr1.length - 1;
		int LFIdx = -1;
		while (bhara >= 0) {
			if (arr1[bhara] != -1) {
				arr1[idx] = arr1[bhara];
				LFIdx = idx;
				idx--;
			}
			bhara--;

		}

		int nIdx = 0;
		int mpnIdx = 0;
		while (LFIdx != arr1.length && nIdx != arr2.length) {

			if (arr1[LFIdx] < arr2[nIdx]) {
				arr1[mpnIdx] = arr1[LFIdx];
				LFIdx++;
			} else {
				arr1[mpnIdx] = arr2[nIdx];
				nIdx++;
			}

			mpnIdx++;

		}

		while (LFIdx < arr1.length) {
			arr1[mpnIdx] = arr1[LFIdx];
			LFIdx++;
		}

		while (nIdx < arr2.length) {
			arr1[mpnIdx] = arr2[nIdx];
			nIdx++;
		}

		return arr1;

	}

	public static float medainOfArr(Integer[] arr1, Integer[] arr2) {
		if (arr1.length == 2 && arr2.length == 2) {
			return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1])) / 2;
		}

		float m1 = median(arr1, arr1.length);
		float m2 = median(arr2, arr2.length);

		if (m1 == m2) {
			return m1;
		} else if (m1 < m2) {
			ArrayList<Integer> arr1Temp = new ArrayList<>();
			ArrayList<Integer> arr2Temp = new ArrayList<>();

			int i = -1;
			if (arr1.length % 2 != 0) {
				i = arr1.length / 2;
			} else {
				i = (arr1.length / 2) - 1;
			}

			while (i < arr1.length) {
				arr1Temp.add(arr1[i]);
				i++;
			}

			int j = 0;
			while (j <= arr2.length / 2) {
				arr2Temp.add(arr2[j]);
				j++;
			}

			arr1 = new Integer[arr1Temp.size()];
			arr1 = arr1Temp.toArray(arr1);
			arr2 = new Integer[arr2Temp.size()];
			arr2 = arr2Temp.toArray(arr2);

			return medainOfArr(arr1, arr2);
		} else {
			ArrayList<Integer> arr1Temp = new ArrayList<>();
			ArrayList<Integer> arr2Temp = new ArrayList<>();

			int i = -1;
			if (arr1.length % 2 != 0) {
				i = arr1.length / 2;
			} else {
				i = (arr1.length / 2) - 1;
			}
			while (i < arr2.length) {
				arr2Temp.add(arr2[i]);
				i++;
			}
			int j = 0;
			while (j <= arr1.length / 2) {
				arr1Temp.add(arr1[j]);
				j++;
			}
			arr1 = new Integer[arr1Temp.size()];
			arr1 = arr1Temp.toArray(arr1);
			arr2 = new Integer[arr2Temp.size()];
			arr2 = arr2Temp.toArray(arr2);

			return medainOfArr(arr1, arr2);
		}

	}

	private static float median(Integer[] arr, int n) {
		if (n % 2 == 0) {
			return (arr[n / 2] + arr[(n / 2) - 1]) / 2;
		} else {
			return arr[n / 2];
		}
	}

	public static void jugglingAlgoArrRotatn(int[] arr, int n, int k) {
		final int GCD = gcd(n, k);
		for (int i = 0; i < GCD; i++) {
			int j = i;

			int temp = arr[j];
			while (true) {
				int next = (j + k) % n;
				if (next == i) {
					break;
				}
				arr[j] = arr[next];
				j = next;
			}
			arr[j] = temp;
		}

	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}

	public static void reversalAlgoArrRotatn(int[] arr, int n, int k) {
		reverse(arr, 0, k - 1);
		reverse(arr, k, n - 1);
		reverse(arr, 0, n - 1);
	}

	private static void reverse(int[] arr, int start, int end) {

		int mid = (start + end) / 2;
		int j = 0;
		for (int i = start; i <= mid; i++) {
			int temp = arr[i];
			arr[i] = arr[end - j];
			arr[end - j] = temp;
			j++;
		}

	}

	public static void maxSumWOAdjacent(int[] arr) {
		int incl = arr[0];
		int excl = 0;

		for (int i = 1; i < arr.length; i++) {
			int inclPrev = incl;
			incl = excl + arr[i];
			excl = Math.max(inclPrev, excl);
		}

		System.out.println(Math.max(excl, incl));

	}

	private static class valu implements Comparable<valu> {
		int index;
		int count;

		public valu(int index, int count) {
			this.index = index;
			this.count = count;
		}

		@Override
		public int compareTo(valu o) {
			if (this.count == o.count) {
				return this.index - o.index;
			} else {
				return o.count - this.count;
			}
		}
	}

	public static void sortByFreq(int[] arr) {
		HashMap<Integer, valu> hm = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (!hm.containsKey(arr[i])) {
				valu x = new valu(i, 1);
				hm.put(arr[i], x);
			} else {
				valu ov = hm.get(arr[i]);
				ov.count += 1;
				hm.put(arr[i], ov);
			}
		}

		Set<Map.Entry<Integer, valu>> entries = hm.entrySet();
		ArrayList<valu> alv = new ArrayList<>();
		for (Map.Entry<Integer, valu> entry : entries) {
			alv.add(entry.getValue());
		}
		valu[] arrv = new valu[alv.size()];
		alv.toArray(arrv);

		Arrays.sort(arrv);

		for (int i = 0; i < arrv.length; i++) {
			valu temp = arrv[i];

			int j = temp.count;
			while (j > 0) {
				System.out.print(arr[temp.index] + ",");
				j--;
			}
		}
	}

	private static class mergerHelper {
		int inv_count;
		int[] temp;

		public mergerHelper(int len) {
			temp = new int[len];
			inv_count = 0;
		}
	}

	public static mergerHelper countInversionByEnhanceMergeSort(int[] arr, int l, int r) {
		if (l == r) {
			mergerHelper bc = new mergerHelper(1);
			bc.temp[0] = arr[l];
			bc.inv_count = 0;
			return bc;
		}
		if (l > r) {
			mergerHelper bcc = new mergerHelper(0);

			return bcc;
		}

		int mid = (l + r) / 2;
		mergerHelper lc = countInversionByEnhanceMergeSort(arr, 0, mid);
		mergerHelper rc = countInversionByEnhanceMergeSort(arr, mid + 1, r);

		mergerHelper mc = new mergerHelper(r - l + 1);
		mc.inv_count = lc.inv_count + rc.inv_count;
		int i = l;
		int j = 0;
		int k = 0;
		while (i < lc.temp.length && j < rc.temp.length) {
			if (lc.temp[i] < rc.temp[j]) {
				mc.temp[k++] = (lc.temp[i]);
				i++;
			} else {
				mc.inv_count += mid - i;
				mc.temp[k++] = (rc.temp[j]);
				j++;
			}

		}

		while (i < lc.temp.length) {
			mc.temp[k++] = lc.temp[i];
			i++;
		}

		while (j < rc.temp.length) {
			mc.temp[k++] = rc.temp[j];
			j++;
		}

		return mc;

	}

}
