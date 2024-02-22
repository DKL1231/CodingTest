import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int answer = 5;
	static int[] dp;
	static int[] squares;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int maxIndex = (int) Math.round(Math.sqrt(n));
		squares = new int[maxIndex+1];
		dp = new int[n + 1];
		for (int i = 1; i <= maxIndex; i++)
			squares[i] = i * i;
		for(int i = 1; i<=n; i++) dp[i] = Integer.MAX_VALUE; 
		for (int i = 1; i <= maxIndex; i++) {
			for (int j = squares[i]; j <= n; j++) {
				dp[j] = Math.min(dp[j], dp[j-squares[i]]+1);
			}
		}

		System.out.println(dp[n]);
	}

}