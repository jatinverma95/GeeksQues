package Matrixx;

public class Matrixxx {

	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		System.out.println(rowWiseColWiseSearchDAQ(mat, 45, 0, mat.length - 1, 0, mat[0].length - 1));
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

		while (i < mat.length && j < mat[0].length) {
			while (j < mat[0].length && i < hii && i > loi) {
				loi = i;
				System.out.print(mat[i][j] + ",");
				j++;
			}
			j--;
			i++;
			while (i < mat.length && j < hij && j > loj) {
				hij = j;
				System.out.print(mat[i][j] + ",");
				i++;
			}
			i--;
			j--;

			while (i > loi && i < hii && j >= 0) {
				hii = i;
				System.out.print(mat[i][j] + ",");
				j--;
			}
			j++;

			while (j < hij && j > loj && i >= 0) {
				loj = j;
				System.out.print(mat[i][j] + ",");
			}
			i++;

		}
	}

}
