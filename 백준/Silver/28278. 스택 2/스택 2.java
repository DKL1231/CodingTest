import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static Stack<Integer> stk;
	static StringBuilder sb = new StringBuilder();
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void input() throws Exception {
		n = Integer.parseInt(br.readLine().trim());
		stk = new Stack<>();
		while(n-- != 0) {
			solve();
		}
	}

	static void solve() throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		
		int type = Integer.parseInt(st.nextToken());
		
		switch(type) {
		case 1:
			int x = Integer.parseInt(st.nextToken());
			stk.add(x);
			break;
		case 2:
			if(stk.isEmpty()) {
				sb.append(-1);
				sb.append("\n");
			}else {
				sb.append(stk.pop());
				sb.append("\n");
			}
			break;
		case 3:
			sb.append(stk.size());
			sb.append("\n");
			break;
		case 4:
			if(stk.isEmpty()) {
				sb.append(1);
				sb.append("\n");
			}else {
				sb.append(0);
				sb.append("\n");
			}
			break;
		case 5:
			if(stk.isEmpty()) {
				sb.append(-1);
				sb.append("\n");
			}else {
				sb.append(stk.peek());
				sb.append("\n");
			}
			break;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(sb.toString());
	}
}
