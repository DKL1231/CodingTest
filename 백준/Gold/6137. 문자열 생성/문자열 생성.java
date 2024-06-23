import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static char[] s;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		s = new char[n];
		
		for(int i = 0; i<n; i++) {
			s[i] = br.readLine().charAt(0);
		}
	}

	static void solve() {
		StringBuilder sb = new StringBuilder();
		int lp = 0;
		int rp = n-1;
		int tmp = 0;
		
		while(lp<=rp) {
			tmp++;
			if(s[lp]<s[rp]) {
				sb.append(s[lp]);
				lp++;
			}else if(s[lp]>s[rp]) {
				sb.append(s[rp]);
				rp--;
			}else {
				int newLp = lp+1;
				int newRp = rp-1;
				boolean flag = false;
				while(newLp<=newRp) {
					if(s[newLp]<s[newRp]) {
						sb.append(s[lp++]);
						flag = true;
						break;
					}else if(s[newLp]>s[newRp]) {
						sb.append(s[rp--]);
						flag = true;
						break;
					}else {
						newLp++;
						newRp--;
					}
				}
				if(!flag) {
					sb.append(s[lp++]);
				}
			}
			if(tmp%80 == 0) sb.append(" ");
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		input();
		solve();
	}
}