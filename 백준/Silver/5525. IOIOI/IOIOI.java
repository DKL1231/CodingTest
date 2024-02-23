import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int answer = 0;
	static char[] correct;
	static char[] inp;
	static char[] io = { 'I', 'O' };

	static int[] getMatch(){
		int m = correct.length;
		int[] tmp = new int[m];
		int begin = 1, matched = 0;
		
		while(begin + matched < m) {
			if(correct[begin+matched] == correct[matched]) {
				matched++;
				tmp[begin+matched-1] = matched;
			}
			else {
				if(matched==0) {
					begin++;
				}
				else {
					begin = begin+matched - tmp[matched-1];
					matched = tmp[matched-1];
				}
			}
		}
		return tmp;
	}
	
	static void KMP() {
		int srcSize = inp.length, corSize = correct.length;
		int[] tmp = getMatch();
		int p = 0;
		
		for(int i = 0; i<srcSize; i++) { // 문자열을 순회하면서
			while(p>0 && inp[i] != correct[p]) {
				p = tmp[p-1];
			}
			if(inp[i] == correct[p]) {
				if(p == corSize-1) {
					answer++;
					p = tmp[p];
				}else {
					p++;
				}
			}
		}
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
		KMP();
		System.out.println(answer);
	}

}