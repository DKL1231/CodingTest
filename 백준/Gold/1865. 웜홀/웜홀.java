import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

class Edge {
	int from, to, w;

	public Edge(int from, int to, int w) {
		this.from =from;
		this.to = to;
		this.w = w;
	}
}

public class Main {
	static int tc;
	static int n, m, w;
	static ArrayList<Edge> edges;
	static int[] visit;

	static boolean bellmanFord(int start) {
		int[] nowvisit = new int[n+1]; 
		for (int i = 0; i <= n; i++) {
			nowvisit[i] = Integer.MAX_VALUE;
		}
		nowvisit[start] = 0;
		visit[start] = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<edges.size(); j++) {
				Edge nowEdge = edges.get(j);
				int from = nowEdge.from, to = nowEdge.to, w = nowEdge.w;
				if(nowvisit[from] != Integer.MAX_VALUE && nowvisit[to] > nowvisit[from]+w) {
					nowvisit[to] = nowvisit[from] + w;
					visit[to] = nowvisit[to];
					if(i == n-1) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	static void printvisit() {
		for(int i = 1; i<=n; i++) System.out.print(visit[i]+" ");
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
						
			visit = new int[n + 1];
			edges = new ArrayList<>();
			
			for(int i = 0; i<=n; i++) visit[i] = Integer.MAX_VALUE;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edges.add(new Edge(from, to, w)); 
				edges.add(new Edge(to, from, w)); 
			}
			for (int i = 0; i < Main.w; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edges.add(new Edge(from, to, -w));
			}
			
			boolean flag = false;
			for(int i = 1; i<=n; i++) {
				if(visit[i] == Integer.MAX_VALUE) {
					if(bellmanFord(i)) {
						flag = true;
						break;
					}
				}
			}
			if(flag) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
