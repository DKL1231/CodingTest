import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	static int answer = Integer.MAX_VALUE;
	static int[][] map;
	static int houseCnt = 0, chickenCnt = 0;
	static ArrayList<Point> houses = new ArrayList<>();
	static ArrayList<Point> chickens = new ArrayList<>();
	static boolean[] selectedChicken;

	static int getDist(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	static void perm(int depth, int now) {
		if (now == m) {
			solve();
			return;
		}
		if(depth >= chickenCnt) return;
		selectedChicken[depth] = true;
		perm(depth + 1, now + 1);
		selectedChicken[depth] = false;
		perm(depth + 1, now);
	}

	static void solve() {
		int tmpAnswer = 0;
		for(int i = 0; i<houseCnt; i++) {
			Point nowHouse = houses.get(i);
			int tmp = Integer.MAX_VALUE;
			for(int j = 0; j<chickenCnt; j++) {
				if(selectedChicken[j]) {
					tmp = Math.min(tmp, getDist(nowHouse, chickens.get(j)));
				}
			}
			tmpAnswer += tmp;
		}
		answer = Math.min(answer, tmpAnswer);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					houses.add(new Point(i, j));
					houseCnt++;
				} else if (map[i][j] == 2) {
					chickens.add(new Point(i, j));
					chickenCnt++;
				}
			}
		}
		selectedChicken = new boolean[chickenCnt];
		perm(0, 0);
		System.out.println(answer);
	}
}