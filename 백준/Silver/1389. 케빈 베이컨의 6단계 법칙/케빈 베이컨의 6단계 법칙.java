import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int answer = -1;
	static ArrayList<ArrayList<Integer>> friends;
	static int[][] friendLevel;
	static boolean[] visit;

	static void initVisit() {
		for (int i = 1; i <= n; i++)
			visit[i] = false;
	}

	static void calAnswer() {
		int nowMin = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int tmp = 0;
			for (int j = 1; j <= n; j++)
				tmp += friendLevel[i][j];
			if (tmp < nowMin) {
				answer = i;
				nowMin = tmp;
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		friendLevel[start][start] = 0;
		visit[start] = true;

		int level = 0;
		while (!q.isEmpty()) {
			int qs = q.size();
			level++;
			while (qs-- != 0) {
				int now = q.poll();
				for (int next : friends.get(now)) {
					if (!visit[next]) {
						visit[next] = true;
						friendLevel[now][next] = Math.min(friendLevel[now][next], 1);
						friendLevel[next][now] = friendLevel[now][next];
						
						friendLevel[start][next] = Math.min(friendLevel[start][next], level);
						friendLevel[next][start] = friendLevel[start][next];
						q.add(next);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		friends = new ArrayList<>();
		friendLevel = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			friends.add(new ArrayList<>());
			for (int j = 0; j <= n; j++) {
				friendLevel[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends.get(a).add(b);
			friends.get(b).add(a);
		}

		for (int i = 1; i <= n; i++) {
			bfs(i);
			initVisit();
		}
		calAnswer();
		System.out.println(answer);
	}

}