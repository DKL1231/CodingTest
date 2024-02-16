import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int r, c;
	static char[][] field;
	static int[][] mv = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[] passed = new boolean[26];
	static int answer = 0;
	
	static void dfs(int depth, int x, int y) {
		answer = Math.max(depth, answer);
		for (int i = 0; i < 4; i++) {
			int nx = x + mv[i][0];
			int ny = y + mv[i][1];
			if (nx < 0 || nx >= r || ny < 0 || ny >= c || passed[field[nx][ny]-'A'])
				continue;
			passed[field[nx][ny]-'A'] = true;
			dfs(depth+1, nx, ny);
			passed[field[nx][ny]-'A'] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		field = new char[r][c];
		for (int i = 0; i < r; i++) {
			field[i] = br.readLine().toCharArray();
		}
		passed[field[0][0]-'A'] = true;
		dfs(1, 0, 0);
		System.out.println(answer);
	}
}