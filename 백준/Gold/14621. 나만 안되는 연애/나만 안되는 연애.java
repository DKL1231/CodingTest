import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Road implements Comparable<Road>{
	int from;
	int to;
	int w;

	public Road(int from, int to, int w) {
		this.from = from;
		this.to = to;
		this.w = w;
	}

	@Override
	public int compareTo(Road o) {
		// TODO Auto-generated method stub
		if(o.w < w)
			return 1;
		else if(o.w > w)
			return -1;
		return 0;
	}
}

public class Main {
	static int N, M;
	static ArrayList<Road> Roads;
	static int[] parents;

	static void unionParent(int a, int b) {
		int aParent = findParent(a);
		int bParent = findParent(b);
		if (aParent != bParent) {
			parents[a] = bParent;
			parents[aParent] = bParent;
		}
	};

	static int findParent(int a) {
		if(a == parents[a]) return a;
		parents[a] = findParent(parents[a]);
		return parents[a];
	};
	
	static boolean isUnion(int a, int b) {
		int aParent = findParent(a);
		int bParent = findParent(b);
		if(aParent == bParent) return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Roads = new ArrayList<>();
		parents = new int[N + 1];
		String[] schoolType = new String[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
			schoolType[i] = st.nextToken();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from, to, w;
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			if (schoolType[from].equals(schoolType[to]))
				continue;
			Roads.add(new Road(from, to, w));
			Roads.add(new Road(to, from, w));
		}
		Collections.sort(Roads);
		
		int answer = 0;
		for(Road r:Roads) {
			if(!isUnion(r.from, r.to)) {
				unionParent(r.from, r.to);
				answer += r.w;
			}
		}
		for(int i = 1; i<N; i++) {
			if(!isUnion(i, i+1)) {
				answer = -1;
				break;
			}
		}
		System.out.println(answer);
	}
}