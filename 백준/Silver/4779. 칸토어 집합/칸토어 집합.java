import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static String[] dp = new String[13];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static boolean input() throws Exception {
		String inp = br.readLine();
		if (inp == null)
			return false;
		n = Integer.parseInt(inp);
		return true;
	}

	static void solve() {
		System.out.println(dfs(n));
	}

	static String dfs(int depth) {
		if(dp[depth] != null) 
			return dp[depth];
		
		if (depth == 0) {
			dp[0] = "-";
			return "-";
		}
		
		StringBuilder sb = new StringBuilder();
		String tmp = dfs(depth-1);
		
		sb.append(tmp);
		for(int i = 0; i<Math.pow(3, depth-1); i++) {
			sb.append(" ");
		}
		sb.append(tmp);
		
		dp[depth] = sb.toString();
		return dp[depth];
	}

	public static void main(String[] args) throws Exception {
		while (input()) {
			solve();
		}
	}
}
