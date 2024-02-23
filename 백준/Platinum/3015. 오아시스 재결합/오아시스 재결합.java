import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Height {
	int height, cnt;

	public Height(int height, int cnt) {
		this.height = height;
		this.cnt = cnt;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Height> stk = new Stack<>(); // 각 키/키인원 있는 스택. 내림차순
		long answer = 0;
		for (int i = 0; i < n; i++) {
			int nowHeight = Integer.parseInt(br.readLine());
			Height next = new Height(nowHeight, 1);
			while (!stk.isEmpty() && stk.peek().height < nowHeight) {//자기보다 크거나 같은 요소 나올떄까지
				answer += stk.pop().cnt;//누적해서 더하고 스택에서 제거
			}
			if (!stk.isEmpty()) {//스택이 비어있지 않다면(자기보다 크거나 같은 요소가 있다면)
				if(stk.peek().height > nowHeight) // 만약 나보다 크면
					answer += 1; // 가장 가까운 한명만 볼 수 있음
				if (stk.peek().height == nowHeight) { // 만약 같은키라면
					answer += stk.peek().cnt; // 같은키인애들 다볼수있음
					next = stk.pop();
					next.cnt += 1;//키 인원수 증가
					if(!stk.isEmpty())
						answer += 1; // 자기보다 큰 사람 한명 볼 수 있음
				}
			}
			stk.push(next);
		}
		System.out.println(answer);
	}

}