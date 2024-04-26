import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static BufferedReader br;
	static StringTokenizer st;
	static String[] words;
	static boolean[] charUsed = new boolean[26];
	static int[] charValue = new int[26];
	static char[] chars;
	static boolean[] visit = new boolean[10];
	static int answer = 0;

	static void perm(int depth) {
		if (depth == chars.length) {
			calc();
			return;
		}

		for (int i = 9; i >= 10 - chars.length; i--) {
			if (!visit[i]) {
				visit[i] = true;
				charValue[chars[depth] - 'A'] = i;
				perm(depth + 1);
				visit[i] = false;
			}
		}
	}

	static void calc() {
		int value = 0;

		for (String word : words) {
			int tmp = (int) Math.pow(10, word.length() - 1);
			for (char c : word.toCharArray()) {
				value += tmp * charValue[c - 'A'];
				tmp /= 10;
			}
		}

		if (value > answer)
			answer = value;
	}

	static void input() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		words = new String[n];

		int idx = 0;
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
			for (char c : words[i].toCharArray()) {
				if (!charUsed[c - 'A']) {
					charUsed[c - 'A'] = true;
					idx++;
				}
			}
		}
		chars = new char[idx];
		for (int i = 0, j = 0; i < 26; i++)
			if (charUsed[i])
				chars[j++] = (char) (i + 'A');
	}

	public static void main(String[] args) throws Exception {
		input();
		perm(0);
		System.out.println(answer);
	}
}
