import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=n; tc++) {
			int s, k;
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			if(k%2 == 1) {
				if(s%2 == 0) System.out.println(0);
				else System.out.println(1);
			}else {
				s %= k+1;
				if(s == k) System.out.println(k);
				else if(s%2 == 0) System.out.println(0);
				else System.out.println(1);
			}
		}
	}
}