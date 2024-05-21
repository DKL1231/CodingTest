import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static PriorityQueue<Long> pq;
	static long result;
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void input() throws Exception {
		int n = Integer.parseInt(br.readLine());
		
		result = 0;
		pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i<n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
	}

	static void solve() {
		while(pq.size() >= 2) {
			long a = pq.poll();
			long b = pq.poll();
			result += a+b;
			pq.add(a+b);
		}
		System.out.println(result);
	}

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		while (t-- != 0) {
			input();
			solve();
		}
	}
}