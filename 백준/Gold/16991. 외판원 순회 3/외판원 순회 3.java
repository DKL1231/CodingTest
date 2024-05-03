import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static Point[] points;
	static double map[][];
	static double dp[][];
	
	static void dfs(int now, int visited) {
		if(visited == Math.pow(2, n)-1) {
			if(map[now][0] == 0) return;
			dp[now][visited] = map[now][0];
			return;
		}
		dp[now][visited] = Integer.MAX_VALUE;
		for(int i = 0; i<n; i++) {
			if((visited & (1<<i)) == 0 && map[now][i] != 0) {
				if(dp[i][(visited|(1<<i))] == 0)
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
		map = new double[n][n];
		points = new Point[n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = i+1; j<n; j++) {
				map[i][j] = Math.sqrt(Math.pow(points[i].x-points[j].x, 2)+Math.pow(points[i].y-points[j].y, 2));
				map[j][i] = map[i][j];
			}
		}
		
		dp = new double[n][(int)Math.pow(2, n)];
		dfs(0, 1);
		System.out.println(dp[0][1]);
	}
}