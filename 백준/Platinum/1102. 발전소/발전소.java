import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int code, depth, weight;

	public Point(int code, int depth, int weight) {
		this.code = code;
		this.depth = depth;
		this.weight = weight;
	}

	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return weight - o.weight;
	}

	@Override
	public String toString() {
		return "Point [code=" + code + ", depth=" + depth + ", weight=" + weight + "]";
	}

}

public class Main {
	static int n;

	static int beginCode = 0;
	static int beginOn = 0;
	static int dp[];
	static int[][] map;
	static int goal = 0;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		dp = new int[(int) Math.pow(2, n)];
		Arrays.fill(dp, Integer.MAX_VALUE);
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		char[] tmp = br.readLine().toCharArray();
		for (int i = 0; i < n; i++) {
			if (tmp[i] == 'Y') {
				beginCode |= (1 << i);
				beginOn++;
			}
		}

		goal = Integer.parseInt(br.readLine());
	}

	static int bfs() {
		if (beginOn >= goal)
			return 0;
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(beginCode, beginOn, 0));

		while (!pq.isEmpty()) {
			Point now = pq.poll();
			if (now.depth >= goal) {
				return now.weight;
			}
			if (dp[now.code] == Integer.MAX_VALUE) {
				dp[now.code] = now.weight;
				for (int i = 0; i < n; i++) {
					if ((now.code & (1 << i)) != 0) {
						for (int j = 0; j < n; j++) {
							if ((now.code & (1 << j)) == 0) {
								pq.add(new Point((now.code | (1 << j)), now.depth + 1, now.weight + map[i][j]));
							}
						}
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(bfs());
	}
}