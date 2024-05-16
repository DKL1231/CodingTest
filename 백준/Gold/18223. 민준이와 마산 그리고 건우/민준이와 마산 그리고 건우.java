import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int to, weight;

	public Edge(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return weight - o.weight;
	}
}

public class Main {
	static int v, e, p;
	static ArrayList<Edge>[] edges;
	static int[] dist;
	static int[] pDist;
	static boolean[] visit;
	static boolean[] pVisit;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		edges = new ArrayList[v + 1];
		visit = new boolean[v + 1];
		pVisit = new boolean[v + 1];
		dist = new int[v + 1];
		pDist = new int[v + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(pDist, Integer.MAX_VALUE);

		for (int i = 0; i <= v; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			int from, to, w;
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			edges[from].add(new Edge(to, w));
			edges[to].add(new Edge(from, w));
		}
	}

	static boolean solve() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[1] = 0;
		visit[1] = true;
		for (Edge e : edges[1]) {
			pq.add(e);
			dist[e.to] = Math.min(dist[e.to], e.weight);
		}

		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (!visit[now.to]) {
				visit[now.to] = true;
				for (Edge e : edges[now.to]) {
					if (!visit[e.to] && dist[e.to] > e.weight + now.weight) {
						pq.add(new Edge(e.to, e.weight + now.weight));
						dist[e.to] = e.weight + now.weight;
					}
				}
			}
		}
		
		pq = new PriorityQueue<>();
		pDist[p] = 0;
		pVisit[p] = true;
		for (Edge e : edges[p]) {
			pq.add(e);
			pDist[e.to] = Math.min(pDist[e.to], e.weight);
		}

		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (!pVisit[now.to]) {
				pVisit[now.to] = true;
				for (Edge e : edges[now.to]) {
					if (!pVisit[e.to] && pDist[e.to] > e.weight + now.weight) {
						pq.add(new Edge(e.to, e.weight + now.weight));
						pDist[e.to] = e.weight + now.weight;
					}
				}
			}
		}
		
		if (dist[v] == dist[p] + pDist[v])
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		input();
		if (solve())
			System.out.println("SAVE HIM");
		else
			System.out.println("GOOD BYE");
	}
}