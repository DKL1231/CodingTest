import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T;
		T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N, M;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N+1][N+1];
			for(int i = 1; i<=N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					map[i][j] += map[i-1][j]+map[i][j-1]-map[i-1][j-1];
				}
			}
			int answer = 0;
			for(int i = M; i<=N; i++) {
				for(int j = M; j<=N; j++) {
					answer = Math.max(answer, map[i][j]-map[i-M][j]-map[i][j-M]+map[i-M][j-M]);
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
}