import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class AP implements Comparable<AP> {
	public int x, y, c, p;

	public AP(int x, int y, int c, int p) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.p = p;
	}

	@Override
	public int compareTo(AP o) {
		// TODO Auto-generated method stub
		return o.p - p;
	}
}

public class Solution {
	static int m, a;
	static int[][] mv = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	static Point[][] person;
	static AP[] APs;

	static int getP(int x1, int y1, int x2, int y2) {
		int doubleP = 0, p1P = 0, p2P = 0;
		int doubleP2 = doubleP;
		for (int i = 0; i < a; i++) {
			boolean p1 = isAvail(x1, y1, APs[i]);
			boolean p2 = isAvail(x2, y2, APs[i]);
			if (!p1 && !p2)
				continue;
			if (p1 && p2) {
				if (doubleP > APs[i].p && doubleP2 < APs[i].p) {
					doubleP2 = APs[i].p;
				} else if (doubleP < APs[i].p) {
					doubleP2 = doubleP;
					doubleP = APs[i].p;
				}
			} else if (!p1 && p2)
				p2P = Math.max(APs[i].p, p2P);
			else
				p1P = Math.max(APs[i].p, p1P);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		pq.add(doubleP);
		pq.add(doubleP2);
		pq.add(p1P);
		pq.add(p2P);
		return pq.poll() + pq.poll();
	}

	static boolean isAvail(int x, int y, AP b) {
		if ((Math.abs(x - b.x) + Math.abs(y - b.y)) > b.c)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			APs = new AP[a];
			person = new Point[2][m + 1];
			person[0][0] = new Point(1, 1);
			person[1][0] = new Point(10, 10);
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= m; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					person[i][j] = new Point(person[i][j - 1].x + mv[tmp][0], person[i][j - 1].y + mv[tmp][1]);
				}
			}
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				APs[i] = new AP(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			int answer = 0;
			for (int i = 0; i <= m; i++) {
				answer += getP(person[0][i].x, person[0][i].y, person[1][i].x, person[1][i].y);
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
