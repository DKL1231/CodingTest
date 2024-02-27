import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int from, to, w;

	public Edge(int from, int to, int w) {
		this.from = from;
		this.to = to;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return w - o.w;
	}

}

public class Main {
	static int v, e;
	static int k;
	static int[] answer;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		answer = new int[v + 1];
		visit = new boolean[v + 1];
		Arrays.fill(answer, Integer.MAX_VALUE);

		ArrayList<Edge>[] points = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++) {
			points[i] = new ArrayList<>();
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from, to, w;
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			points[from].add(new Edge(from, to, w));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		answer[k] = 0;
		visit[k] = true;
		for (int i = 0; i < points[k].size(); i++) {
			pq.add(points[k].get(i));
		}
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			answer[now.to] = Math.min(answer[now.to], now.w);
			if (!visit[now.to]) {
				visit[now.to] = true;
				for (Edge e : points[now.to]) {
					if (answer[e.to] > answer[e.from] + e.w)
						pq.add(new Edge(e.from, e.to, answer[e.from] + e.w));
				}
			}
		}
		for (int i = 1; i <= v; i++) {
			if (answer[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(answer[i]);
		}
	}
}