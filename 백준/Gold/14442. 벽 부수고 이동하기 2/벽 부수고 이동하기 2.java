import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x, y, b;

	public Point(int x, int y, int b) {
		this.x = x;
		this.y = y;
		this.b = b;
	}
}

public class Main {
	static int n, m, k;
	static int[][] map;
	static boolean[][][] visit;
	static int[][] mv = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static void dfs(int[][] prv, int depth) {

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m][k + 1];

		for (int i = 0; i < n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = tmp[j] - '0';
			}
		}

		Queue<Point> q = new LinkedList<>();

		q.add(new Point(0, 0, 0));
		int answer = -1;
		int time = 1;
		outer: while (!q.isEmpty()) {
			int qs = q.size();
			while (qs-- != 0) {
				Point now = q.poll();
				if (now.x == n - 1 && now.y == m - 1) {
					answer = time;
					break outer;
				}
				for (int[] move : mv) {
					int nx = now.x + move[0];
					int ny = now.y + move[1];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						continue;
					if (map[nx][ny] == 1) {
						if (now.b == k || visit[nx][ny][now.b + 1])
							continue;
						else {
							visit[nx][ny][now.b+1] = true;
							q.add(new Point(nx, ny, now.b + 1));
						}
					}else {
						if(visit[nx][ny][now.b])
							continue;
						else {
							visit[nx][ny][now.b] = true;
							q.add(new Point(nx, ny, now.b));
						}
					}
				}
			}
			time++;
		}
		System.out.println(answer);
	}
}