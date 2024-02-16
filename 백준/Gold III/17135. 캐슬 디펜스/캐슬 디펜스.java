import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Point {
	int x, y;
	int depth;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Point p = (Point) o;
		return x == p.x && y == p.y;
	}

}

public class Main {
	static int n, m, d;
	static int[][] field;
	static int[][] tmpField;
	static int[] selected = new int[3];
	static int answer = 0;
	static int tmp = 0;
	static int[][] mv = { { 0, -1 }, { -1, 0 }, { 0, 1 } }; // 왼, 위, 오른쪽

	static void setArchor(int depth, int cnt) {
		if (depth == m && cnt != 3)
			return;
		if (cnt == 3) {
			tmp = 0;
			simulation();
			answer = Math.max(answer, tmp);
			return;
		}
		selected[cnt] = depth;
		setArchor(depth + 1, cnt + 1);
		setArchor(depth + 1, cnt);
	}

	static void simulation() {
		tmpField = new int[n][m];
		for(int i = 0; i<n; i++)
			for(int j = 0; j<m; j++)
				tmpField[i][j] = field[i][j];
		
		int archorX = n;
		Set<Point> targets;
		for (int count = 0; count < n; count++) {
			targets  = new HashSet<>();
			for (int i = 0; i < 3; i++) {
				targets.add(getTarget(archorX, selected[i]));
			}
			for(Point t:targets) {
				if(t == null) continue;
				tmpField[t.x][t.y] = 0;
				tmp++;
			}
			archorX--;
		}
	}

	static Point getTarget(int ArchorX, int ArchorY) {
		boolean visit[][] = new boolean[n][m];
		visit[ArchorX - 1][ArchorY] = true;
		Queue<Point> q = new LinkedList<>();
		Point start = new Point(ArchorX - 1, ArchorY);
		start.depth = 1;
		q.add(start);
		while (!q.isEmpty()) {
			Point now = q.poll();
			if (now.depth == d + 1)
				continue;
			if (tmpField[now.x][now.y] == 1)
				return now;
			for (int i = 0; i < 3; i++) {
				int nx = now.x + mv[i][0];
				int ny = now.y + mv[i][1];
				if (nx < 0 || ny < 0 || ny >= m || visit[nx][ny])
					continue;
				Point next = new Point(nx, ny);
				next.depth = now.depth + 1;
				q.add(next);
			}
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		field = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		setArchor(0, 0);
		System.out.println(answer);
	}
}