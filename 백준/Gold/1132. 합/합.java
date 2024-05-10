import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long[] num;
	static String[] inputs;
	static boolean[] cantBeZero;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	
	static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		num = new long[10];
		cantBeZero = new boolean[10];
		inputs = new String[n];
		
		for(int i = 0; i<n; i++) {
			inputs[i] = br.readLine().trim();
		}
	}
	
	static long solve() {
		for(String s: inputs) {
			StringBuilder sb = new StringBuilder(s);
			cantBeZero[sb.toString().charAt(0)-'A'] = true;
			sb = sb.reverse();
			long tmp = 1;
			for(char c: sb.toString().toCharArray()) {
				num[c-'A'] += tmp;
				tmp*= 10;
			}
		}
		
		int idx = -1;
		long temp = Long.MAX_VALUE;
		for(int i = 0; i<10; i++) {
			if(!cantBeZero[i]) {
				if(temp>num[i]) {
					idx = i;
					temp = num[i];
				}
			}
		}
		
		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
		long answer = 0;
		for(int i = 0; i<10; i++) {
			if(i == idx) continue;
			pq.add(num[i]);
		}
		long tmp = 9;
		while(!pq.isEmpty()) {
			answer += pq.poll()*tmp--;
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(solve());
	}
}