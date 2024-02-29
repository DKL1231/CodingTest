import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

//st = new StringTokenizer(br.readLine(), " ");

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int a, b;

		st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		Set<Integer> visit = new HashSet<>();

		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		visit.add(a);
		int answer = 0;
		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs-- != 0) {
				int now = q.poll();
				if (now == b) {
					System.out.println(answer+1);
					return;
				}
				if (b / 10 >= now && !visit.contains(now * 10 + 1)) {
					q.add(now * 10 + 1);
					visit.add(a * 10 + 1);
				}
				if (b / 2 >= now && !visit.contains(now * 2)) {
					q.add(now * 2);
					visit.add(now * 2);
				}
			}
			answer++;
		}
		System.out.println(-1);
	}
}