import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n, h;
	static int[] jong = new int[500001];
	static int[] suk = new int[500001];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<n; i++) {
			int inp = Integer.parseInt(br.readLine());
			if(i%2 == 0) {
				suk[inp]++;
			}else {
				jong[h-inp+1]++;
			}
		}
		for(int i = 1; i<=h; i++) {
			suk[h-i] += suk[h-i+1];
			jong[i] += jong[i-1];
		}
		
		int answer = n;
		int cnt = 0;
		
		for(int i = 1; i<=h; i++) {
			if(jong[i]+suk[i] < answer) {
				answer = jong[i]+suk[i];
				cnt = 1;
			}else if(jong[i]+suk[i] == answer) {
				cnt++;
			}
		}
		
		System.out.println(answer+" "+cnt);
	}
}
