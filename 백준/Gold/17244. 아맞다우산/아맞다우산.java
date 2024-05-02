import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x, y, bit;

	public Point(int x, int y, int bit) {
		this.x = x;
		this.y = y;
		this.bit = bit;
	}

}

public class Main {
	static int n, m;
	static int answer;
	static char[][] map;
	static int[] endPoint = new int[2];
	static boolean[][][] visit;
	static Queue<Point> q;
	static int xCount = 0;
	static ArrayList<Point> xPoints;
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		q = new LinkedList<>();
		visit = new boolean[m][n][32];
		xPoints = new ArrayList<>();

		map = new char[m][n];
		for (int i = 0; i < m; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'S') {
					q.add(new Point(i, j, 0));
					visit[i][j][0] = true;
				} else if (map[i][j] == 'X') {
					xPoints.add(new Point(i, j, xCount++));
				} else if(map[i][j] == 'E') {
					endPoint[0] = i;
					endPoint[1] = j;
				}
			}
		}
	}

	static void solve() {
		int time = 0;
		while(!q.isEmpty()) {
			int qs = q.size();
			while(qs-- != 0) {
				Point now = q.poll();
				if(now.x == endPoint[0] && now.y == endPoint[1] && now.bit == Math.pow(2, xCount)-1) {
					answer = time;
					System.out.println(answer);
					return;
				}
				for(int[] mv: move) {
					int nx = now.x+mv[0];
					int ny = now.y+mv[1];
					int nbit = now.bit;
					
					if(nx<0 || nx>=m || ny<0 || ny>=n || map[nx][ny] == '#') continue;
					if(map[nx][ny] == 'X') {
						for(Point p: xPoints) {
							if(p.x == nx && p.y == ny) {
								nbit |= (1<<p.bit);
								break;
							}
						}
					}
					if(visit[nx][ny][nbit]) continue;
					visit[nx][ny][nbit] = true;
					q.add(new Point(nx, ny, nbit));
				}
			}
			time++;
		}
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}