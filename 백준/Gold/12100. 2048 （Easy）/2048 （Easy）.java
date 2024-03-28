import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] originMap;
	static int[][] map;
	static int[] now = new int[5];
	static int answer = 0;

	static void dfs(int depth) {
		if (depth == 5) {
			initMap();
			simulation();
			return;
		}

		for (int i = 0; i < 4; i++) {
			now[depth] = i;
			dfs(depth + 1);
		}
	}

	static void initMap() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				map[i][j] = originMap[i][j];
			}
		}
	}
	
	static void simulation() {
		for (int i = 0; i < 5; i++) {
			switch (now[i]) {
			case 0:
				goUp();
				break;
			case 1:
				goDown();
				break;
			case 2:
				goRight();
				break;
			case 3:
				goLeft();
				break;
			}
		}
		int tmp = countMax();
		if (tmp > answer) {
			answer = tmp;
		}
	}

	static void goUp() {
		for(int i = 0; i<n; i++) {
			int[] tmp = new int[n];
			int idx = 0;
			int prv = 0;
			for(int j = 0; j<n; j++) {
				if(map[j][i] != 0) {
					if(prv == 0) {
						prv = map[j][i];
						continue;
					}else {
						if(prv == map[j][i]) {
							tmp[idx++] = prv+map[j][i];
							prv = 0;
						}else {
							tmp[idx++] = prv;
							prv = map[j][i];
						}
					}
				}
			}
			if(prv != 0) tmp[idx++] = prv;
			for(int j = 0; j<n; j++) {
				map[j][i] = tmp[j];
			}
		}
	}

	static void goDown() {
		for(int i = 0; i<n; i++) {
			int[] tmp = new int[n];
			int idx = n-1;
			int prv = 0;
			for(int j = n-1; j>=0; j--) {
				if(map[j][i] != 0) {
					if(prv == 0) {
						prv = map[j][i];
						continue;
					}else {
						if(prv == map[j][i]) {
							tmp[idx--] = prv+map[j][i];
							prv = 0;
						}else {
							tmp[idx--] = prv;
							prv = map[j][i];
						}
					}
				}
			}
			if(prv != 0) tmp[idx--] = prv;
			for(int j = n-1; j>=0; j--) {
				map[j][i] = tmp[j];
			}
		}
	}

	static void goRight() {
		for(int i = 0; i<n; i++) {
			int[] tmp = new int[n];
			int idx = n-1;
			int prv = 0;
			for(int j = n-1; j>=0; j--) {
				if(map[i][j] != 0) {
					if(prv == 0) {
						prv = map[i][j];
						continue;
					}else {
						if(prv == map[i][j]) {
							tmp[idx--] = prv+map[i][j];
							prv = 0;
						}else {
							tmp[idx--] = prv;
							prv = map[i][j];
						}
					}
				}
			}
			if(prv != 0) tmp[idx--] = prv;
			for(int j = n-1; j>=0; j--) {
				map[i][j] = tmp[j];
			}
		}
	}

	static void goLeft() {
		for(int i = 0; i<n; i++) {
			int[] tmp = new int[n];
			int idx = 0;
			int prv = 0;
			for(int j = 0; j<n; j++) {
				if(map[i][j] != 0) {
					if(prv == 0) {
						prv = map[i][j];
						continue;
					}else {
						if(prv == map[i][j]) {
							tmp[idx++] = prv+map[i][j];
							prv = 0;
						}else {
							tmp[idx++] = prv;
							prv = map[i][j];
						}
					}
				}
			}
			if(prv != 0) tmp[idx++] = prv;
			for(int j = 0; j<n; j++) {
				map[i][j] = tmp[j];
			}
		}
	}

	static int countMax() {
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tmp < map[i][j])
					tmp = map[i][j];
			}
		}
		return tmp;
	}
	


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		originMap = new int[n][n];
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				originMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(answer);
	}
}