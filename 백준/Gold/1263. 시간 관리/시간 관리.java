import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Work implements Comparable<Work>{
	int t, s;

	public Work(int t, int s) {
		super();
		this.t = t;
		this.s = s;
	}

	@Override
	public int compareTo(Work o) {
		return o.s-s;
	}
	
}


public class Main {
	static int n;
	static int nowTime;
	static PriorityQueue<Work> pq = new PriorityQueue<>();
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	
	static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
	}

	
	static int solve() {
		nowTime = pq.peek().s;
		
		while(!pq.isEmpty()) {
			Work now = pq.poll();
			
			if(nowTime>now.s) {
				nowTime=now.s;
			}
			nowTime -= now.t;
			
			if(nowTime < 0) return -1;
		}
		return nowTime;
	}

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(solve());
	}
}