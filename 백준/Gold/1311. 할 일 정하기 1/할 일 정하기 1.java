import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int answer = Integer.MAX_VALUE;
	
	static int[][] works;
	static int[][] dp;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		works = new int[n][n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<n; j++) {
				works[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solve() {
		dfs(0, new HashMap<>());
		System.out.println(answer);
	}
	
	static void dfs(int depth, Map<Integer, Integer> nowMap) {
		if(depth == n) {
			for(int value: nowMap.values()) {
				answer = Math.min(answer, value);
			}
			return;
		}
		Map<Integer, Integer> nextMap = new HashMap<>();
		if(depth == 0) {
			for(int i = 0; i<n; i++) {
				nextMap.put(1<<i, works[depth][i]);
			}
		}else {
			for(int i = 0; i<n; i++) {
				for(int key: nowMap.keySet()) {
					if((key & (1<<i)) == 0) {
						int nextKey = (key | (1<<i)); 
						if(!nextMap.containsKey(nextKey)||(nextMap.containsKey(nextKey) && nextMap.get(nextKey) > nowMap.get(key)+works[depth][i])) {
							nextMap.put(nextKey, nowMap.get(key)+works[depth][i]);
						}
					}
				}
			}
		}
		dfs(depth+1, nextMap);
	}
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
		
	}
}
