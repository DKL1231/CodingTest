import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
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
		return x + " " + y;
	}

}

class Edge implements Comparable<Edge> {
	int from, to;
	double w;

	public Edge(int from, int to, double w) {
		this.from = from;
		this.to = to;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		if (w - o.w <= 0)
			return -1;
		return 1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SelectedEdge:"+from+" "+to+" "+w;
	}
	
}

public class Solution {
	static int n;
	static double e;
	static double answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			n = Integer.parseInt(br.readLine());
			boolean[] visit = new boolean[n];
			Point[] islands = new Point[n];
			StringTokenizer st;
			int[] xPoint = new int[n];
			int[] yPoint = new int[n];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++)
				xPoint[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++)
				yPoint[i] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < n; i++) {
				islands[i] = new Point(xPoint[i], yPoint[i]);
			}
			
			e = Double.parseDouble(br.readLine());
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			visit[0] = true;
			for (int i = 0; i < n; i++) {
				if (visit[i])
					continue;
				pq.add(new Edge(0, i,
						Math.pow(islands[0].x - islands[i].x, 2) + Math.pow(islands[0].y - islands[i].y, 2)));
			}
			while (!pq.isEmpty()) {
				Edge nowEdge = pq.poll();
				if(visit[nowEdge.to]) continue;
				answer += nowEdge.w;
				Point now = islands[nowEdge.to];
				visit[nowEdge.to] = true;
				for (int i = 0; i < n; i++) {
					if (visit[i])
						continue;
					Point next = islands[i];
					pq.add(new Edge(nowEdge.to, i, Math.pow(now.x - next.x, 2) + Math.pow(now.y - next.y, 2)));
				}
			}
			System.out.println("#" + tc + " " + Math.round(answer * e));
		}
	}
}