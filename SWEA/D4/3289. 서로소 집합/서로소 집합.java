import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, n, m;
	static int parent[];

	static void initParent() {
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}

	static int findParent(int a) {
		if(a == parent[a]) return a;
		return parent[a] = findParent(parent[a]);
	}
	
	static void unionParent(int a, int b) {
		int pa = findParent(a);
		int pb = findParent(b);
		
		if(pa != pb) {
			parent[pb] = pa;
			findParent(b);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			StringBuilder sb = new StringBuilder();
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parent = new int[n + 1];
			initParent();
			for(int i = 0; i<m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int how, a, b;
				how = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if(how == 1) {
					if(findParent(a) == findParent(b)) sb.append(1);
					else sb.append(0);
				}else if(how == 0) {
					unionParent(a, b);
				}
			}
			System.out.println("#"+tc+" "+sb.toString());
		}
	}
}