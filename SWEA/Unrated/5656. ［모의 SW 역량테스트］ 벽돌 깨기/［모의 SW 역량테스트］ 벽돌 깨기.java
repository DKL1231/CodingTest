import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, w, h;
	static int answer;
	static int map[][];

	static void dfs(int depth, int[][] now) {
		if (depth == n) {
			int tmp = countleft(now);
			if (answer > tmp) {
				answer = tmp;
				//printMap(now);
			}
			return;
		}
		int[][] tmpMap = new int[h][w];
		initMap(tmpMap, now);
		for(int i = 0; i<w; i++) {
			shoot(i, now);
			dfs(depth+1, now);
			initMap(now, tmpMap);
		}
	}
	
	static void printMap(int[][] now) {
		for(int i = 0; i<h; i++) {
			for(int j = 0; j<w; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void shoot(int col, int[][] now) {
		for(int i = 0; i<h; i++) {
			if(now[i][col] != 0) {
				boom(i, col, now);
				goDown(now);
				break;
			}
		}
	}
	
	static void boom(int x, int y, int[][] now) {
		if(now[x][y] == 1 || now[x][y] == 0) {
			now[x][y] = 0;
			return;
		}
		
		int tmp = now[x][y];
		now[x][y] = 0;
		for(int i = 0; i<tmp; i++) {
			if(x-i >= 0)
				boom(x-i, y, now);
			if(x+i < h)
				boom(x+i, y, now);
			if(y-i >= 0)
				boom(x, y-i, now);
			if(y+i < w)
				boom(x, y+i, now);
		}
	}
	
	static void goDown(int[][] now) {
		for(int i = 0; i<w; i++) {
			int idx = h-1;
			int newCol[] = new int[h];
			for(int j = h-1; j>=0; j--) {
				if(now[j][i] != 0) {
					newCol[idx--] = now[j][i];
				}
			}
			for(int j = 0; j<h; j++)
				now[j][i] = newCol[j];
		}
	}
	
	static void initMap(int[][] a, int[][] b) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				a[i][j] = b[i][j];
			}
		}
	}

	static int countleft(int[][] now) {
		int cnt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (now[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			answer = w * h;

			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, map);
			System.out.println("#"+test_case+" "+answer);
		}
	}
}
