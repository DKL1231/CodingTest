import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int answer = 0;
	static char[] correct;
	static char[] inp;
	static char[] io = { 'I', 'O' };

	static boolean check(int lp, int rp) {
		for (int i = lp; i <= rp; i++) {
			if (correct[i - lp] != inp[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		inp = new char[m];
		inp = br.readLine().toCharArray();
		correct = new char[2 * n + 1];
		for (int i = 0; i < 2 * n + 1; i++) {
			correct[i] = io[i % 2];
		}
		boolean flag = false;
		int rp = 2 * n;
		int lp = 0;
		int tmp = -1;
		while (rp < m) {
			if(flag && tmp==2 && inp[rp-1]=='O' && inp[rp] =='I') {
				answer++;
			}else {
				flag = check(lp, rp);
				if (flag)
					answer++;
			}
			tmp = 0;
			while ((rp < m && inp[lp] != 'I')||tmp==0) {
				lp++;
				rp++;
				tmp++;
			}
		}
		System.out.println(answer);
	}

}