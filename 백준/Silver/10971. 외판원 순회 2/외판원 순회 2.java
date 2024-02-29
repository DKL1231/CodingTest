import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] road;
	static boolean[] visit;
	static int weight = 0;
	static int answer = Integer.MAX_VALUE;
	static void perm(int depth, int now) {
		if(depth == n-1) {
			if(road[now][0] == 0) return;
			weight += road[now][0];
			answer = Math.min(weight, answer);
			weight -= road[now][0];
			return;
		}
		
		for(int i = 1; i<n; i++) {
			if(!visit[i] && road[now][i] != 0) {
				weight += road[now][i];
				visit[i] = true;
				perm(depth+1, i);
				visit[i] = false;
				weight -= road[now][i];
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		road = new int[n][n];
		visit = new boolean[n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<n; j++) {
				road[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm(0, 0);
		System.out.println(answer);
	}
}