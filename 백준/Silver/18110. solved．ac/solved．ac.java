import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i<n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		int cut = (int) Math.round(n*15.0/100.0);
		int answer = 0;
		for(int i = 0; i<n; i++) {
			int tmp = pq.poll();
			if(i<cut || i>=n-cut) continue;
			answer+=tmp;
		}
		System.out.println(Math.round(answer*1.0/((n-2*cut)*1.0)));
	}

}