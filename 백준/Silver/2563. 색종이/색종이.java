import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		boolean[][] map = new boolean[100][100];
		
		for(int tc = 0; tc<N; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			for(int i = 0; i<10; i++) {
				for(int j = 0; j<10; j++) {
					map[x+i][y+j] = true;
				}
			}
		}
		int answer = 0;
		for(int i = 0; i<100; i++)
			for(int j = 0; j<100; j++)
				if(map[i][j]) answer++;
		System.out.println(answer);
	}
}