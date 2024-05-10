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
	int key;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int t;
	static int h, w;

	static char[][] map;
	static boolean[][] stolenVisit;
	static int initialKeyValue;
	static int nowKeyValue;
	static Queue<Point> q;
	static Queue<Point> nextPoint;
	static boolean visit[][];
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		map = new char[h][w];
		stolenVisit = new boolean[h][w];
		visit = new boolean[h][w];
		q = new LinkedList<>();
		nextPoint = new LinkedList<>();
		for (int i = 0; i < h; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < w; j++) {
				map[i][j] = tmp[j];
			}
		}

		initialKeyValue = 0;
		String key = br.readLine().trim();

		if (key.charAt(0) == '0')
			return;

		for (char c : key.toCharArray()) {
			initialKeyValue += (1 << (c - 'a'));
		}
	}

	static boolean hasKey(int nowCode, char alpha) {
		return ((nowCode & (1 << (alpha - 'A'))) != 0);
	}

	static int addKey(int nowCode, char alpha) {
		return ((nowCode | (1 << (alpha - 'a'))));
	}

	static void addValue(int x, int y) {
		if(visit[x][y]) return;
		if (map[x][y] == '$') {
			q.add(new Point(x, y));
			visit[x][y] = true;
			stolenVisit[x][y] = true;
		} else if (map[x][y] == '.') {
			q.add(new Point(x, y));
			visit[x][y] = true;
		} else if(map[x][y] >= 'a' && map[x][y] <= 'z') {
			initialKeyValue = addKey(initialKeyValue, map[x][y]);
			q.add(new Point(x, y));
			visit[x][y] = true;
		} else if (!hasKey(initialKeyValue, map[x][y])) {
			nextPoint.add(new Point(x, y));
		} else {
			q.add(new Point(x, y));
			visit[x][y] = true;
		}
	}

	static void enterBuilding() {
		for (int i = 0; i < w; i++) {
			if (map[0][i] != '*') {
				addValue(0, i);
			}
			if (map[h - 1][i] != '*') {
				addValue(h - 1, i);
			}
		}

		for (int i = 0; i < h; i++) {
			if (map[i][0] != '*') {
				addValue(i, 0);
			}
			if (map[i][w - 1] != '*') {
				addValue(i, w - 1);
			}
		}
	}

	static void bfs() {
		enterBuilding();
		nowKeyValue = initialKeyValue;
		int prevKey = initialKeyValue;
		while(!q.isEmpty()) {
			bfsWithKey(nowKeyValue);
			//printKeyValue();
			if(prevKey == nowKeyValue) break;
			prevKey = nowKeyValue;
			while(!nextPoint.isEmpty()) {
				q.add(nextPoint.poll());
			}
		}
	}
	
	static void printKeyValue() {
		for(int i = 0; i<26; i++) {
			if((nowKeyValue & (1<<i)) != 0) {
				System.out.print((char)('a'+i));
			}
		}
		System.out.println();
	}
	
	static void bfsWithKey(int nowKey) {
		enterBuilding();
		while (!q.isEmpty()) {
			Point now = q.poll();
			if (map[now.x][now.y] >= 'A' && map[now.x][now.y] <= 'Z') {
				if (!hasKey(nowKey, map[now.x][now.y])) {
					nextPoint.add(new Point(now.x, now.y));
					continue;
				}
			}
			for (int[] mv : move) {
				int nx = now.x + mv[0];
				int ny = now.y + mv[1];
				if (nx < 0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] == '*' || visit[nx][ny])
					continue;

				if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
					if (!hasKey(nowKey, map[nx][ny])) {
						nextPoint.add(new Point(nx, ny));
						continue;
					}
				} else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
					nowKeyValue = addKey(nowKeyValue, map[nx][ny]);
				} else if (map[nx][ny] == '$') {
					stolenVisit[nx][ny] = true;
				}
				Point next = new Point(nx, ny);
				visit[nx][ny] = true;
				q.add(next);

			}
		}
	}

	static int getResult() {
		int answer = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (stolenVisit[i][j])
					answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		t = Integer.parseInt(br.readLine());
		while (t-- != 0) {
			input();
			bfs();
			System.out.println(getResult());
		}
	}

}