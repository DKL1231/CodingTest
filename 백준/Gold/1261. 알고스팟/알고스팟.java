import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int x, y;
	int weaponUsed;

	public Point(int x, int y, int weaponUsed) {
		this.x = x;
		this.y = y;
		this.weaponUsed = weaponUsed;
	}

	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return weaponUsed - o.weaponUsed;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
			return true;
		if (!(obj instanceof Point))
			return false;
		Point p = (Point) obj;
		return p.x == x && p.y == y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x+" "+y+" "+weaponUsed;
	}
	
}

public class Main {
	static int n, m;
	static int[][] map;
	static int[][] mv = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int answer = Integer.MAX_VALUE;
	static Map<Point, Integer> visit = new HashMap<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		for(int i = 0; i<m; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j = 0; j<n; j++) {
				map[i][j] = tmp[j]-'0';
			}
		}
		Point start = new Point(0, 0, 0);
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(start);
		visit.put(start, 0);
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			if(now.x == m-1 && now.y == n-1) {
				answer = now.weaponUsed;
				break;
			}
			for(int i = 0; i<4; i++) {
				int nx = now.x + mv[i][0];
				int ny = now.y + mv[i][1];
				if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
				
				int nw = now.weaponUsed;
				if(map[nx][ny] == 1) nw++;
				Point next = new Point(nx, ny, nw);
				if(visit.containsKey(next) && visit.get(next)<=nw) continue;
				visit.put(next, nw);
				pq.add(next);
			}
		}
		System.out.println(answer);
	}

}