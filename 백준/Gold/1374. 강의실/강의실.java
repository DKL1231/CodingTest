import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Work implements Comparable<Work> {
	int start, end;

	public Work(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Work o) {
		// TODO Auto-generated method stub
		return end - o.end;
	}
}

public class Main {
	static int n;
	static PriorityQueue<Work> pq = new PriorityQueue<>();
	static Work[] works;
	static int answer = 0;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		works = new Work[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			works[i] = new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(works, (x, y) -> {
			return x.start - y.start;
		});
	}

	static void solve() {
		for (Work w : works) {
			if (pq.isEmpty()) {
				pq.add(w);
			} else {
				if (pq.peek().end <= w.start) {
					pq.poll();
				}
				pq.add(w);
			}
			if(answer < pq.size()) {
				answer = pq.size();
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {
		input();
		solve();
	}
}