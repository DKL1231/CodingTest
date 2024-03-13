import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
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

class Main {
	static int n, m;
	static int start, end;
	static int parent[];
	static int visit[];
	static ArrayList<Edge> edges[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		visit = new int[n + 1];
		parent = new int[n + 1];
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
		
		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i = 0; i<edges[start].size(); i++) {
			pq.add(edges[start].get(i));
		}
		visit[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(now.w < visit[now.to]) {
				visit[now.to] = now.w;
				parent[now.to] = now.from;
				for(int i = 0; i<edges[now.to].size(); i++) {
					Edge tmp = edges[now.to].get(i);
					pq.add(new Edge(tmp.from, tmp.to, visit[now.to]+tmp.w));
				}
			}
		}
		Stack<Integer> answer = new Stack<>();
		answer.add(end);
		while(parent[answer.peek()] != 0) {
			answer.add(parent[answer.peek()]);
		}
		System.out.println(visit[end]);
		System.out.println(answer.size());
		while(!answer.isEmpty()) {
			System.out.print(answer.pop()+" ");
		}
		System.out.println();
	}
}