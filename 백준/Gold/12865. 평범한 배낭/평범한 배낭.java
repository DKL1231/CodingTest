import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		int[][] table = new int[N+1][K+1];
		for(int i=0; i<=N; i++)
			table[i][0] = 0;
		for(int i=0; i<=K; i++)
			table[0][i] = 0;
		
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if(weight[i]>j)
					table[i][j] = table[i-1][j];
				else
					table[i][j] = Math.max(table[i-1][j], table[i-1][j-weight[i]]+value[i]);
			}
		}
		System.out.println(table[N][K]);
	}
}