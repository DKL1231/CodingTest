import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] result;

	static void count(long n, long dig, boolean type) {
		while (n > 0) {
			long tmp = n-(n/10*10);
			if(type) 
				result[(int) tmp] += dig;
			else
				result[(int) tmp] -= dig;
			n /= 10;
		}
	}

	static void solve(long from, long to, long dig, boolean type) {
		while(from%10 != 0 && from<=to) {
			count(from, dig, type);
			from++;
		}
		
		if(from>to) return;
		
		while(to%10 != 9 && from<=to) {
			count(to, dig, type);
			to--;
		}
		
		long tmp = to/10-from/10+1;
		for(int i = 0; i<10; i++)
			if(type)
				result[i]+=tmp*dig;
			else
				result[i]-=tmp*dig;
		
		solve(from/10, to/10, dig*10, type);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			result = new long[10];
			st = new StringTokenizer(br.readLine(), " ");
			long n = Long.parseLong(st.nextToken());
			long m = Long.parseLong(st.nextToken());
			if(n == 0 && m == 0) break;
			if(n > m) {
				long tmp = m;
				m = n;
				n = tmp;
			}
			solve(1, n-1, 1, false);
			solve(1, m, 1, true);
			for(int i = 0; i<10; i++)
				System.out.print(result[i]+" ");
			System.out.println();
		}
	}
}
