import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int changeGrundy(int a) {
		if(a%4 == 0) return a-1;
		if(a%4 == 3) return a+1;
		return a;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] stones = new int[n+1];
		
		/*
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2; // 0개(0), 1개(1), 1개/1개 -> 1^1 = 0 이므로 2
		dp[3] = 4; // 0개(0), 1개(1), 2개(2), 1개/2개 -> 1^2 = 3 이므로 4
		dp[4] = 3; // 0개(0), 1개(1), 2개(2), 3개(4), 1개/3개 -> 1^4 = 5, 2개/2개 -> 2^2 = 0 이므로 3
		dp[5] = 5; //                             , 4개(3), 1개/4개 -> 1^3 = 2, 2개/3개 -> 2^4 = 6 이므로 5
		dp[6] = 6; //                                    , 5개(5), 1개/5개 -> 1^5 = 4, 2^
		*/
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<n; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
		}
		
		int tmp = 0;
		for(int i = 0; i<n; i++) {
			tmp ^= changeGrundy(stones[i]); 
		}
		if(tmp == 0) System.out.println("cubelover");
		else System.out.println("koosaga");
	}
}
