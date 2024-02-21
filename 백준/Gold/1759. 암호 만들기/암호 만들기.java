import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int l, c;
	static char[] chrs;
	static char[] nowCrypto;
	static final char[] moeum = { 'a', 'e', 'i', 'o', 'u' };

	static boolean check() {
		int flagMoeum = 0;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < 5; j++) {
				if (moeum[j] == nowCrypto[i]) {
					flagMoeum++;
					break;
				}
			}
		}
		return (flagMoeum == 0 || flagMoeum >= l-1) ? false : true;
	}

	static void dfs(int depth, int now) {
		if (now == l) {
			if (check())
				System.out.println(String.valueOf(nowCrypto));
			return;
		}
		if (depth == c)
			return;
		nowCrypto[now] = chrs[depth];
		dfs(depth + 1, now + 1);
		dfs(depth + 1, now);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		chrs = new char[c];
		nowCrypto = new char[l];
		for (int i = 0; i < c; i++) {
			chrs[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(chrs);
		dfs(0, 0);
	}
}