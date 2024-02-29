import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

//st = new StringTokenizer(br.readLine(), " ");

public class Main {
	static int n, l;
	static int map[][];
	static boolean visit[];
	static int answer = 0;

	static void check(int idx, boolean type) {// type true = horizontal/ false = vertical
		visit = new boolean[n];
		if (type) {
			for (int i = 0; i < n - 1; i++) {
				if (map[i][idx] > map[i + 1][idx]) {
					if (map[i][idx] - map[i + 1][idx] != 1)
						return;
					for (int j = 0; j < l; j++) {
						if (i+1 + j >= n)
							return;
						if (visit[i+1 + j])
							return;
						if (map[i+1 + j][idx] != map[i+1][idx])
							return;
						visit[i+1 + j] = true;
					}
				}
			}
			for (int i = n - 1; i > 0; i--) {
				if (map[i][idx] > map[i - 1][idx]) {
					if (map[i][idx] - map[i - 1][idx] != 1)
						return;
					for (int j = 0; j < l; j++) {
						if (i-1 - j < 0)
							return;
						if (visit[i-1 - j])
							return;
						if (map[i-1 - j][idx] != map[i-1][idx])
							return;
						visit[i-1 - j] = true;
					}
				}
			}
		} else {
			for (int i = 0; i < n - 1; i++) {
				if (map[idx][i] > map[idx][i + 1]) {
					if (map[idx][i] - map[idx][i + 1] != 1)
						return;
					for (int j = 0; j < l; j++) {
						if (i+1 + j >= n)
							return;
						if (visit[i+1 + j])
							return;
						if (map[idx][i+1 + j] != map[idx][i+1])
							return;
						visit[i+1 + j] = true;
					}
				}
			}
			for (int i = n - 1; i > 0; i--) {
				if (map[idx][i] > map[idx][i - 1]) {
					if (map[idx][i] - map[idx][i - 1] != 1)
						return;
					for (int j = 0; j < l; j++) {
						if (i-1 - j < 0)
							return;
						if (visit[i-1 - j])
							return;
						if (map[idx][i-1 - j] != map[idx][i-1])
							return;
						visit[i-1 - j] = true;
					}
				}
			}
		}
		answer++;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i<n; i++) {
			check(i, true);
			check(i, false);
		}
		System.out.println(answer);
	}
}