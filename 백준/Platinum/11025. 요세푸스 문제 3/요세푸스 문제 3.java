import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;

	static int dp(int peopleNum) {
		if(peopleNum == 1) return 1;
		int tmp = (dp(peopleNum-1)+k-1)%peopleNum+1;
		return tmp;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int tmp = 1;
		for(int i = 1; i<=n; i++) {
			tmp = (tmp+k-1)%i+1;
		}
		System.out.println(tmp);
	}
}
