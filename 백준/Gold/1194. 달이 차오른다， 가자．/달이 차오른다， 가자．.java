import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x, y, key;
	int move;

	public Point(int x, int y, int key, int move) {
		this.x = x;
		this.y = y;
		this.key = key;
		this.move = move;
	}

	@Override
	public int hashCode() {
		return 10000*x+100*y+key;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Point))
			return false;
		Point tmp = (Point) obj;
		return Objects.equals(this.hashCode(), tmp.hashCode());
	}

	public int addKey(char a) {
		int bit = 1 << (a - 'a');
		if ((key ^ bit) < key)
			return key;
		int newkey = key ^ bit;
		return newkey;
	}

	public boolean hasKey(char a) {
		int bit = 1 << (a - 'A');
		if ((key ^ bit) < key)
			return true;
		return false;
	}

	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return move-o.move;
	}
	
	
}

public class Main {
	static int n, m;
	static char[][] map;
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Set<Point> visit = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		PriorityQueue<Point> q = new PriorityQueue<>();
		int result = -1;
		for (int i = 0; i < n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = tmp[j];
				if (map[i][j] == '0') {
					q.add(new Point(i, j, 0, 0));
					visit.add(new Point(i, j, 0, 0));
				}
			}
		}

		outer: while (!q.isEmpty()) {
			Point now = q.poll();
			for (int[] mv : move) {
				int nx = now.x + mv[0];
				int ny = now.y + mv[1];
				int nkey = now.key;
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == '#')
					continue;
				if(visit.contains(new Point(nx, ny, nkey, now.move))) continue;
				if (map[nx][ny] == '1') {
					result = now.move+1;
					break outer;
				} else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
					nkey = now.addKey(map[nx][ny]);
					//System.out.println("You got key about "+map[nx][ny]);
					//System.out.println("your Key : "+nkey);
				} else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
					if (!now.hasKey(map[nx][ny])) {
						//System.out.println("You dont have key for "+map[nx][ny]);
						continue;
					}
					//System.out.println("You have Key! Cong! : "+map[nx][ny]);
				}
				//System.out.println(nx+" "+ny+" "+nkey+" "+(now.move+1));
				visit.add(new Point(nx, ny, nkey, now.move + 1));
				q.add(new Point(nx, ny, nkey, now.move + 1));
			}
		}
		System.out.println(result);
	}

}
