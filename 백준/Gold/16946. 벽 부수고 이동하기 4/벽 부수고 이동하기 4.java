import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] isWall;
	static boolean[][] visit;
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		isWall = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = tmp[j] - '0';
				if(map[i][j] != 0) isWall[i][j] = true;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!isWall[i][j] && !visit[i][j]) {
					Set<Point> metWall = new HashSet<>();
					ArrayDeque<Point> q = new ArrayDeque<Point>();
					visit[i][j] = true;
					q.add(new Point(i, j));
					int cnt = 0;
					while (!q.isEmpty()) {
						Point now = q.pop();
						cnt++;
						for (int[] mv : move) {
							int nx = now.x + mv[0];
							int ny = now.y + mv[1];
							if (nx < 0 || ny < 0 || nx >= n || ny >= m || visit[nx][ny])
								continue;
							if (isWall[nx][ny]) {
								metWall.add(new Point(nx, ny));
								continue;
							}
							q.offer(new Point(nx, ny));
							visit[nx][ny] = true;
						}
					}
					
					for(Point now:metWall) {
						map[now.x][now.y] += cnt;
						map[now.x][now.y] %= 10;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder(); 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
