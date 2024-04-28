import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int n;
	static int[] trees;
	static int gcd = 0;
	static int answer = 0;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		
		trees = new int[n];
		
		for(int i = 0; i<n; i++) trees[i] = Integer.parseInt(br.readLine());
	}
	
	static void solve() {
		gcd = getGCD(trees[1]-trees[0], 0);
		
		for(int i = 1; i<n-1; i++) {
			gcd = getGCD(gcd, trees[i+1]-trees[i]);
		}
		for(int i = 0; i<n-1; i++) {
			answer += (trees[i+1]-trees[i])/gcd-1;
		}
	}
	
	static int getGCD(int a, int b) {
		if(b == 0) return a;
		
		return getGCD(b, a%b);
	}
	public static void main(String[] args) throws Exception {
		input();
		solve();
		System.out.println(answer);
	}
}
