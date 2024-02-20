import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int x, y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n, m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] mv = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		
		int[][] map = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Pair> q = new LinkedList<>();
		int cheezeCnt = -1;
		int timeCnt = 0;
		while (cheezeCnt != 0) {
			visited = new boolean[n][m];
			q.add(new Pair(0, 0));
			int tmp = 0;
			visited[0][0] = true;
			while (!q.isEmpty()) {
				Pair now = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = now.x + mv[i][0];
					int ny = now.y + mv[i][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny])
						continue;
					visited[nx][ny] = true;
					if (map[nx][ny] == 1) {
						tmp++;
						map[nx][ny] = 0;
					} else {
						q.add(new Pair(nx, ny));
					}
				}
			}
			if (tmp == 0) {
				System.out.println(timeCnt);
				System.out.println(cheezeCnt);
			}
			cheezeCnt = tmp;
			timeCnt++;
		}
	}
}