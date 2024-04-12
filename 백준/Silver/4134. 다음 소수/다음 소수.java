import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static long t;
	static ArrayList<Long> prime = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		t = Long.parseLong(br.readLine());

		prime.add((long)2);
		for (int i = 3; i <= 2 * 200_000; i++) {
			boolean flag = true;
			for (long p : prime) {
				if (i < p * p)
					break;
				if (i % p == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				prime.add((long) i);
			}
		}
		for (long tc = 1; tc <= t; tc++) {
			long n = Long.parseLong(br.readLine());
			if(n < 2) {
				System.out.println(2);
				continue;
			}
			long num = n;
			while (true) {
				boolean flag = true;
				for (long p : prime) {
					if (num < p * p)
						break;
					if (num % p == 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					System.out.println(num);
					break;
				}
				num++;
			}
		}
	}
}