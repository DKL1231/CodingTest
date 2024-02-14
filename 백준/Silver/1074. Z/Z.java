import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c;
	static int dfs(int size, int x, int y) {
		if(x == 0 && y == 0) return 0;
		int answer = 0;
		if(x<size/2&&y<size/2) {
			answer += dfs(size/2, x, y);
		}else if(x<size/2 && y >= size/2) {
			answer += Math.pow(size/2, 2);
			answer += dfs(size/2, x, y-size/2);
		}else if(x>=size/2 && y <size/2) {
			answer += Math.pow(size/2, 2)*2;
			answer += dfs(size/2, x-size/2, y);
		}else {
			answer += Math.pow(size/2, 2)*3;
			answer += dfs(size/2, x-size/2, y-size/2);
		}
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		System.out.println(dfs((int)Math.pow(2, N), r, c));
	}
}