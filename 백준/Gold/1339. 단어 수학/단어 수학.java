import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static BufferedReader br;
	static StringTokenizer st;
	static String[] words;
	static int[] charValue = new int[26];
	static int answer = 0;
	
	static void calc() {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int tmp = 9;
		for(int i = 0; i<26; i++) {
			pq.add(charValue[i]);
		}
		
		while(!pq.isEmpty()) {
			answer += pq.poll()*tmp--;
		}
	}

	static void input() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		words = new String[n];

		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
			StringBuilder sb = new StringBuilder(words[i]);
			int tmp = 1;
			for (char c : sb.reverse().toString().toCharArray()) {
				charValue[c-'A'] += tmp;
				tmp *= 10;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		calc();
		System.out.println(answer);
	}
}
