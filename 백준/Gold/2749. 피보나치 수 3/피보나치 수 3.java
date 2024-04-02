import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dp = new int[15*100000+1];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		dp[1] = 1;
		for(int i = 2; i<=1500000; i++) {
			dp[i] = (dp[i-1]+dp[i-2])%1000000; 
		}
		n -= n/(long)1500000*(long)1500000;
		System.out.println(dp[(int)n]);
	}

}
