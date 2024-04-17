import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Node {
	Set<Integer> child = new HashSet<>();
}

public class Main {
	static int n;
	static Node[] nodes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		nodes = new Node[n + 1];
		for (int i = 1; i <= n; i++)
			nodes[i] = new Node();
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
			nodes[from].child.add(to);
			nodes[to].child.add(from);
		}
		st = new StringTokenizer(br.readLine(), " ");
		Queue<Integer> q = new LinkedList<>();
		int[] lst = new int[n];
		int prv = 1;
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			lst[i] = Integer.parseInt(st.nextToken());
		}
		outer: for (int i = 0; i < n; i++) {
			int now = lst[i];
			if (i == 0) {
				if (now != 1) {
					flag = false;
					break;
				}
				prv = now;
				continue;
			}
			while (nodes[prv].child.isEmpty()) {
				if (q.isEmpty()) {
					flag = false;
					break outer;
				}
				prv = q.poll();
			}
			if (nodes[prv].child.contains(now)) {
				q.add(now);
				nodes[prv].child.remove(now);
				nodes[now].child.remove(prv);
			} else {
				flag = false;
				break outer;
			}
		}

		if (flag)
			System.out.println(1);
		else
			System.out.println(0);
	}
}
