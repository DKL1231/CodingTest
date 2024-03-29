import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] sisterVisitTime = new int[500_001];
	static boolean[][] subinVisit = new boolean[2][500_001]; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		if (n == k) {
			System.out.println(0);
			return;
		}
		
		for (int i = 1; k+i <= 500_000; i++) {
			k += i;
			sisterVisitTime[k] = i;
		}
		int answer = Integer.MAX_VALUE;
		int time = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		while (!q.isEmpty()) {
			if(answer<=time) break;
			int qs = q.size();
			while (qs-- != 0) {
				int now = q.poll();
				int[] next = new int[3];
				next[0] = now - 1;
				next[1] = now + 1;
				next[2] = now << 1;

				for (int n : next) {
					if (n < 0 || n > 500_000 || subinVisit[(time+1)%2][n])
						continue;		
					if(time+1<=sisterVisitTime[n] && (time+1)%2 == sisterVisitTime[n]%2) {
						if(answer > sisterVisitTime[n]) {
							answer = sisterVisitTime[n];
						}
					}
					subinVisit[(time+1)%2][n] = true;
					q.add(n);
				}
			}
			time++;
		}
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
}