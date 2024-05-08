import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Road implements Comparable<Road> {
	int to, w;

	public Road(int to, int w) {
		this.to = to;
		this.w = w;
	}

	@Override
	public int compareTo(Road o) {
		// TODO Auto-generated method stub
		return w - o.w;
	}

}

public class Main {
	static int n, m;
	static boolean visit[];
	static ArrayList<Road>[] roads;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visit = new boolean[n + 1];
		roads = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			roads[i] = new ArrayList<Road>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a, b, c;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			roads[a].add(new Road(b, c));
			roads[b].add(new Road(a, c));
		}
	}

	static void bfs() {
		PriorityQueue<Road> pq = new PriorityQueue<>();
		for (Road r : roads[1])
			pq.add(r);
		visit[1] = true;
		while (!pq.isEmpty()) {
			Road now = pq.poll();
			if (now.to == n) {
				System.out.println(now.w);
				return;
			}
			if (!visit[now.to]) {
				visit[now.to] = true;
				for (Road r : roads[now.to]) {
					pq.add(new Road(r.to, now.w + r.w));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		bfs();
	}
}