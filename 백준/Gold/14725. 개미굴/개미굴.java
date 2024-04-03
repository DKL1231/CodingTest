import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	String value;
	int depth;
	Map<String, Node> child = new HashMap<>();
	
	public Node(String value, int depth) {
		this.value = value;
		this.depth = depth;
	}
	
	public void add(Queue<String> q) {
		if(q.isEmpty()) return;
		
		String next = q.poll();
		if(child.containsKey(next)) {
			child.get(next).add(q);
		}else {
			child.put(next, new Node(next, this.depth+1));
			child.get(next).add(q);
		}
	}
	
	public void search(StringBuilder sb) {
		if(depth>=0) {
			for(int i = 0; i<depth; i++) {
				sb.append("--");
			}
			sb.append(this.value+"\n");
		}
		ArrayList<String> keyList = new ArrayList<>(child.keySet());
		Collections.sort(keyList);
		for(String key: keyList) {
			child.get(key).search(sb);
		}
	}

}

public class Main {
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		Node root = new Node("", -1);
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			Queue<String> q = new LinkedList<>();
			
			for(int j = 0; j<m; j++) {
				q.add(st.nextToken());
			}
			root.add(q);
		}
		root.search(sb);
		System.out.println(sb.toString());
	}
}