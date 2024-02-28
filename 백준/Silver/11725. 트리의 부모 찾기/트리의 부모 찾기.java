import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//st = new StringTokenizer(br.readLine(), " ");
class Node {
	int parent;
	ArrayList<Integer> connected = new ArrayList<>();
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[n + 1];
		for (int i = 1; i <= n; i++) {
			nodes[i] = new Node();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nodes[a].connected.add(b);
			nodes[b].connected.add(a);
		}
		boolean[] visit = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visit[1] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next: nodes[now].connected) {
				if(!visit[next]) {
					visit[next] = true;
					nodes[next].parent = now;
					q.add(next);
				}
			}
		}
		for(int i = 2; i<=n; i++) System.out.println(nodes[i].parent);
	}
}