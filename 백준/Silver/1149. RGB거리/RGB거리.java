import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j] = map[i][j] + Math.min(map[i - 1][(j + 1) % 3], map[i - 1][(j + 2) % 3]);
			}
		}
		System.out.println(Math.min(map[n - 1][0], Math.min(map[n - 1][1], map[n - 1][2])));
	}
}