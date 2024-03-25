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
		
		int[][] dp = new int[list.size()+1][10001];
		for(int i = 1; i<=m; i++) {
			for(int j = 1; j<=list.size(); j++) {
				Things now = list.get(j-1);
				int w = now.w;
				int v = now.v;
				if(i-w >= 0) {
					dp[j][i] = Math.max(dp[j-1][i], dp[j-1][i-w]+v);
				}else {
					dp[j][i] = dp[j-1][i];
				}
			}
		}
		System.out.println(dp[list.size()][m]);
	}
}
