import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	static int n;
	static Set<String> s = new HashSet<String>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			String type = st.nextToken();
			
			if(type.equals("enter")) {
				s.add(name);
			}else {
				s.remove(name);
			}
		}
		PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(String str:s)
			pq.add(str);
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
