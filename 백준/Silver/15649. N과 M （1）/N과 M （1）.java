import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int N, M;
	static boolean[] visit;
	static int[] arr;
	static void dfs(int n) {
		if (n == M) {
			for(int i = 0; i<M; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
		
		for(int i = 1; i<=N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[n] = i;
				dfs(n+1);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[10];
		visit = new boolean[10];
		for(int i=0; i<=N; i++)
			visit[i] = false;
		dfs(0);
	}
}