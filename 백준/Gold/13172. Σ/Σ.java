import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static int m;
	static long mod = 1_000_000_007;
	static long calValue(int n, int s) {
		//s/n계산
		int gcd = gcd(n, s);
		n /= gcd;
		s /= gcd;
		long result = (s%mod)*(pow(n, mod-2)%mod);
		return result%mod;
	}
	
	static int gcd(int a, int b) {
		if(b == 0) return a;
		int r = a%b;
		return gcd(b, r);
	}
	
	static long pow(long a, long l) {
		if(l == 0) return 1;
		
		long p = l/2;
		long ab = pow(a, p);
		return l%2 == 0? (ab*ab)%mod:((ab*ab)%mod*a)%mod;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		m = Integer.parseInt(br.readLine());
		long result = 0;
		for(int i = 0; i<m; i++) {
			int n, s;
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			
			result = (result+calValue(n, s))%mod; 
		}
		System.out.println(result);
	}

}
