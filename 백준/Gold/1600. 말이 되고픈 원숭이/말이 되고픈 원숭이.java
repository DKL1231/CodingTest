import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x, y, powerUsed;

	public Point(int x, int y, int powerUsed) {
		this.x = x;
		this.y = y;
		this.powerUsed = powerUsed;
	}
}

public class Main {
	static int k;
	static int w, h;
	static int[][] map;
	static int[][][] visit;
	static int[][] horseMove = { { -2, -1 }, { -2, +1 }, { -1, -2 }, { -1, +2 }, { +1, -2 }, { +1, +2 }, { +2, -1 },
			{ +2, +1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		k = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h][w];
		visit = new int[h][w][k + 1];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (h == 1 && w == 1) {
			System.out.println(0);
			return;
		}

		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0, 0));
		int[][] mv = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int tmp = 0;
		while (!q.isEmpty()) {
			int qSize = q.size();
			while (qSize-- != 0) {
				Point now = q.poll();
				for (int[] mov : mv) {
					int nx = now.x + mov[0];
					int ny = now.y + mov[1];
					if (nx < 0 || nx >= h || ny < 0 || ny >= w
							|| (visit[nx][ny][now.powerUsed] != 0 && visit[nx][ny][now.powerUsed] <= tmp + 1)
							|| map[nx][ny] == 1)
						continue;
					visit[nx][ny][now.powerUsed] = tmp + 1;
					q.add(new Point(nx, ny, now.powerUsed));
				}
				if (now.powerUsed < k) {
					for (int[] hm : horseMove) {
						int nx = now.x + hm[0];
						int ny = now.y + hm[1];
						if (nx < 0 || nx >= h || ny < 0 || ny >= w || (visit[nx][ny][now.powerUsed + 1] != 0
								&& visit[nx][ny][now.powerUsed + 1] <= tmp + 1) || map[nx][ny] == 1)
							continue;
						visit[nx][ny][now.powerUsed + 1] = tmp + 1;
						q.add(new Point(nx, ny, now.powerUsed + 1));
					}
				}
			}
			tmp++;
		}
		int answer = Integer.MAX_VALUE;

		for (int i = 0; i <= k; i++) {
			if(visit[h-1][w-1][i] != 0)
				answer = Math.min(answer, visit[h - 1][w - 1][i]);
		}
		System.out.println(answer == Integer.MAX_VALUE? -1 : answer);
	}
}