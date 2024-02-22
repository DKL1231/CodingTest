import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] people;
	static int[] parent;
	static boolean[] visit;
	static ArrayList<Integer>[] connect;
	static int answer = Integer.MAX_VALUE;

	static void selectCity(int now, int cnt) {
		if (now > n) {
			if (cnt == n || cnt == 0) // 0개선택 또는 다선택시 안함
				return;
			if(checkAvail(true) && checkAvail(false)) {
				cntAnswer();
			}
			return;
		}
		visit[now] = true;
		selectCity(now + 1, cnt + 1);
		visit[now] = false;
		selectCity(now + 1, cnt);
	}

	static boolean checkAvail(boolean type) {
		boolean[] tmpVisit = new boolean[n + 1];
		int startIdx = -1;
		for (int i = 1; i <= n; i++) {
			if (visit[i] == type) {
				startIdx = i;
				break;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(startIdx);
		tmpVisit[startIdx] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			for(int next: connect[now]) {
				if(visit[next] == type && !tmpVisit[next]) {
					tmpVisit[next] = true;
					q.add(next);
				}
			}
		}
		for(int i = 1; i<=n; i++) {
			if(visit[i] == type && !tmpVisit[i]) {
				return false;
			}
		}
		return true;
	}

	static void cntAnswer() {
		int tmp1 = 0, tmp2 = 0;
		for (int i = 1; i <= n; i++) {
			if (visit[i])
				tmp1 += people[i];
			else
				tmp2 += people[i];
		}
		answer = Math.min(answer, Math.abs(tmp1 - tmp2));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		people = new int[n + 1];
		visit = new boolean[n + 1];
		parent = new int[n + 1];
		connect = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			connect[i] = new ArrayList<>();
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int tmp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < tmp; j++) {
				connect[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		selectCity(1, 0);
		if (answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
}