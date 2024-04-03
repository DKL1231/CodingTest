import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 10000;
	static int n, m;
	static int student[];
	static int visit[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visit = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(visit[i], MAX);
			visit[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			int from, to;
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());

			visit[from][to] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;
					if (visit[i][j] > visit[i][k] + visit[k][j]) {
						visit[i][j] = visit[i][k] + visit[k][j];
					}
				}
			}
		}


		int answer = 0;
		for (int i = 1; i <= n; i++) {
			boolean flag = true;
			for (int j = 1; j <= n; j++) {
				if (visit[j][i] == MAX) {
					if (visit[i][j] == MAX) {
						flag = false;
						break;
					}
				}
			}
			if (flag)
				answer++;
		}
		System.out.println(answer);
	}
}
