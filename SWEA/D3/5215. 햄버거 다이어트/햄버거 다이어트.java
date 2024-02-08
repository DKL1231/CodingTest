import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	static int N, L;
	static int[] foodCal;
	static int[] foodPt;
	static int answer = 0;
	static void dfs(int idx, int nowCal, int nowPoint) {
		if(nowCal>L) return;
		
		for(int i = idx; i<N; i++) {
			dfs(i+1, nowCal+foodCal[i], nowPoint+foodPt[i]);
		}
		answer = Math.max(answer, nowPoint);
	}
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer = 0;
			N = sc.nextInt();
			L = sc.nextInt();
			foodCal = new int[N];
			foodPt = new int[N];
			
			for(int i = 0; i<N; i++) {
				foodPt[i] = sc.nextInt();
				foodCal[i] = sc.nextInt();				
			}
			
			dfs(0, 0, 0);
			
			System.out.println("#"+test_case+" "+answer);
		} 
	}
}