import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int x, originIdx, type;

	public Point(int x, int type, int originIdx) {
		this.x = x;
		this.type = type; // 1이 (, 2가 )
		this.originIdx = originIdx;
	}

	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		if(x == o.x) return type-o.type;
		return x - o.x;
	}
}

public class Main {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int mid = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			pq.add(new Point(mid-r, 1, i));
			pq.add(new Point(mid+r, 2, i));
		}
		Stack<Point> stk = new Stack<>();
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			if(now.type == 1) {
				stk.push(now);
			}else {
				if(stk.isEmpty() || stk.peek().originIdx != now.originIdx) {
					System.out.println("NO");
					return;
				}
				stk.pop();
			}
		}
		System.out.println("YES");
	}
}
