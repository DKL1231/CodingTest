import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int t, n;
	static int student[];
	static boolean visit[];
	static Set<Integer> nowVisit;
	static Stack<Integer> nowVisitList;
	static int cnt;

	static void dfs(int now) {
		if(nowVisit.contains(student[now])) {
			cnt++;
			while(!nowVisitList.isEmpty() && nowVisitList.pop() != student[now]) {
				cnt++;
			}
		}else if(!visit[student[now]]) {
			nowVisitList.push(student[now]);
			nowVisit.add(student[now]);
			visit[student[now]] = true;
			dfs(student[now]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			cnt = 0;
			n = Integer.parseInt(br.readLine());
			visit = new boolean[n + 1];
			student = new int[n + 1];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				student[i] = Integer.parseInt(st.nextToken());
				if(i == student[i]) {
					cnt++;
					visit[i] = true;
				}
			}
			for(int i = 1; i<=n; i++) {
				if(!visit[i]) {
					nowVisit = new HashSet<>();
					nowVisitList = new Stack<>();
					nowVisit.add(i);
					visit[i] = true;
					dfs(i);
				}
			}
			System.out.println(n - cnt);
		}
	}
}