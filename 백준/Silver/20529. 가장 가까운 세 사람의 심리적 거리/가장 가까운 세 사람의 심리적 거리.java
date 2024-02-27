import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int t, n;
	static String[] mbtiList;
	static int[] selected = new int[3];
	static int answer = Integer.MAX_VALUE;
	
	static void perm(int depth, int nowIdx) {
		if(depth == 3) {
			answer = Math.min(answer, checkMindDist());
			return;
		}
		for(int i = nowIdx; i<n; i++) {
			selected[depth] = i;
			perm(depth+1, i+1);
		}
	}
	
	static int checkMindDist() {
		int tmp = 0;
		for(int i = 0; i<3; i++) {
			char[] a = mbtiList[selected[i]].toCharArray();
			char[] b = mbtiList[selected[(i+1)%3]].toCharArray();
			
			for(int j = 0; j<4; j++) {
				if(a[j] != b[j]) tmp++; 
			}
		}
		return tmp;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=t; tc++) {
			answer = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			mbtiList = new String[n];
			st = new StringTokenizer(br.readLine(), " ");
			if(n >= 48) {
				System.out.println(0);
				continue;
			}
			for(int i = 0; i<n; i++) mbtiList[i] = st.nextToken();
			Arrays.sort(mbtiList);
			perm(0, 0);
			System.out.println(answer);
		}
	}
}