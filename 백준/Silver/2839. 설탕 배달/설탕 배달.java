import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		N = Integer.parseInt(br.readLine());

		int[] dp = new int[5001];

		dp[3] = 1;
		dp[5] = 1;
		for (int i = 6; i <= N; i++) {
			int tmp3 = Integer.MAX_VALUE;
			int tmp5 = Integer.MAX_VALUE;
			if (i >= 5) {
				if (dp[i - 3] > 0) {
					tmp3 = dp[i - 3] + 1;
				}
				if (dp[i - 5] > 0) {
					tmp5 = dp[i - 5] + 1;
				}
			}
			dp[i] = Math.min(tmp3, tmp5);
			if (dp[i] == Integer.MAX_VALUE)
				dp[i] = 0;
		}
		if (dp[N] == 0)
			System.out.println(-1);
		else
			System.out.println(dp[N]);
	}
}