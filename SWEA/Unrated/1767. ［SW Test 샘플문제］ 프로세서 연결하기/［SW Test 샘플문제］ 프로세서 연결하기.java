import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Core {
	int x, y, direction;

	public Core(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static ArrayList<Core> cores = new ArrayList<>();
	static int t, n;
	static int[][] map;
	static int maxConnected = -1;
	static int answer = Integer.MAX_VALUE;
	static int lineLength = 0;

	
	static void printMap(int[][] nowMap) {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(nowMap[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void dfs(int[][] nowMap, int depth, int nowSelected) {
		if (cores.size() - depth + nowSelected < maxConnected)
			return;
		if (nowSelected == maxConnected && lineLength<answer) {
			answer = lineLength;
		} else if (nowSelected > maxConnected) {
			answer = lineLength;
			maxConnected = nowSelected;
		}
		if (depth >= cores.size())
			return;
		Core now = cores.get(depth);
		int[][] tmpMap = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tmpMap[i][j] = nowMap[i][j];
			}
		}
		for (int i = 1; i <= 4; i++) {
			if (checkMap(now.x, now.y, i, tmpMap)) {
				tmpMap = brushMap(now.x, now.y, i, tmpMap);
				dfs(tmpMap, depth + 1, nowSelected + 1);
				tmpMap = initMap(now.x, now.y, i, tmpMap);
			}
		}
		dfs(nowMap, depth+1, nowSelected);
	}

	public static boolean checkMap(int x, int y, int type, int[][] nowMap) {
		switch (type) {
		case 1:
			for (int i = 0; i < x; i++) {
				if (nowMap[i][y] != 0)
					return false;
			}
			return true;
		case 2:
			for (int i = y + 1; i < n; i++) {
				if (nowMap[x][i] != 0)
					return false;
			}
			return true;
		case 3:
			for (int i = x + 1; i < n; i++) {
				if (nowMap[i][y] != 0)
					return false;
			}
			return true;
		case 4:
			for (int i = 0; i < y; i++) {
				if (nowMap[x][i] != 0)
					return false;
			}
			return true;
		}
		return false;
	}

	public static int[][] brushMap(int x, int y, int type, int[][] nowMap) {
		switch (type) {
		case 1:
			for (int i = 0; i < x; i++) {
				nowMap[i][y] = 2;
				lineLength++;
			}
			return nowMap;
		case 2:
			for (int i = y + 1; i < n; i++) {
				nowMap[x][i] = 2;
				lineLength++;
			}
			return nowMap;
		case 3:
			for (int i = x + 1; i < n; i++) {
				nowMap[i][y] = 2;
				lineLength++;
			}
			return nowMap;
		case 4:
			for (int i = 0; i < y; i++) {
				nowMap[x][i] = 2;
				lineLength++;
			}
			return nowMap;
		}
		return nowMap;
	}

	public static int[][] initMap(int x, int y, int type, int[][] nowMap) {
		switch (type) {
		case 1:
			for (int i = 0; i < x; i++) {
				nowMap[i][y] = 0;
				lineLength--;
			}
			return nowMap;
		case 2:
			for (int i = y + 1; i < n; i++) {
				nowMap[x][i] = 0;
				lineLength--;
			}
			return nowMap;
		case 3:
			for (int i = x + 1; i < n; i++) {
				nowMap[i][y] = 0;
				lineLength--;
			}
			return nowMap;
		case 4:
			for (int i = 0; i < y; i++) {
				nowMap[x][i] = 0;
				lineLength--;
			}
			return nowMap;
		}
		return nowMap;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			cores = new ArrayList<>();
			maxConnected = -1;
			answer = Integer.MAX_VALUE;
			lineLength = 0;
			
			n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i != 0 && j != 0 && map[i][j] == 1) {
						cores.add(new Core(i, j));
					}
				}
			}
			dfs(map, 0, 0);
			System.out.println("#"+tc+" "+answer);
		}
	}
}