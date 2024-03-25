import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Things{
	int w, v;
	public Things(int w, int v) {
		this.w = w;
		this.v = v;
	}
}

class Main {
	static int n, m;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		ArrayList<Things> list = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v, c, k;
			
			v = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			for(int j = 1; k>=j; k-=j, j*=2) { // 물건의 개수를 이진수로 만들어 분할함
				list.add(new Things(j*v, j*c));
			}
			if(k!=0)
				list.add(new Things(k*v, k*c));
		}
		
		int[] dp = new int[10001];
		int answer = 0;
		for(Things thing: list) {
			int w = thing.w;
			int v = thing.v;
			for(int i = m; i>=w; i--) {
				if(dp[i-w] != 0 || i == w) {
					if(dp[i]<dp[i-w]+v) {
						dp[i] = dp[i-w]+v;
						answer = Math.max(answer, dp[i]);
					}
				}
			}
		}
		System.out.println(answer);
	}
}