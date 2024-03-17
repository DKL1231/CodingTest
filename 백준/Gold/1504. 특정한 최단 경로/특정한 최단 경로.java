import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int to, w;

	public Edge(int to, int w) {
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
	static int n, e;
	static ArrayList<Edge>[] edges;
	static int[][] weight;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		edges = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			edges[i] = new ArrayList<>();
		weight = new int[n + 1][n + 1];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a, b, c;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			edges[a].add(new Edge(b, c));
			edges[b].add(new Edge(a, c));
		}

		int u, v;
		st = new StringTokenizer(br.readLine());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		calDist(1);
		calDist(u);
		calDist(v);
		
		
		int result = Math.min(weight[1][u] + weight[u][v] + weight[v][n], weight[1][v] + weight[v][u] + weight[u][n]);
		System.out.println(result>800*200000?-1:result);
	}

	static void calDist(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 1; i <= n; i++)
			weight[start][i] = 800*200000+1;
		weight[start][start] = 0;
		for (Edge e : edges[start]) {
			pq.add(e);
		}

		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (weight[start][now.to] > now.w) {
				weight[start][now.to] = now.w;
				for (Edge e : edges[now.to]) {
					pq.add(new Edge(e.to, e.w + now.w));
				}
			}
		}
	}
}
