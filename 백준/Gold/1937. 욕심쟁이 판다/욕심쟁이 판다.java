import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static int[][] visit;
	static int[][] mv = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int dfs(int x, int y) {
		if(visit[x][y] != 0) return visit[x][y];
		visit[x][y] = 1;
		
		int mx = 0;
		for(int[] move: mv) {
			int nx = x+move[0];
			int ny = y+move[1];
			if(nx<0||nx>=n||ny<0||ny>=n||map[nx][ny]<=map[x][y]) continue;
			
			mx = Math.max(mx, dfs(nx, ny));
		}
		visit[x][y] += mx;
		return visit[x][y];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				int tmp = dfs(i, j);
				if(answer < tmp) answer = tmp;
			}
		}
		System.out.println(answer);
	}
}