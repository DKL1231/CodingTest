import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] sdoku;
	static boolean flag = false;

	static void dfs(int x, int y) {
		if (flag)
			return;
		if (x == 9 && y == 0) {
			flag = true;
			printMap();
			return;
		}
		if (sdoku[x][y] != 0) {
			if (y != 8)
				dfs(x, y + 1);
			else
				dfs(x + 1, 0);
			return;
		}
		for (int i = 1; i <= 9; i++) {

			if (checkRow(y, i) && checkCol(x, i) && check33(x, y, i)) {
				sdoku[x][y] = i;
				if (y != 8) {
					dfs(x, y + 1);
				} else {
					dfs(x + 1, 0);
				}
				sdoku[x][y] = 0;
			}
		}

	}

	static void printMap() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sdoku[i][j]);
			}
			System.out.println();
		}
	}

	static boolean checkRow(int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (sdoku[i][col] == num) {
				return false;
			}
		}
		return true;
	}

	static boolean checkCol(int row, int num) {
		for (int i = 0; i < 9; i++) {
			if (sdoku[row][i] == num) {
				return false;
			}
		}
		return true;
	}

	static boolean check33(int x, int y, int num) {
		for (int i = ((int) (x / 3)) * 3; i < ((int) (x / 3) + 1) * 3; i++) {
			for (int j = ((int) (y / 3)) * 3; j < ((int) (y / 3) + 1) * 3; j++) {
				if (sdoku[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sdoku = new int[9][9];
		for (int i = 0; i < 9; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				sdoku[i][j] = tmp[j] - '0';
			}
		}

		dfs(0, 0);
	}
}
