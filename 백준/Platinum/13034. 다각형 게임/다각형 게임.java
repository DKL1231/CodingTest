import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;

		for (int i = 3; i <= n; i++) {
			boolean mex[] = new boolean[i + 1];
			for (int j = 0; j <= i / 2; j++) {
				int tmp = dp[j] ^ dp[i - 2 - j];
				mex[tmp] = true;

			}
			for (int j = 0; j <= i; j++)
				if (!mex[j]) {
					dp[i] = j;
					break;
				}
		}
		if (dp[n] == 0)
			System.out.println(2);
		else
			System.out.println(1);
	}
}
