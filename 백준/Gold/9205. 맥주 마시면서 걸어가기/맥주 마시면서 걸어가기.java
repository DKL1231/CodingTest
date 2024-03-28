import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int t;
	static int n;
	static Point home;
	static Point rock;
	static Point[] cu;
	static boolean[] visit;
	
	static int getDist(Point a, Point b) {
		return Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		while(t-- != 0) {
			n = Integer.parseInt(br.readLine());
			int x, y;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			home = new Point(x, y);
			cu = new Point[n];
			visit = new boolean[n];
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				cu[i] = new Point(x, y);
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			rock = new Point(x, y);
			
			Queue<Point> q = new LinkedList<Point>();
			
			if(getDist(home, rock) <= 1000)
				q.add(rock);
			
			for(int i = 0; i<n; i++) {
				if(getDist(home, cu[i]) <= 1000) {
					q.add(cu[i]);
					visit[i] = true;
				}
			}
			
			boolean result = false;
			
			while(!q.isEmpty()) {
				Point now = q.poll();
				if((now.x == rock.x && now.y == rock.y) || getDist(now, rock) <= 1000) {
					result = true;
					break;
				}
				for(int i = 0; i<n; i++) {
					if(!visit[i] && getDist(now, cu[i]) <= 1000) {
						q.add(cu[i]);
						visit[i] = true;
					}
				}
			}
			if(result) System.out.println("happy");
			else System.out.println("sad");
		}
	}
}
