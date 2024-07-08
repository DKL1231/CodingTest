import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void input() throws Exception {
		n = Integer.parseInt(br.readLine());		
	}

	static void solve() throws IOException {
		char[] cArr = Integer.toBinaryString(n+1).toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for(char c: cArr) {
			if(c == '1') {
				sb.append('7');
			}else {
				sb.append('4');
			}
		}
		sb.deleteCharAt(0);
		System.out.println(sb.toString());
	}
	

	public static void main(String[] args) throws Exception {
		input();
		solve();
	}
}