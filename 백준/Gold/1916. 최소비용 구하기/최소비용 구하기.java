import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int from, to, w;

	public Edge(int from, int to, int w) {
		this.from = from;
		this.to = to;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return w-o.w;
	}
	
}

class Main {
	static int n, m;
	static int visit[];
	static ArrayList<Edge>[] edges;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		visit = new int[n + 1];
		edges = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			edges[i] = new ArrayList<>();
			visit[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from, to, w;
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			edges[from].add(new Edge(from, to, w));
		}
		int start, end;
		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		visit[start] = 0;
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		for(int i = 0; i<edges[start].size(); i++)
			q.add(edges[start].get(i));
		while(!q.isEmpty()) {
			Edge now = q.poll();
			if(visit[now.to]>now.w) {
				visit[now.to] = now.w;
				for(int i = 0; i<edges[now.to].size(); i++) {
					Edge next = edges[now.to].get(i);
					q.add(new Edge(next.from, next.to, now.w+next.w));
				}
			}
		}
		System.out.println(visit[end]);
	}
}