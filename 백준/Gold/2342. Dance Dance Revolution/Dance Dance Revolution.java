import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int[] ddrMove;
	static int[][][] ddrDP;
	static int pastLeft = 0, pastRight = 0;

	static int getPoint(int from, int to) {
		if (to == 0)
			return 0;
		if (from == 0)
			return 2;
		if (from == to)
			return 1;
		if (Math.abs(from - to) == 2)
			return 4;
		return 3;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ddrDP = new int[st.countTokens()][5][5];
		ddrMove = new int[st.countTokens()];
		int tmp = st.countTokens();
		for (int i = 0; i < tmp; i++) {
			int next = Integer.parseInt(st.nextToken());
			ddrMove[i] = next;
			if (i == 0) {
				ddrDP[i][0][next] = 2;
				ddrDP[i][next][0] = 2;
			} else {
				for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						if (ddrDP[i - 1][j][k] == 0)
							continue;
						else {
							int beforeValue = ddrDP[i - 1][j][k];
							ddrDP[i][j][next] = ddrDP[i][j][next] == 0 ? beforeValue + getPoint(k, next)
									: Math.min(ddrDP[i][j][next], beforeValue + getPoint(k, next));
							ddrDP[i][next][k] = ddrDP[i][next][k] == 0 ? beforeValue + getPoint(j, next)
									: Math.min(ddrDP[i][next][k], beforeValue + getPoint(j, next));
						}
					}
				}
			}
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (ddrDP[tmp - 1][i][j] == 0)
					continue;
				answer = Math.min(answer, ddrDP[tmp - 1][i][j]);
			}
		}

		System.out.println(answer);
	}
}