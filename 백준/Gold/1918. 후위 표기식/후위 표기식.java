import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		Map<Character, Integer> m = new HashMap<>();
		m.put('+', 0);
		m.put('-', 0);
		m.put('*', 1);
		m.put('/', 1);
		m.put('(', -1);

		Stack<Character> stk = new Stack<>();
		for (char c : s) {
			if (c >= 'A' && c <= 'Z') {
				System.out.print(c);
			} else {
				if (c == '(') {
					stk.push(c);
				} else if (c == ')') {
					char tmp = stk.pop();
					while (tmp != '(') {
						System.out.print(tmp);
						tmp = stk.pop();
					}
				} else {
					if (!stk.isEmpty()) {
						while (m.get(stk.peek()) >= m.get(c)) {
							System.out.print(stk.pop());
							if (stk.isEmpty())
								break;
						}
					}
					stk.push(c);
				}
			}
		}
		while (!stk.isEmpty())
			System.out.print(stk.pop());
	}
}
