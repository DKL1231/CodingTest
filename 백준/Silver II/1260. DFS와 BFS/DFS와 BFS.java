import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static PriorityQueue<Integer>[] linesForBFS;
	static PriorityQueue<Integer>[] linesForDFS;
	static boolean[] visit;
	static StringBuilder sb;
	
	static void dfs(int n) {
		sb.append(n+" ");
		visit[n] = true;
		while(!linesForDFS[n].isEmpty()) {
			int next = linesForDFS[n].poll();
			if(!visit[next]) {
				dfs(next);
			}
		}
	}
	
	static void bfs(int n) {
		sb.append(n+" ");
		visit[n] = true;
		Queue<Integer> q = new LinkedList<>();
		
		q.add(n);
		while(!q.isEmpty()) {
			int now = q.poll();
			while(!linesForBFS[now].isEmpty()) {
				int next = linesForBFS[now].poll();
				if(!visit[next]) {
					visit[next] = true;
					q.add(next);
					sb.append(next+" ");
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		linesForBFS = new PriorityQueue[N+1];
		linesForDFS = new PriorityQueue[N+1];
		for(int i = 1; i<=N; i++) {
			linesForBFS[i] = new PriorityQueue<>();
			linesForDFS[i] = new PriorityQueue<>();
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			linesForBFS[a].add(b);
			linesForBFS[b].add(a);
			linesForDFS[a].add(b);
			linesForDFS[b].add(a);
		}
		
		sb = new StringBuilder();
		visit = new boolean[N+1];
		dfs(V);
		System.out.println(sb.toString());
		
		sb = new StringBuilder();
		visit = new boolean[N+1];
		bfs(V);
		System.out.println(sb.toString());
	}
}