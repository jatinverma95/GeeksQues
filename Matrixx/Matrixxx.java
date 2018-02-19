package Matrixx;

import java.util.ArrayList;
import java.util.HashMap;

public class Matrixxx {

	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		// System.out.println(rowWiseColWiseSearchDAQ(mat, 45, 0, mat.length -
		// 1, 0, mat[0].length - 1));

		// spiralPrint(mat);
		// booleanMatrixQuestion(mat);
		// booleanMatrixQuestion(new int[][] { { 0, 0, 0 }, { 0, 0, 1 } });

		// printUniqueRows(new int[][] { { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 }, {
		// 0, 1, 0, 0, 1 }, { 1, 0, 1, 0, 0 } });

		// maxSubMatW1(new int[][] { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0,
		// 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 },
		// { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } });

		inplaceTransposeNxN(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
	}

	public static void rowWiseColWiseSearch(int[][] arr, int tbf) {
		int i = 0;
		int j = arr[i].length - 1;

		while (j >= 0 && i < arr.length) {
			if (arr[i][j] == tbf) {
				System.out.print(i + "," + j);
				return;
			}
			if (arr[i][j] < tbf) {
				i++;
			} else {

				j--;
			}
		}

		System.out.println("nahi mila");

	}

	public static boolean rowWiseColWiseSearchDAQ(int[][] arr, int tbf, int fromRow, int toRow, int fromCol,
			int toCol) {
		if (fromRow > toRow || fromCol > toCol) {
			return false;
		}

		if (fromRow == toRow) {
			for (int i = fromCol; i <= toCol; i++) {
				if (arr[fromRow][i] == tbf) {
					return true;
				}
			}
			return false;
		}

		if (fromCol == toCol) {
			for (int i = fromRow; i <= toRow; i++) {
				if (arr[i][fromCol] == tbf) {
					return true;
				}
			}
			return false;
		}

		int midi = (fromRow + toRow) / 2;
		int midj = (fromCol + toCol) / 2;

		if (arr[midi][midj] == tbf) {
			return true;
		} else if (arr[midi][midj] > tbf) {
			boolean a = rowWiseColWiseSearchDAQ(arr, tbf, fromRow, midi, fromCol, toCol);
			boolean b = rowWiseColWiseSearchDAQ(arr, tbf, midi, toRow, fromCol, midj - 1);

			if (a || b) {
				return true;
			} else {
				return false;
			}
		} else {
			boolean a = rowWiseColWiseSearchDAQ(arr, tbf, fromRow, midi, midj + 1, toCol);
			boolean b = rowWiseColWiseSearchDAQ(arr, tbf, midi, toRow, midj, toCol);

			if (a || b) {
				return true;
			} else {
				return false;
			}
		}

	}

	public static void spiralPrint(int[][] mat) {
		int loi = Integer.MIN_VALUE;
		int hii = Integer.MAX_VALUE;
		int loj = Integer.MIN_VALUE;
		int hij = Integer.MAX_VALUE;

		int i = 0, j = 0;
		String dir = "L";

		boolean check = false;

		while (true) {
			// RIGHT
			while (j < mat[0].length && j < hij && j > loj) {
				loi = i;
				System.out.print(mat[i][j] + ",");
				j++;
				check = true;
			}
			if (!check) {
				break;
			}
			j--;
			i++;
			check = false;

			// DOWN
			while (i < mat.length && i < hii && i > loi) {
				hij = j;
				System.out.print(mat[i][j] + ",");
				i++;
				check = true;
			}
			if (!check) {
				break;
			}
			i--;
			j--;
			check = false;

			// LEFT
			while (j > loj && j < hij && j >= 0) {
				hii = i;
				System.out.print(mat[i][j] + ",");
				j--;
				check = true;
			}
			if (!check) {
				break;
			}
			j++;
			i--;
			check = false;

			// UP
			while (i < hii && i > loi && i >= 0) {
				loj = j;
				System.out.print(mat[i][j] + ",");
				i--;
				check = true;
			}
			if (!check) {
				break;
			}
			i++;
			j++;
			check = false;

		}
	}

	private static class rowCol { // HOW THIS IS WORKING ,private members
									// accessed outside of this class
		private int row;
		private int col;

		private rowCol(int r, int c) {
			this.row = r;
			this.col = c;
		}

	}

	public static void booleanMatrixQuestion(int[][] mat) {
		// System.out.println(rc.row + "," + rc.col); //HERE

		boolean rowCheck = false;
		boolean colCheck = false;

		for (int i = 0; i < mat.length; i++) {
			if (mat[i][0] == 1) {
				rowCheck = true;
			}
			if (mat[0][i] == 1) {
				colCheck = true;
			}
		}

		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[i].length; j++) {
				if (mat[i][j] == 1) {
					mat[i][0] = 1;
					mat[0][j] = 1;
				} else {
					if (mat[i][0] == 1) {
						mat[i][j] = 1;
					} else if (mat[0][j] == 1) {
						mat[i][j] = 1;
					}
				}
			}
		}

		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[i].length; j++) {

				if (mat[i][0] == 1) {
					mat[i][j] = 1;
				} else if (mat[0][j] == 1) {
					mat[i][j] = 1;
				}

			}
		}

		if (rowCheck) {
			for (int i = 0; i < mat.length; i++) {
				mat[i][0] = 1;
			}
		}

		if (colCheck) {
			for (int i = 0; i < mat.length; i++) {
				mat[0][i] = 1;
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + ",");
			}
			System.out.println();
		}

	}

	public static void printUniqueRows(int[][] mat) {
		HashMap<String, Boolean> hm = new HashMap<>();

		for (int i = 0; i < mat.length; i++) {
			String str = new String();
			for (int j = 0; j < mat[i].length; j++) {
				str += mat[i][j];
			}

			if (!hm.containsKey(str)) {
				for (int j = 0; j < str.length(); j++) {
					System.out.print(str.charAt(j) + ",");
				}
			}
			System.out.println();

			hm.put(str, true);
		}
	}

	public static void maxSubMatW1(int[][] mat) {
		int maxi = 0;
		int maxj = 0;
		int[][] temp = new int[mat.length][mat[0].length];

		for (int i = 0; i < mat.length; i++) {
			temp[i][mat[0].length - 1] = mat[i][mat[0].length - 1];
		}

		for (int i = 0; i < mat[0].length; i++) {
			temp[mat.length - 1][i] = mat[mat.length - 1][i];
		}
		for (int i = mat.length - 2; i >= 0; i--) {
			for (int j = mat[0].length - 2; j >= 0; j--) {
				if (mat[i][j] == 1) {
					temp[i][j] = Math.min(temp[i][j + 1], Math.min(temp[i + 1][j], temp[i + 1][j + 1])) + 1;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (temp[i][j] > max) {
					max = temp[i][j];
					maxi = i;
					maxj = i;
				}
			}
		}

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				System.out.print("1");
			}
			System.out.println();
		}
	}

	public static void inplaceTransposeNxN(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (i < j) {
					int temp = mat[i][j];
					mat[i][j] = mat[j][i];
					mat[j][i] = temp;
				}
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}

}
