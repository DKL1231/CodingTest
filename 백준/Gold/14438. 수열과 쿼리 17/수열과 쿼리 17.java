import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SegTree {
	long[] tree;
	long[] origin;

	public SegTree(int n, long[] origin) {
		tree = new long[n * 4];
		this.origin = origin.clone();
		initNode(1, origin.length-1, 1);
	}
	
	private long initNode(int start, int end, int position) {
		if (start == end) {
			tree[position] = origin[start];
			return tree[position];
		}
		int mid = (start + end) / 2;
		tree[position] = Math.min(initNode(start, mid, position * 2), initNode(mid + 1, end, position * 2 + 1));
		return tree[position];
	}
	
	public long getMin(int start, int end, int from, int to, int position) {
		if(tree[position] == 0) return Long.MAX_VALUE;
		if (to < start || end < from)
			return Long.MAX_VALUE;

		if (end <= to && start >= from)
			return tree[position];

		int mid = (start + end) / 2;
		return Math.min(getMin(start, mid, from, to, position * 2), getMin(mid + 1, end, from, to, position * 2 + 1));
	}

	public long update(int start, int end, int position, int where, long value) {
		if (where < start || where > end)
			return tree[position];

		if (start == end) {
			tree[position] = value;
			return tree[position];
		}

		int mid = (start + end) / 2;
		tree[position] = Math.min(update(start, mid, position * 2, where, value), update(mid + 1, end, position * 2 + 1, where, value));				
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
		
		n = Integer.parseInt(br.readLine());
		long[] origin = new long[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			origin[i] = Long.parseLong(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		
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
				sb.append(sgt.getMin(1, n, Math.min(from, to), Math.max(from, to), 1)+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}