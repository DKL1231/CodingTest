import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SegTree {
	long[] tree;
	long[] origin;

	public SegTree(int n, long[] origin) {
		tree = new long[n * 4];
		this.origin = origin.clone();
	}

	public long preSum(int start, int end, int from, int to, int position) {
		if(tree[position] == 0) return 0;
		if (to < start || end < from)
			return 0;

		if (end <= to && start >= from)
			return tree[position];

		int mid = (start + end) / 2;
		return preSum(start, mid, from, to, position * 2) + preSum(mid + 1, end, from, to, position * 2 + 1);
	}

	public long update(int start, int end, int position, int where, long value) {
		if (where < start || where > end)
			return tree[position];

		if (start == end) {
			tree[position] = value;
			return tree[position];
		}

		int mid = (start + end) / 2;
		tree[position] = update(start, mid, position * 2, where, value) + update(mid + 1, end, position * 2 + 1, where, value);
		return tree[position];
	}
}

class Main {
	static int n, m;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		long[] origin = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			origin[i] = 0;
		}
		SegTree sgt = new SegTree(n, origin);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int code;
			code = Integer.parseInt(st.nextToken());
			
			if(code == 1)
				sgt.update(1, n, 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			else {
				int from = Integer.parseInt(st.nextToken()); 
				int to = Integer.parseInt(st.nextToken()); 
				sb.append(sgt.preSum(1, n, Math.min(from, to), Math.max(from, to), 1)+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}