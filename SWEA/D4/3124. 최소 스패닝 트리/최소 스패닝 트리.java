import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int from, to, w;
	public Edge(int from, int to, int w) {
		this.to = to;
		this.w = w;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return w-o.w;
	}
}

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			int v, e;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			boolean[] visit = new boolean[v+1];
			ArrayList<Edge>[] point = new ArrayList[v+1];
			for(int i = 0; i<=v; i++) point[i] = new ArrayList<>();
			long answer = 0;
			
			for(int i = 0; i<e; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a, b, c;
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				point[a].add(new Edge(a, b, c));
				point[b].add(new Edge(b, a, c));
			}
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			visit[1] = true;
			for(int i = 0; i<point[1].size(); i++) {
				pq.add(point[1].get(i));
			}
			while(!pq.isEmpty()) {
				Edge now = pq.poll();
				if(visit[now.to]) continue;
				visit[now.to] = true;
				answer += now.w;
				for(Edge edge:point[now.to]) {
					pq.add(edge);
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}