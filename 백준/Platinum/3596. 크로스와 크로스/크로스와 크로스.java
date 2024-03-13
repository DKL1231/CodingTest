import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[2001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		
		// [x x x o] : dp[0]^dp[1] , [x x x x] : dp[0]^dp[0]
		// [x x x o o] : dp[0]^dp[2], [x x x x o] : dp[0]^dp[1], [x x x x x] : dp[0]^dp[0]
		for(int i = 4; i<=n; i++) {
			boolean tmp[]= new boolean[200];
			for(int j = 1; j<=(i+1)/2; j++) {
				int grundy = dp[Math.max(0, j-3)]^dp[Math.max(0, i-(j+2))];
				tmp[grundy] = true;
				//System.out.println(grundy+" "+Math.max(0, j-3)+" "+Math.max(0, i-(j+2)));
			}
			for(int j = 0; j<100; j++) {
				if(!tmp[j]) {
					dp[i] = j;
					break;
				}
			}
			//System.out.println(dp[i]);
		}
		if(dp[n] == 0)System.out.println(2);
		else System.out.println(1);
	}
}
