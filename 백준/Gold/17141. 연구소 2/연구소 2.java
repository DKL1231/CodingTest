import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
	static int n, m;
	static int answer = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<Point> virus;
	static int virusCnt;
	static Point[] selected;
	
	static boolean[][] visit;
	static Queue<Point> q;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static void getInput() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new Point[m];
		map = new int[n][n];
		virus = new ArrayList<>();
		virusCnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus.add(new Point(i, j));
					virusCnt++;
				}
			}
		}
	}

	static void init() {
		q = new LinkedList<>();
		visit = new boolean[n][n];
	}

	static int bfs() {
		for(Point p:selected) {
			if(p == null) break;
			q.add(p);
			visit[p.x][p.y] = true;
		}

		int time = 0;
		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs-- != 0) {
				Point now = q.poll();
				for (int[] mv : move) {
					int nx = now.x + mv[0];
					int ny = now.y + mv[1];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] == 1 || visit[nx][ny])
						continue;
					q.add(new Point(nx, ny));
					visit[nx][ny] = true;
				}
			}
			time++;
		}
		if(checkVisit())
			return time-1;
		else
			return Integer.MAX_VALUE;
	}
	
	static boolean checkVisit() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(!visit[i][j] && map[i][j] != 1) return false;
			}
		}
		return true;
	}
	
	static void comb(int depth, int now) {
		if(depth == m) {
			init();
			answer = Math.min(answer, bfs());
			return;
		}
		
		for(int i = now+1; i<virusCnt; i++) {
			selected[depth] = virus.get(i);
			comb(depth+1, i);
		}
	}

	public static void main(String[] args) throws Exception {
		getInput();
		comb(0, -1);
		if(answer != Integer.MAX_VALUE)
			System.out.println(answer);
		else
			System.out.println(-1);
	}
}
