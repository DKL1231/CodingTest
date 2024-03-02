import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int map[][];
	static boolean visit[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		int[][] mapAboutCheeze = new int[n][m];
		visit = new boolean[n][m];
		int cheezeCnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheezeCnt++;
			}
		}

		int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int answer = 0;
		while (cheezeCnt != 0) {
			answer++;
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(0, 0));
			visit = new boolean[n][m];
			mapAboutCheeze = new int[n][m];
			while (!q.isEmpty()) {
				Point now = q.poll();
				for (int[] mv : move) {
					int nx = now.x + mv[0];
					int ny = now.y + mv[1];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny])
						continue;
					if (map[nx][ny] == 1) {
						if (--mapAboutCheeze[nx][ny] == -2) {
							map[nx][ny] = 0;
							cheezeCnt--;
							visit[nx][ny] = true;
						}
					} else {
						visit[nx][ny] = true;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
		System.out.println(answer);
	}
}
