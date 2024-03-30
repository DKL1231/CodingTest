import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//13904
class HomeWork implements Comparable<HomeWork>{
	int d, w;

	public HomeWork(int d, int w) {
		this.d = d;
		this.w = w;
	}

	@Override
	public int compareTo(HomeWork o) {
		// TODO Auto-generated method stub
		if(o.w==w) return d-o.d;
		return o.w-w;
	}
	
}
class Main {
	static int n;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		PriorityQueue<HomeWork> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[1001]; 
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pq.add(new HomeWork(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int answer = 0;
		while(!pq.isEmpty()) {
			HomeWork now = pq.poll();
			while(now.d > 0) {
				if(!visit[now.d--]) {
					answer+=now.w;
					visit[now.d+1] = true;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}