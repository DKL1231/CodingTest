import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			if (Math.abs(a) == Math.abs(b))
				return a - b;
			return Math.abs(a) - Math.abs(b);
		});
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			}else {
				pq.add(x);
			}
		}
	}
}