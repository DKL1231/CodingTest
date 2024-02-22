import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int n, m;
	static int answer = 0;
	static int[][] mv = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		visit = new boolean[n][m];
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < n; i++)
			map[i] = br.readLine().toCharArray();
		findDoyueon: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'I') {
					q.add(new Point(i, j));
					break findDoyueon;
				}
			}
		}

		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + mv[i][0];
				int ny = now.y + mv[i][1];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || map[nx][ny] == 'X')
					continue;
				visit[nx][ny] = true;
				if (map[nx][ny] == 'P')
					answer++;
				q.add(new Point(nx, ny));
			}
		}
		if(answer == 0) System.out.println("TT");
		else System.out.println(answer);
	}

}