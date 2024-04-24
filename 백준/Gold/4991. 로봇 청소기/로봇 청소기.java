import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Point {
	int x, y, cleanedDust, dustCnt;

	public Point(int x, int y, int cleanedDust, int dustCnt) {
		this.x = x;
		this.y = y;
		this.cleanedDust = cleanedDust;
		this.dustCnt = dustCnt;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(x, y, cleanedDust);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Point))
			return false;
		Point p = (Point) obj;
		return (x == p.x && y == p.y && cleanedDust == p.cleanedDust);
	}

}

public class Main {
	static int w, h;
	static char[][] map;
	static int[][] dustIdx;
	static int[] cleaner = new int[2];
	static int dustCnt = 0;
	static Queue<Point> q;
	static Set<Point> visit;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static boolean getInput() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");

		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		if (w == 0 && h == 0)
			return false;

		map = new char[h][w];
		dustIdx = new int[h][w];
		dustCnt = 0;
		for (int i = 0; i < h; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < w; j++) {
				if (map[i][j] == 'o') {
					cleaner[0] = i;
					cleaner[1] = j;
				} else if (map[i][j] == '*') {
					dustIdx[i][j] = dustCnt++;
				}
			}
		}
		return true;
	}

	static void init() {
		q = new LinkedList<>();
		visit = new HashSet<>();
	}

	static int bfs() {
		Point startPoint = new Point(cleaner[0], cleaner[1], 0, 0);
		visit.add(startPoint);
		q.add(startPoint);

		int time = 0;
		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs-- != 0) {
				Point now = q.poll();
				if (dustCnt == now.dustCnt) {
					return time;
				}
				for (int[] mv : move) {
					int nx = now.x + mv[0];
					int ny = now.y + mv[1];
					int nCleanedDust = now.cleanedDust;
					int nDustCnt = now.dustCnt;
					if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == 'x')
						continue;
					if(map[nx][ny] == '*') {
						nCleanedDust = cleanDust(nCleanedDust, dustIdx[nx][ny]);
						if(nCleanedDust != now.cleanedDust) {
							nDustCnt++;
						}
					}
					Point next = new Point(nx, ny, nCleanedDust, nDustCnt);
					if(visit.contains(next)) continue;
					q.add(next);
					visit.add(next);
				}
			}
			time++;
		}
		return -1;
	}
	
	static int cleanDust(int code, int dustIdx) {
		return code | (1<<dustIdx);
	}

	public static void main(String[] args) throws Exception {
		while (getInput()) {
			init();
			System.out.println(bfs());
		}
	}
}
