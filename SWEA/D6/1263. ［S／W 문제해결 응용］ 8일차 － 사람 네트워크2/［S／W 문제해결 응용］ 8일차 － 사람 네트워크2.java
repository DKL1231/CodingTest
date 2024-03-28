import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static final int INF = 1001;
	static int t;
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=t; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][n];
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && map[i][j] == 0) map[i][j] = INF; 
				}
			}
			
			for(int k = 0; k<n; k++) {
				for(int i = 0; i<n; i++) {
					if(i == k) continue;
					for(int j = 0; j<n; j++) {
						if(i == j || k == j) continue;
						if(map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}
					}
				}
			}
			int answer = INF*INF;
			for(int i = 0; i<n; i++) {
				int tmp = 0;
				for(int j = 0; j<n; j++)
					tmp += map[i][j];
				if(answer>tmp) answer = tmp;
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
}
