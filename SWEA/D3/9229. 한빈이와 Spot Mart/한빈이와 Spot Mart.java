import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution
{
	static int N, M;
	static int answer = -1;
	static int now = 0;
	static int[] snack;
	
	static void comb(int depth, int idx) {
		if(depth == 2) {
			answer = Math.max(answer, now);
			return;
		}
		
		for(int i = idx; i<N; i++) {
			if(now+snack[i]<=M) {
				now+=snack[i];
				comb(depth+1, i+1);
				now-=snack[i];
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer = -1;
			now = 0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i<N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			System.out.println("#"+test_case+" "+answer);
		}
	}
}