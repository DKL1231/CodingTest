import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] customer;
	static boolean[] visit;
	static int[] home;
	static int[] company;
	static int n;
	static int answer;
	
	static void dfs(int total, int depth, int x, int y) {
		if(total > answer) return;
		if (depth == n) {
			total += Math.abs(x-home[0])+Math.abs(y-home[1]);
			answer = Math.min(answer, total);
			return;
		}
		for(int i = 0; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(total+Math.abs(x-customer[i][0])+Math.abs(y-customer[i][1]), depth+1, customer[i][0], customer[i][1]);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			answer = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			visit = new boolean[n];
			customer = new int[n][2];
			home = new int[2];
			company = new int[2];
			
			st = new StringTokenizer(br.readLine(), " ");
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());

			for(int i = 0; i<n; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0, company[0], company[1]);
			System.out.println("#"+tc+" "+answer);
		}
	}
}
