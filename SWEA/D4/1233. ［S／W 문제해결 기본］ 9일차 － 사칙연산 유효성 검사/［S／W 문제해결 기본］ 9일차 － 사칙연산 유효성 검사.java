import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution
{
	static int answer = 1;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer = 1;
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				if(st.countTokens() == 4) {
					st.nextToken();
					try {
						Integer.parseInt(st.nextToken());
					} catch(Exception e) {
						continue;
					}
					answer = 0;
				}else {
					st.nextToken();
					try {
						Integer.parseInt(st.nextToken());
					} catch(Exception e) {
						answer = 0;
						continue;
					}
				}
			}
			if(N%2 == 0) answer = 0;
			System.out.println("#"+test_case+" "+answer);
		}
	}
}