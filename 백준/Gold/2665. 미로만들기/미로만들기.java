import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int x, y, b;

	public Point(int x, int y, int b) {
		this.x = x;
		this.y = y;
		this.b = b;
	}

	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return b - o.b;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 10000*x+100*y+b;
	}

	@Override
	public boolean equals(Object obj) {
		Point p = (Point) obj;
		return (x == p.x && y == p.y && b == p.b);
	}

}

public class Main {
	static int n;
	static int answer;
	static char[][] map;
	static Set<Point> visit;
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void input() throws Exception {
		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
	}

	static void solve() {
		PriorityQueue<Point> q = new PriorityQueue<>();
		visit = new HashSet<>();
		q.add(new Point(0, 0, 0));
		visit.add(new Point(0, 0, 0));

		while (!q.isEmpty()) {
			Point now = q.poll();
			if (now.x == n - 1 && now.y == n - 1) {
				answer = now.b;
				break;
			}
			for (int[] mv : move) {
				int nx = now.x + mv[0];
				int ny = now.y + mv[1];
				int nb = now.b;
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (map[nx][ny] == '0')
					nb += 1;
				Point next = new Point(nx, ny, nb);
				if (visit.contains(next))
					continue;
				
				visit.add(next);
				q.add(next);
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

}