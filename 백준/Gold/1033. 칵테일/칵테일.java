import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long[] gradient;
	static boolean[][] connect;
	static boolean[] visit;
	static int a, b, p, q;

	public static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static void dfs(int a, long value) {
		gradient[a] *= value;
		for (int i = 0; i < n; i++) {
			if (connect[a][i] && !visit[i]) {
				visit[i] = true;
				dfs(i, value);
			}
		}
	}

	public static void initPQ() {
		long pqGCD = gcd(p, q);
		p /= pqGCD;
		q /= pqGCD;
	}

	public static void applyValue(int where, long value) {
		visit = new boolean[n];
		visit[where] = true;
		dfs(where, value);
	}

	public static void calCocktail() {
		initPQ();

		long abGCD = gcd(gradient[a], gradient[b]);
		long aValue = gradient[b] / abGCD * p;
		long bValue = gradient[a] / abGCD * q;

		applyValue(a, aValue);
		applyValue(b, bValue);
	}
	
	public static void lastInit() {
		long finalGCD = gradient[0];
		
		for(int i = 1; i<n; i++) {
			finalGCD = gcd(finalGCD, gradient[i]);
		}
		for(int i = 0; i<n; i++)
			gradient[i] /= finalGCD;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		gradient = new long[n];
		connect = new boolean[n][n];
		Arrays.fill(gradient, 1);
		
		for (int j = 0; j < n; j++)
			connect[j][j] = true;
		
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			calCocktail();

			connect[a][b] = true;
			connect[b][a] = true;
		}
		
		lastInit();
		
		for (int j = 0; j < n; j++)
			System.out.print(gradient[j] + " ");
		System.out.println();
	}
}
