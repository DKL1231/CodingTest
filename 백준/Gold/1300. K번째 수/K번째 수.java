import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static long n, k;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		long left = 1;
		long right = n*n;
		
		while(left < right) {
			long mid = (left+right)/2;
			long cnt = 0;
			for(int i=1; i<=n; i++) {
				cnt += Math.min(mid/i, n);
			}
			
			if(cnt >= k) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		System.out.println(left);
	}
}
