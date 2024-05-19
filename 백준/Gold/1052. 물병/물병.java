import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static StringBuilder sb = new StringBuilder();
	static int answer = 0;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	}

	static void solve() throws Exception {
		while(countMinBottle(n)>k) {
			n++;
			answer++;
		}
		System.out.println(answer);
	}
	
	static int countMinBottle(int n) {
		char[] binN = Integer.toBinaryString(n).toCharArray();
		int result = 0;
		for(char c: binN) {
			result += (c-'0');
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		input();
		solve();
	}
}
