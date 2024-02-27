import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int t;
	static int m, n, x, y;

	static int gcd(int a, int b) {
		int tmp = a % b;
		if (tmp == 0)
			return b;
		a = b;
		return gcd(b, tmp);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int answer = -1;
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			int lcm = m * n / gcd(m, n);
			for (int i = 0; i < lcm / m; i++) {
				int tmp = i * m + x;
				if (tmp % n == y) {
					answer = tmp;
					break;
				}
				if (y == n && tmp % n == 0) {
					answer = tmp;
					break;
				}
			}
			System.out.println(answer);
		}
	}
}