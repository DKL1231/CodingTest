import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] sourNbitter;
	static int answer = 1_000_000_000;
	
	static void dfs(int now, int nowSour, int nowBitter, int cnt) {
		if(now == N) {
			if(cnt != 0)
				answer = Math.min(answer, Math.abs(nowBitter-nowSour));
			return;
		}
		
		int tmpBitter = nowBitter + sourNbitter[now][1];
		int tmpSour = nowSour * sourNbitter[now][0];
		dfs(now+1, tmpSour, tmpBitter, cnt+1);
		dfs(now+1, nowSour, nowBitter, cnt);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		sourNbitter = new int[N][2];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sourNbitter[i][0] = Integer.parseInt(st.nextToken());
			sourNbitter[i][1] = Integer.parseInt(st.nextToken());
		}
		dfs(0,1,0, 0);
		System.out.println(answer);
	}
}