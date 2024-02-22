import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int n, start, answer = 0;

			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] person = new ArrayList[101];
			boolean[] visit = new boolean[101];

			for (int i = 0; i < 101; i++)
				person[i] = new ArrayList<>();

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n / 2; i++) {
				int from, to;
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				person[from].add(to);
			}

			Queue<Integer> q = new LinkedList<Integer>();
			q.add(start);
			visit[start] = true;

			while (!q.isEmpty()) {
				int qs = q.size();
				int tmp = 0;
				while (qs-- != 0) {
					int now = q.poll();
					for (int next : person[now]) {
						if (!visit[next]) {
							visit[next] = true;
							q.add(next);
							tmp = Math.max(tmp, next);
						}
					}
				}
				if (tmp != 0)
					answer = tmp;
			}

			System.out.println("#" + tc + " " + answer);
		}
	}
}