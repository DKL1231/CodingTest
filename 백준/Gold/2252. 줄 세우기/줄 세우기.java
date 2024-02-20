import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {
	static int n, m;
	static int[] student;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		student = new int[n+1];
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for(int i = 0; i<=n; i++) arr.add(new ArrayList<>());
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from, to;
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			arr.get(from).add(to);
			student[to]++;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i<=n; i++)
			if(student[i] == 0) q.add(i);
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now+" ");
			for(int i = 0; i<arr.get(now).size(); i++) {
				if(--student[arr.get(now).get(i)] == 0) {
					q.add(arr.get(now).get(i));
				}
			}
		}
		System.out.println(sb.toString());
	}
}