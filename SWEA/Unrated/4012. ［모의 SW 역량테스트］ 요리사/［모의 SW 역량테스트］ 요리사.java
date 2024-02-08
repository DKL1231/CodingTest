import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	static int[][] food;
	static boolean[] visit;
	static int N;
	static int answer = Integer.MAX_VALUE;
	
	static void dfs(int now, int selected) {
		if(selected == N/2) {
			int aTaste = 0, bTaste = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(visit[i] == visit[j]) {
						if(visit[i]) aTaste += food[i][j];
						else bTaste += food[i][j];
					}
				}
			}
			answer = Math.min(answer, Math.abs(aTaste-bTaste));
			return;
		}
		for(int i = now; i<N; i++) {
			visit[i] = true;
			dfs(i+1, selected+1);
			visit[i] = false;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer = Integer.MAX_VALUE;
			N = sc.nextInt();
			visit = new boolean[N];
			food = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					food[i][j] = sc.nextInt();
				}
			}
			dfs(0, 0);
			System.out.println("#"+test_case+" "+answer);
		}
	}
}