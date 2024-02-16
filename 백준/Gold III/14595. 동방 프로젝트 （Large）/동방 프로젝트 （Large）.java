import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parent;
	static int[][] jongbin;
	static int from, to;

	static int findParent(int a) {
		if (parent[a] == a)
			return a;
		parent[a] = findParent(parent[a]);
		return parent[a];
	}

	static void unionParent(int a, int b) {
		parent[b] = a;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for(int i = 1; i<=N; i++) parent[i] = i;
		StringTokenizer st;
		jongbin = new int[M][2];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			jongbin[i][0] = Integer.parseInt(st.nextToken());
			jongbin[i][1] = Integer.parseInt(st.nextToken());	
		}
		
		Arrays.sort(jongbin, (a, b)->{if(a[0]==b[0]) return b[1]-a[1]; else return a[0]-b[0];});
		
		int tmp = -1;
		for(int i = 0; i<M; i++) {
			if(tmp != jongbin[i][0]) {
				from = jongbin[i][0];
				to = jongbin[i][1];
				for(int j = from; j<to; j++) {
					unionParent(j, j+1);
				}
				tmp = from;
			}
		}
		
		int answer = 1;
		findParent(1);
		for(int i = 1; i<N; i++) {
			if(parent[i]!=findParent(i+1)) answer++;
		}
		System.out.println(answer);
	}
}