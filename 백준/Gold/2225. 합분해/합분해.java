import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int mod = 1_000_000_000;
	static int n, k;
	static long answer = 0;
	static long dp[][];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static void input() throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new long[500][500];
	}
	
	static void solve() {
		answer = comb(n+k-1, k-1);
	}
	
	static long comb(int n, int r) {
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
		if(r == 0 || n == r) {
			return dp[n][r] = 1;
		}
		
		return dp[n][r] = (comb(n-1, r-1) + comb(n-1, r))%mod;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		input();
		solve();
		System.out.println(answer);
	}

}