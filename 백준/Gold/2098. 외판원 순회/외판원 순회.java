import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int map[][];
	static int dp[][];
	
	static void dfs(int now, int visited) {
		if(visited == Math.pow(2, n)-1) {
			if(map[now][0] == 0) return;
			dp[now][visited] = map[now][0];
			return;
		}
		dp[now][visited] = Integer.MAX_VALUE;
		for(int i = 0; i<n; i++) {
			if((visited & (1<<i)) == 0 && map[now][i] != 0) { // 방문하지 않은 정점에 한해, 갈 수 있는 정점이라면
				if(dp[i][(visited|(1<<i))] == 0) // 방문할 정점에 대해 dp 배열을 갱신시키지 않았다면
					dfs(i, (visited|(1<<i)));
				if(dp[i][(visited|(1<<i))] == Integer.MAX_VALUE || dp[i][(visited|(1<<i))] == 0) // 그 이후에 답이 없는 dp라면
					continue;
				dp[now][visited] = Math.min(dp[now][visited], dp[i][(visited|(1<<i))]+map[now][i]);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[n][(int)Math.pow(2, n)];
		dfs(0, 1);
		System.out.println(dp[0][1]);
	}
}
