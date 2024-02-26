import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x : "+x+", y : "+y;
	}
	
}

public class Main {
	static int r, c;
	static int[][] mv = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static boolean[][] visitForBFS;
	static boolean[][] visitForIce;
	static Point person1, person2;
	static Queue<Point> changedTrueBesideIce = new LinkedList<>();

	static boolean BFS() {
		Queue<Point> q = new LinkedList<>();
		while (!changedTrueBesideIce.isEmpty()) {
			q.add(changedTrueBesideIce.poll());
		}

		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs-- != 0) {
				Point now = q.poll();
				if (now.x == person2.x && now.y == person2.y)
					return true;
				for (int i = 0; i < 4; i++) {
					int nx = now.x + mv[i][0];
					int ny = now.y + mv[i][1];
					if (nx < 0 || nx >= r || ny < 0 || ny >= c || visitForBFS[nx][ny])
						continue;
					if(map[nx][ny] == 'X') {
						changedTrueBesideIce.add(new Point(nx, ny));
						visitForBFS[nx][ny] = true;
						continue;
					}
					visitForBFS[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
		return false;
	}
	
	static void printMap() {
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		visitForIce = new boolean[r][c];
		visitForBFS = new boolean[r][c];
		Queue<Point> q = new LinkedList<>();

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'L') {
					if (person1 == null) {
						person1 = new Point(i, j);
						visitForBFS[person1.x][person1.y] = true;
						changedTrueBesideIce.add(person1);
						q.add(person1);
					} else {
						person2 = new Point(i, j);
						q.add(person2);
					}
				} else if (map[i][j] == '.') {
					visitForIce[i][j] = true;
					q.add(new Point(i, j));
				}
			}
		}

		int answer = 0;
		while (!q.isEmpty()) {
			int qs = q.size();
			if (BFS()) {
				System.out.println(answer);
				return;
			}
			while (qs-- != 0) {
				Point now = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = now.x + mv[i][0];
					int ny = now.y + mv[i][1];
					if (nx < 0 || nx >= r || ny < 0 || ny >= c || visitForIce[nx][ny])
						continue;
					visitForIce[nx][ny] = true;
					if(map[nx][ny] == 'X') {
						map[nx][ny] = '.';
					}
					q.add(new Point(nx, ny));
					

				}
			}
			answer++;
		}
		System.out.println(0);
	}
}