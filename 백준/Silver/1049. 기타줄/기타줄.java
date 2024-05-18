import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	static int sixMin = Integer.MAX_VALUE, oneMin = Integer.MAX_VALUE;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int six = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			
			if(six < sixMin) sixMin = six;
			if(one < oneMin) oneMin = one;
		}
	}

	static void solve() throws Exception {
		int answer = 0;
		if(sixMin < oneMin) {
			answer += sixMin*(n/6);
			if(n%6 != 0) {
				answer+=sixMin;
			}
		}else if(sixMin >= oneMin*6) {
			answer = oneMin*n;
		}else {
			answer += sixMin*(n/6);
			if(sixMin < (n%6)*oneMin)
				answer += sixMin;
			else
				answer += (n%6)*oneMin;
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {
		input();
		solve();
	}
}
