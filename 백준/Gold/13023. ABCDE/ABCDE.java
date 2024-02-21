import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static ArrayList<ArrayList<Integer>> friend;
	static int answer = 0;
	static boolean[] visit;
	static void dfs(int depth, int now) {
		if(depth == 4) {
			answer = 1;
			return;
		}
		for(int i = 0; i<friend.get(now).size(); i++) {
			if(!visit[friend.get(now).get(i)]) {
				visit[friend.get(now).get(i)] = true;
				dfs(depth+1, friend.get(now).get(i));
				visit[friend.get(now).get(i)] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		friend = new ArrayList<>();
		visit = new boolean[n];
		for(int i = 0; i<n; i++) {
			friend.add(new ArrayList<>());
		}
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friend.get(a).add(b);
			friend.get(b).add(a);
		}
		for(int i = 0; i<n; i++) {
			if(answer == 1) break;
			visit[i] = true;
			dfs(0, i);
			visit[i] = false;
		}
		System.out.println(answer);
	}
}