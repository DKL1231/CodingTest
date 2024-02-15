import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int h, w, n;
	static char[][] field;
	static char[] ctrl;
	static int x, y;

	public static void act(char doing) {

		if (doing == 'U') {
			if (y > 0 && field[y - 1][x] == '.') {
				field[y][x] = '.';
				y--;
			}
			field[y][x] = '^';
		}
		else if (doing == 'D') {
			if (y + 1 < h && field[y + 1][x] == '.') {
				field[y][x] = '.';
				y++;
			}
			field[y][x] = 'v';
		}else if (doing == 'L') {
			if (x > 0 && field[y][x - 1] == '.') {
				field[y][x] = '.';
				x--;
			}
			field[y][x] = '<';
		}else if (doing == 'R') {
			if (x + 1 < w && field[y][x + 1] == '.') {
				field[y][x] = '.';
				x++;
			}
			field[y][x] = '>';
		}else if (doing == 'S') {
			int dx, dy;

			if (field[y][x] == '^') {
				dx = 0;
				dy = -1;
			} else if (field[y][x] == 'v') {
				dx = 0;
				dy = 1;
			} else if (field[y][x] == '<') {
				dx = -1;
				dy = 0;
			} else {
				dx = 1;
				dy = 0;
			}

			int nx = x + dx;
			int ny = y + dy;
			while (true) {
				if (nx < 0 || nx >= w || ny < 0 || ny >= h || field[ny][nx] == '#')
					break;

				if (field[ny][nx] == '*') {
					field[ny][nx] = '.';
					break;
				}
				nx += dx;
				ny += dy;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			x = -1;
			y = -1;
			field = new char[h][w];
			for (int i = 0; i < h; i++) {
				field[i] = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					if (field[i][j] == '>' || field[i][j] == '<' || field[i][j] == 'v' || field[i][j] == '^') {
						x = j;
						y = i;
					}
				}
			}

			n = Integer.parseInt(br.readLine());
			ctrl = br.readLine().toCharArray();
			for (int i = 0; i < n; i++) {
				act(ctrl[i]);
			}
			System.out.print("#"+tc+" ");
			for(int i = 0; i<h; i++) {
				for(int j =0; j<w; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
		}
	}
}
