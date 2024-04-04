import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int v, e;
	static int[][] road;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		road = new int[v+1][v+1];
		for(int i = 0; i<=v; i++) {
			Arrays.fill(road[i], 10_000*500);
			road[i][i] = 0;
		}
		for(int i = 0; i<e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a, b, c;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			road[a][b] = c;
		}
		
		for(int k = 1; k<=v; k++) {
			for(int i = 1; i<=v; i++) {
				for(int j = 1; j<=v; j++) {
					if(i == j) continue;
					if(road[i][j] > road[i][k]+road[k][j]) {
						road[i][j] = road[i][k]+road[k][j];
					}
				}
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i = 1; i<= v; i++) {
			for(int j = 1; j<=v; j++) {
				if(i == j) continue;
				if(road[i][j] != 10_000*500 && road[j][i] != 10_000*500 && road[i][j]+road[j][i]<answer) {
					answer = road[i][j]+road[j][i];
				}
			}
		}
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
	}
}