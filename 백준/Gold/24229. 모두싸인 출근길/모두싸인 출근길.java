import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int from, to;

	public Point(int from, int to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return from==o.from?o.to-to:from-o.from;
	}
}

public class Main {
	static int n, m;
	static int answer = -1;
	static Point[] wood;
	static ArrayList<Point> swipedWood;
	
	static void dfs(int depth) {
		for(int i = depth+1; i<swipedWood.size(); i++) {
			Point next = swipedWood.get(i);
			int canJump = swipedWood.get(depth).to-swipedWood.get(depth).from;
			if(canJump+swipedWood.get(depth).to < next.from) break;
			if(canJump+swipedWood.get(depth).to >= next.from) {
				dfs(i);
			}
		}
		answer = Math.max(swipedWood.get(depth).to, answer);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		wood = new Point[n];
		swipedWood = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			wood[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(wood);
		int tmpStart = 0;
		int tmpEnd = wood[0].to;
		for(int i = 1; i<n; i++) {
			if(tmpStart<wood[i].from && tmpEnd>=wood[i].from) {
				tmpEnd = Math.max(tmpEnd, wood[i].to);
			}else if(tmpEnd < wood[i].from) {
				swipedWood.add(new Point(tmpStart, tmpEnd));
				tmpStart = wood[i].from;
				tmpEnd = wood[i].to;
			}
		}
		swipedWood.add(new Point(tmpStart, tmpEnd));
		
		
		
		dfs(0);
		
		System.out.println(answer);
	}

}