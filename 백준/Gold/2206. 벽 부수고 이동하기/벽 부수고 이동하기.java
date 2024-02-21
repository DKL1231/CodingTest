import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

class Point {
	int x, y, crashed, depth;

	public Point(int x, int y, int crashed, int depth) {
		this.x = x;
		this.y = y;
		this.crashed = crashed;
		this.depth = depth;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(x, y, crashed);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == this)
			return true;
		if (!(obj instanceof Point))
			return false;
		Point tmp = (Point) obj;
		return tmp.x == x && tmp.y == y && tmp.crashed == crashed;
	}

}

public class Main {
	static int n, m;
	static int answer = -1;
	static int[][] map;
	static int[][] mv = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][][] visit;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m][2];

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++)
				map[i][j] = tmp.charAt(j) - '0';
		}
		visit[0][0][0] = true;

		Queue<Point> q = new LinkedList<Point>();

		q.add(new Point(0, 0, 0, 1));
		while (!q.isEmpty()) {
			Point now = q.poll();
			if (now.x == n - 1 && now.y == m - 1) {
				answer = now.depth;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = now.x + mv[i][0];
				int ny = now.y + mv[i][1];
				int nc = now.crashed;
				int nd = now.depth + 1;
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (map[nx][ny] == 1)
						nc++;
					if (nc > 1)
						continue;
					Point np = new Point(nx, ny, nc, nd);
					if (visit[nx][ny][nc])
						continue;
					visit[nx][ny][nc] = true;
					q.add(np);
				}
			}
		}

		System.out.println(answer);
	}

}