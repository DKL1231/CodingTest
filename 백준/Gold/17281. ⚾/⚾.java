import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] personHit;
	static int[] personLineUp;
	static boolean[] visit;
	static int answer = 0;

	static void dfs(int depth) {
		if (depth == 3)
			depth++;
		if (depth == 9) {
			simulation();
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (!visit[i]) {
				visit[i] = true;
				personLineUp[depth] = i;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}

	static void simulation() {
		int ptr = 0;
		int point = 0;
		for (int inning = 0; inning < n; inning++) {
			int outCnt = 0;
			int[] nowBase = new int[9];
			while (outCnt != 3) {
				int nowType = personHit[inning][personLineUp[ptr]];
				switch (nowType) {
				case 0:
					outCnt++;
					break;
				default:
					for (int i = 0; i < 9; i++) {
						if (nowBase[i] != 0) {
							nowBase[i] += nowType;
							if (nowBase[i] > 3) {
								point++;
								nowBase[i] = 0;
							}
						}
					}
					if (nowType == 4)
						point++;
					else
						nowBase[personLineUp[ptr]] = nowType;
				}
				ptr++;
				ptr %= 9;
			}
		}
		answer = Math.max(answer, point);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		personHit = new int[n][9];
		personLineUp = new int[9];
		visit = new boolean[9];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				personHit[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		personLineUp[3] = 0;
		visit[0] = true;
		dfs(0);
		System.out.println(answer);
	}
}