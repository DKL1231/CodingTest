import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {
	int from, to;

	public Time(int from, int to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public int compareTo(Time o) {
		// TODO Auto-generated method stub
		return from - o.from;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Time[] times = new Time[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			times[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(times);
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			if (pq.isEmpty() || times[i].from < pq.peek()) {
				answer++;
			} else{
				pq.poll();
			}
			pq.add(times[i].to);
		}
		System.out.println(answer);
	}
}
