import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] coins = new int[4];
	static int[] coinValue = { 1, 5, 10, 25 };
	static int x;
	static int reverseX;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		reverseX = 0;
		x = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 4; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
			reverseX += coins[i] * coinValue[i];
		}
		reverseX -= x;
	}

	static void solve() {
		if (reverseX < 0) {
			for (int i = 0; i < 4; i++) {
				System.out.print(0 + " ");
			}
			System.out.println();
			return;
		}
		int[] result = new int[4];
		int minUsed = Integer.MAX_VALUE;
		for (int coinsOf25 = coins[3]; coinsOf25 >= 0; coinsOf25--) {
			int nowUsed = coinsOf25;
			int[] tmp = new int[4];
			int tmpValue = reverseX - (coinsOf25 * 25);
			tmp[3] = coinsOf25;
			if (tmpValue < 0)
				continue;
			for (int i = 2; i >= 0; i--) {
				tmp[i] = Math.min((int) tmpValue / coinValue[i], coins[i]);
				nowUsed += tmp[i];
				tmpValue -= coinValue[i] * tmp[i];
			}
			if (tmpValue == 0 && (nowUsed < minUsed)) {
				minUsed = nowUsed;
				for (int i = 0; i < 4; i++) {
					result[i] = coins[i] - tmp[i];
				}
			}
		}
		if (minUsed == Integer.MAX_VALUE) {
			for (int i = 0; i < 4; i++) {
				System.out.print(0 + " ");
			}
			System.out.println();
		}else {
			for(int i = 0; i<4; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		solve();
	}
}