import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static boolean[] visit;

	static void dfs(int now, int base) {
		for (int i = 0; i < n; i++) {
			if (map[now][i] == 1)
				map[base][i] = map[now][i];
		}
		for (int i = 0; i < n; i++) {
			if(visit[i]) continue;
			if (map[now][i] == 1) {
				visit[i] = true;
				dfs(i, base);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			visit = new boolean[n];
			visit[i] = true;
			dfs(i, i);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}