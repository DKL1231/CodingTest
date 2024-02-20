import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
	static int n;
	static char now;
	static char[][] map;
	static boolean[][] visited;
	static int[][] mv = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i = 0; i<4; i++) {
			int nx = x+mv[i][0];
			int ny = y+mv[i][1];
			if(nx>=0&&ny>=0&&nx<n&&ny<n&&!visited[nx][ny]&&map[nx][ny]==now) {
				dfs(nx, ny);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		visited = new boolean[n][n];
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					now = map[i][j];
					dfs(i, j);
					tmp++;
				}
			}
		}
		sb.append(tmp+" ");
		
		tmp = 0;
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'R') {
					map[i][j] = 'G';
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					now = map[i][j];
					dfs(i, j);
					tmp++;
				}
			}
		}
		sb.append(tmp);
		
		System.out.println(sb.toString());
	}
}