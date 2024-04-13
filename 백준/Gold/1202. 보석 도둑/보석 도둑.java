import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewelry implements Comparable<Jewelry> {
	int w, v;

	public Jewelry(int w, int v) {
		this.w = w;
		this.v = v;
	}

	@Override
	public int compareTo(Jewelry o) {
		// TODO Auto-generated method stub
		return o.v - v;
	}

}

class Main {
	static int n, k;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		Jewelry[] jewelrys = new Jewelry[n];
		int[] bag = new int[k];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			jewelrys[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(jewelrys, new Comparator<Jewelry>() {
			@Override
			public int compare(Jewelry a, Jewelry b) {
				return a.w - b.w;
			}
		});
		for (int i = 0; i < k; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bag);
		PriorityQueue<Jewelry> pq = new PriorityQueue<>();
		int idx = 0;
		long result = 0;
		for(int b: bag) {
			for(; idx<jewelrys.length && jewelrys[idx].w<=b; idx++) {
				pq.add(jewelrys[idx]);
			}
			if(!pq.isEmpty())
				result+=pq.poll().v;
		}
		System.out.println(result);
	}
}
