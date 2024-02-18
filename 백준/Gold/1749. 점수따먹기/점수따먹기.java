import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static int answer = Integer.MIN_VALUE;
	
	static void cal(int x, int y, int x2, int y2) {
		answer = Math.max(answer, map[x2][y2]-map[x-1][y2]-map[x2][y-1]+map[x-1][y-1]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i <=n; i++) {
			for(int j = 1; j<=m; j++) {
				map[i][j] += map[i-1][j]+map[i][j-1]-map[i-1][j-1];
			}
		}
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=m; j++) {
				for(int k = i; k<=n; k++) {
					for(int l = j; l<=m; l++) {
						cal(i, j, k, l);
					}
				}
			}
		}
		
		System.out.println(answer);
		
	}
}
