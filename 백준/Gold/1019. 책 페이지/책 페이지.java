import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] result;

	static void count(int n, int dig) {
		while (n > 0) {
			result[n % 10] += dig;
			n /= 10;
		}
	}

	static void solve(int from, int to, int dig) {
		while(from%10 != 0 && from<=to) {
			count(from, dig);
			from++;
		}
		
		if(from>to) return;
		
		while(to%10 != 9 && from<=to) {
			count(to, dig);
			to--;
		}
		
		int tmp = to/10-from/10+1;
		for(int i = 0; i<10; i++)
			result[i]+=tmp*dig;
		
		solve(from/10, to/10, dig*10);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// int t = Integer.parseInt(br.readLine());
		int t = 1;

		for (int tc = 1; tc <= t; tc++) {
			result = new long[10];
			st = new StringTokenizer(br.readLine(), " ");
			String ns = st.nextToken();
			int n = Integer.parseInt(ns);
			
			solve(1, n, 1);
			for(int i = 0; i<10; i++)
				System.out.println(result[i]);
		}
	}
}
