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
		tree[position] = initNode(start, mid, position * 2) + initNode(mid + 1, end, position * 2 + 1);
		return tree[position];
	}
	
	public long findWhere(int start, int end, int position, long target) {
		 if(start == end) return start;

		int mid = (start + end) / 2;
		if(target <= tree[2*position]) {
			return findWhere(start, mid, position * 2, target);
		}else {
			return findWhere(mid + 1, end, position * 2 + 1, target-tree[2*position]);
		}
	}

	public long update(int start, int end, int position, int where, long value) {
		if (where < start || where > end)
			return tree[position];

		if (start == end) {
			tree[position] += value;
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
				int who = Integer.parseInt(st.nextToken()); 
				sb.append(sgt.findWhere(1, n, 1, who)+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}