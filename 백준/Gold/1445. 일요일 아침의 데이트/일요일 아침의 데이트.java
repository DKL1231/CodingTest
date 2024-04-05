import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class PointWithGarbage implements Comparable<PointWithGarbage> {
	int x, y, g, n;

	public PointWithGarbage(int x, int y, int g, int n) {
		this.x = x;
		this.y = y;
		this.g = g;
		this.n = n;
	}

	@Override
	public int compareTo(PointWithGarbage o) {
		// TODO Auto-generated method stub
		if (g == o.g) {
			return n - o.n;
		}
		return g - o.g;
	}
}

public class Main {
	static int n, m;
	static char[][] map;
	static Point[][] visit;
	static int[] finish = new int[2];
	static int move[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visit = new Point[n][m];
		PriorityQueue<PointWithGarbage> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visit[i][j] = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
				if (map[i][j] == 'g') {
					for (int[] mv : move) {
						int nx = i + mv[0];
						int ny = j + mv[1];
						if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] != '.')
							continue;
						map[nx][ny] = 'n';
					}
				} else if (map[i][j] == 'S') {
					pq.add(new PointWithGarbage(i, j, 0, 0));
					visit[i][j].x = 0;
					visit[i][j].y = 0;
				} else if (map[i][j] == 'F') {
					finish[0] = i;
					finish[1] = j;
				}
			}
		}
		outer: while (!pq.isEmpty()) {
			PointWithGarbage now = pq.poll();
			for (int[] mv : move) {
				int nx = now.x + mv[0];
				int ny = now.y + mv[1];
				int ng = now.g;
				int nn = now.n;
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (nx == finish[0] && ny == finish[1]) {
					System.out.println(now.g + " " + now.n);
					break outer;
				} else if (map[nx][ny] == 'g') {
					ng++;
				} else if (map[nx][ny] == 'n') {
					nn++;
				}
				PointWithGarbage next = new PointWithGarbage(nx, ny, ng, nn);

				if (visit[nx][ny].x-ng > 0 || (visit[nx][ny].x == ng && visit[nx][ny].y > nn)) {
					visit[nx][ny].x = ng;
					visit[nx][ny].y = nn;
					pq.add(next);
				}
			}
		}
	}
}