import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Node {
	ArrayList<Integer> child = new ArrayList<>();
	ArrayList<Integer> weight = new ArrayList<>();
	int idx = 0;

	public Node() {
	}
}

class Main {
	static int left = 0;
	static int right = 0;
	static int answer = 0;
	static Node[] tree;

	static int dfs(int now) {
		if (tree[now].idx == 0)
			return 0;
		int[] result = new int[tree[now].idx];
		for (int i = 0; i < tree[now].idx; i++) {
			result[i] = dfs(tree[now].child.get(i)) + tree[now].weight.get(i);
		}
		Arrays.sort(result);
		
		if(result.length>=2) {
			answer = Math.max(result[result.length-1]+result[result.length-2], answer);
		}else {
			answer = Math.max(result[0], answer);
		}
		return result[result.length - 1];
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		tree = new Node[n + 1];
		for (int i = 0; i <= n; i++)
			tree[i] = new Node();
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			tree[from].child.add(to);
			tree[from].weight.add(w);
			tree[from].idx++;
		}
		dfs(1);
		System.out.println(answer);
	}
}