import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] map;
	
	static boolean checkSame(int size, int x, int y) {
		char tmp = map[x][y];
		for(int i = x; i<x+size; i++) {
			for(int j = y; j<y+size; j++) {
				if(tmp != map[i][j]) return false;
			}
		}
		return true;
	}
	
	static String dfs(int size, int x, int y) {
		if(checkSame(size, x, y)) {
			return Character.toString(map[x][y]);
		}
		String tmp = "(";
		
		tmp += dfs(size/2, x, y);
		tmp += dfs(size/2, x, y+size/2);
		tmp += dfs(size/2, x+size/2, y);
		tmp += dfs(size/2, x+size/2, y+size/2);
		
		tmp += ")";
		return tmp;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		System.out.println(dfs(N, 0, 0));
	}
}