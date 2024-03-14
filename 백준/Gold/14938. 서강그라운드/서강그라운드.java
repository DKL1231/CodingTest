import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int from, to, w;

	public Edge(int to, int w) {
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
	static int n,m,r;
	static int[] items;
	static int[][] visit;
	static ArrayList<Edge>[] edges;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		items = new int[n+1];
		visit = new int[n+1][n+1];
		edges = new ArrayList[n+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i<=n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
			edges[i] = new ArrayList<>();
			for(int j = 1; j<=n; j++)
				visit[i][j] = Integer.MAX_VALUE;
		}
		for(int i = 0; i<r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[from].add(new Edge(to, w));
			edges[to].add(new Edge(from, w));
		}
		
		int answer = 0;
		for(int start = 1; start<=n; start++) {
			visit[start][start] = 0;
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for(Edge e:edges[start]) {
				pq.add(e);
			}
			int tmp = 0;
			while(!pq.isEmpty()) {
				Edge now = pq.poll();
				if(visit[start][now.to] > now.w) {
					visit[start][now.to] = now.w;
					for(Edge e:edges[now.to]) {
						pq.add(new Edge(e.to, e.w+visit[start][now.to]));
					}
				}
			}
			for(int i = 1; i<=n; i++) {
				if(visit[start][i] <= m) tmp += items[i];
			}
			answer = Math.max(tmp, answer);
		}
		System.out.println(answer);
	}
}