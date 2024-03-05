import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int x, y, time;

	public Point(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}

	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		if (time != o.time)
			return time - o.time;
		if (x == o.x)
			return y - o.y;
		return x - o.x;
	}

}

class Main {
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int answer = 0;
	static PriorityQueue<Point> q;
	static int[] fishCnt = new int[7];
	static int sharkSize = 2;
	static int sharkX, sharkY;
	static int sharkEat = 0;
	static int[][] move = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	static boolean bfs() {
		if (!checkCanEat())
			return false;

		q = new PriorityQueue<Point>();
		visit = new boolean[n][n];
		q.add(new Point(sharkX, sharkY, 0));
		visit[sharkX][sharkY] = true;

		while (!q.isEmpty()) {
			Point now = q.poll();
			if (map[now.x][now.y] != 0 && map[now.x][now.y] < sharkSize) {
				answer += now.time;
				fishCnt[map[now.x][now.y]]--;
				map[now.x][now.y] = 0;
				if (++sharkEat == sharkSize) {
					sharkSize++;
					sharkEat = 0;
				}
				sharkX = now.x;
				sharkY = now.y;
				return true;
			}
			for (int[] mv : move) {
				int nx = now.x + mv[0];
				int ny = now.y + mv[1];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || map[nx][ny] > sharkSize)
					continue;
				visit[nx][ny] = true;
				q.add(new Point(nx, ny, now.time + 1));
			}
		}
		return false;
	}

	static boolean checkCanEat() {
		for (int i = 1; i < Math.min(sharkSize, 7); i++)
			if (fishCnt[i] != 0)
				return true;
		return false;
	}

	static void printMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
				} else if (map[i][j] > 0) {
					fishCnt[map[i][j]]++;
				}
			}
		}
		while (bfs()) {
			//printMap();
			//System.out.println();
		}
		System.out.println(answer);
	}
}