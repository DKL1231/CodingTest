import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		BigInteger[] dp = new BigInteger[31];
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		for(int i = 2; i<=30; i++) dp[i] = dp[i-1].multiply(new BigInteger(""+i));
		for(int tc = 1; tc<=t; tc++) {
			int n, m;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			System.out.println(dp[m].divide(dp[n].multiply(dp[m-n])));
		}
		
	}
}