import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static int answer = 0;
	static int[][][] tetromino = {
			{{0,0},{0,1},{0,2},{0,3}},
	        {{0,0},{1,0},{2,0},{3,0}},
	        {{0,0},{1,0},{0,1},{1,1}},
	        {{0,0},{1,0},{2,0},{2,1}},
	        {{0,1},{1,1},{2,1},{2,0}},
	        {{0,0},{0,1},{1,1},{2,1}},
	        {{0,0},{0,1},{1,0},{2,0}},
	        {{0,0},{1,0},{1,1},{1,2}},
	        {{0,2},{1,1},{1,2},{1,0}},
	        {{0,0},{0,1},{0,2},{1,2}},
	        {{0,0},{1,0},{0,1},{0,2}},
	        {{0,0},{1,0},{1,1},{2,1}},
	        {{0,1},{1,1},{1,0},{2,0}},
	        {{1,0},{1,1},{0,1},{0,2}},
	        {{0,0},{0,1},{1,1},{1,2}},
	        {{0,1},{1,0},{1,1},{1,2}},
	        {{0,0},{0,1},{0,2},{1,1}},
	        {{0,0},{1,0},{1,1},{2,0}},
	        {{0,1},{1,1},{1,0},{2,1}}
	        };
	static void solve() {
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				for (int i = 0; i < tetromino.length; i++) {
					int tmp = 0;
					boolean flag = true;
					for (int j = 0; j < 4; j++) {
						int nx = x + tetromino[i][j][0];
						int ny = y + tetromino[i][j][1];
						if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
							flag = false;
							break;
						}
						tmp += map[nx][ny];
					}
					if(flag) {
						answer = Math.max(tmp, answer);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();
		System.out.println(answer);
	}
}