import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Pair{
	int left; int right;
	
	public Pair(int left, int right) {
		this.left = left;
		this.right = right;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[] numList = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) numList[i] = Integer.parseInt(st.nextToken());
		
		Stack<Pair> stk = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++) {
			if(stk.isEmpty()) {
				sb.append(0+" ");
				stk.add(new Pair(i+1, numList[i]));
			}else {
				while(stk.peek().right < numList[i]) {
					stk.pop();
					if(stk.isEmpty()) {
						break;
					}
				}
				if(stk.isEmpty()) {
					sb.append(0+" ");
					stk.add(new Pair(i+1, numList[i]));
				}else {
					sb.append(stk.peek().left+" ");
					stk.add(new Pair(i+1, numList[i]));
				}
			}
		}
		System.out.println(sb.toString());
	}
}