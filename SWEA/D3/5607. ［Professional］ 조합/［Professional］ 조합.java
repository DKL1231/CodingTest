import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static final int mod = 1234567891;
	static int t;
	static long fact[] = new long[1000001];
	
	static long pow(long v, long idx) {
		long result = 1;
		while(idx>0) {
			if(idx%2 == 1) {
				result *= v;
				result %= mod;
			}
			v *= v;
			v %= mod;
			idx /= 2;
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		
		fact[1] = 1;
		for(int i = 2; i<=1000000; i++) {
			fact[i] = (fact[i-1]*i)%mod;
		}
		
		for(int tc = 1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long result = fact[n];
			result *= pow((fact[r]*fact[n-r])%mod, mod-2)%mod;
			result %= mod;
			System.out.println("#"+tc+" "+result);
		}
	}
}
