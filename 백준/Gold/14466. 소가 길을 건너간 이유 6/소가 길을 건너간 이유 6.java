import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this == obj) return true;
		if(!(obj instanceof Point)) return false;
		Point tmp = (Point) obj;
		return (tmp.x == this.x && tmp.y == this.y);
	}
	
	
}

public class Main {
	static int n, k, r;
	static boolean map[][];
	static boolean isCow[][];
	static Map<Point, ArrayList<Point>> roads = new HashMap<>();
	static ArrayList<Integer> cowCnt = new ArrayList<>();
	
	static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static void pushMap(Point from, Point to) {
		if(roads.containsKey(from)) {
			roads.get(from).add(to);
		}else {
			ArrayList<Point> tmp = new ArrayList<>();
			tmp.add(to);
			roads.put(from, tmp);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new boolean[n+1][n+1];
		isCow = new boolean[n+1][n+1];
		
		for(int i = 0; i<r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int fx, fy, tx, ty;
			fx = Integer.parseInt(st.nextToken());
			fy = Integer.parseInt(st.nextToken());
			tx = Integer.parseInt(st.nextToken());
			ty = Integer.parseInt(st.nextToken());
			
			Point from = new Point(fx, fy);
			Point to = new Point(tx, ty);
			pushMap(from, to);
			pushMap(to, from);
		}
		
		for(int i = 0; i<k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x, y;
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			isCow[x][y] = true;
		}
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				if(map[i][j]) continue;
				int nowCow = 0;
				Queue<Point> q = new LinkedList<>();
				q.add(new Point(i, j));
				map[i][j] = true;
				while(!q.isEmpty()) {
					Point now = q.poll();
					if(isCow[now.x][now.y]) nowCow++;
					for(int[] mv:move) {
						int nx = now.x+mv[0];
						int ny = now.y+mv[1];
						if(nx<1 || ny<1 || nx>n || ny>n || map[nx][ny]) continue;
						boolean flag = true;
						if(roads.containsKey(now)) {
							ArrayList<Point> tmp = roads.get(now);
							for(Point p:tmp) {
								if(p.x == nx && p.y == ny) {
									flag = false;
									break;
								}
							}
						}
						if(flag) {
							map[nx][ny] = true;
							q.add(new Point(nx, ny));
						}
					}
				}
				cowCnt.add(nowCow);
			}
		}
		
		int answer = 0;
		for(int i = 0; i<cowCnt.size(); i++) {
			for(int j = i+1; j<cowCnt.size(); j++) {
				answer += cowCnt.get(i)*cowCnt.get(j);
			}
		}
		System.out.println(answer);
	}
}
