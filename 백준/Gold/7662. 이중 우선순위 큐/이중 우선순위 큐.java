import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<T; i++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> queue = new TreeMap<>();
			for(int j = 0; j<k; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String doing = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				if(doing.equals("I")) {
					queue.put(n, queue.getOrDefault(n, 0)+1);
				}
				else {
					if(!queue.isEmpty()) {
						if(n == 1)
							n = queue.lastKey();
						else
							n = queue.firstKey();
						int temp = queue.get(n);
						if(temp == 1)
							queue.remove(n);
						else
							queue.put(n, temp-1);
					}
				}
			}
			if(queue.isEmpty())
				System.out.println("EMPTY");
			else {
				System.out.println(queue.lastKey()+" "+queue.firstKey());
			}
		}
	}	
}
