import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class matrix {
	int[][] data = new int[2][2];

	matrix() {
		data[0][0] = 1;
		data[0][1] = 1;
		data[1][0] = 1;
		data[1][1] = 0;
	}
}

public class Main {
	static int fibo[] = new int[34]; // 피보나치 수 33번째가 3524578로 300만보다 큼
	static int dp[];

	public static matrix multi(matrix A, matrix B) {
		matrix result = new matrix();
		result.data[0][0] = A.data[0][0] * B.data[0][0] + A.data[0][1] * B.data[1][0];
		result.data[0][1] = A.data[0][0] * B.data[1][0] + A.data[0][1] * B.data[1][1];
		result.data[1][0] = A.data[1][0] * B.data[0][0] + A.data[1][1] * B.data[1][0];
		result.data[1][1] = A.data[1][0] * B.data[1][0] + A.data[1][1] * B.data[1][1];

		return result;
	}

	public static matrix pow(matrix A, int n) {
		if (n > 1) {
			A = pow(A, n / 2);
			A = multi(A, A);

			if (n % 2 == 1) {
				matrix B = new matrix();
				A = multi(A, B);
			}
		}
		return A;
	}

	public static int fibonacci(int n) {
		if (n == 0)
			return 0;
		matrix A = new matrix();
		A = pow(A, n);
		return A.data[0][1];
	}

	static void initDP() {
		for (int i = 1; i <= 3000000; i++) {
			boolean check[] = new boolean[50];
			for (int j = 2; j <= 33; j++) {
				if (fibo[j] > i)
					break;
				check[dp[i - fibo[j]]] = true;
			}
			for (int j = 0; j < 50; j++) {
				if (!check[j]) {
					dp[i] = j;
					break;
				}
				;
			}
		}
	}

	static void initFibo() {
		for (int i = 0; i <= 33; i++) {
			fibo[i] = fibonacci(i);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] stones = new int[n + 1];
		dp = new int[3 * 1000000 + 1];
		dp[0] = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
		}
		initFibo();
		initDP();
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			tmp ^= dp[stones[i]];
		}
		if (tmp == 0)
			System.out.println("cubelover");
		else
			System.out.println("koosaga");
	}
}
