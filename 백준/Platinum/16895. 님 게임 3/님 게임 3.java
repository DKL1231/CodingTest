import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int stones[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		stones = new int[n];
		int answer = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<n; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<n; i++) {
			int tmp = 0;
			for(int j = 0; j < n; j++) {
				if(j==i) {
					continue;
				}else {
					tmp ^= stones[j];
				}
			}
			for(int j = 0; j<stones[i]; j++) {
				if((tmp^j) == 0) answer++;
			}
		}
		System.out.println(answer);
	}
}
