import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int answer = -1;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i<=n; i++) {
			dp[i] = (dp[i-1]+2*dp[i-2])%10007;
		}
		System.out.println(dp[n]);
	}

}