import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class valueWithIdx{
	public long v;
	int i;
	public valueWithIdx(long v, int i) {
		this.v = v;
		this.i = i;
	}
}

class SegTree {
	valueWithIdx[] tree;
	valueWithIdx[] origin;
	
	public valueWithIdx CompareValueWithIdx(valueWithIdx a, valueWithIdx b) {
		if(a == null) return b;
		if(b == null) return a;
		if(a.v == b.v) {
			if(a.i<b.i) return a;
			return b;
		}
		if(a.v<b.v) return a;
		return b;
	}
	
	public SegTree(int n, valueWithIdx[] origin) {
		tree = new valueWithIdx[n * 4];
		this.origin = origin.clone();
		initNode(1, origin.length-1, 1);
	}
	
	private valueWithIdx initNode(int start, int end, int position) {
		if (start == end) {
			tree[position] = origin[start];
			return tree[position];
		}
		int mid = (start + end) / 2;
		tree[position] = CompareValueWithIdx(initNode(start, mid, position * 2), initNode(mid + 1, end, position * 2 + 1));
		return tree[position];
	}
	
	public valueWithIdx findWhere(int start, int end, int from, int to, int position) {
		if(start>to || end<from) return null;
		
		if(from<=start && end<=to) return tree[position];
		
		int mid = (start+end)/2;
		return CompareValueWithIdx(findWhere(start, mid, from, to, position * 2), findWhere(mid + 1, end, from, to, position * 2 + 1));
	}

	public valueWithIdx update(int start, int end, int position, int where, long value) {
		if (where < start || where > end)
			return tree[position];

		if (start == end) {
			tree[position].v = value;
			return tree[position];
		}

		int mid = (start + end) / 2;
		tree[position] = CompareValueWithIdx(update(start, mid, position * 2, where, value), update(mid + 1, end, position * 2 + 1, where, value));				
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
		valueWithIdx[] origin = new valueWithIdx[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			origin[i] = new valueWithIdx(Long.parseLong(st.nextToken()), i); 
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
				sb.append(sgt.findWhere(1, n, from, to, 1).i+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}