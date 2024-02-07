import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N, K;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int answerLength = N-K;
		char[] num = br.readLine().toCharArray();
		Stack<Character> s = new Stack<>();
		for(int i = 0; i<N; i++) {
			while(!s.isEmpty() && K>0) {
				if(s.peek()<num[i]) {
					s.pop();
					K--;
				}else {
					break;
				}
			}
			s.add(num[i]);
		}
		for(int i = s.size()-1; i>=0; i--) {
			num[i] = s.pop();
		}
		for(int i = 0; i<answerLength; i++) {
			System.out.print(num[i]);
		}
	}
}