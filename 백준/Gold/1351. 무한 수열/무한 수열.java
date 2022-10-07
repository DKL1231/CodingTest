import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
public class Main {
	static HashMap<Long, Long> map = new HashMap<>();
	static int P, Q;
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long N = Long.parseLong(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		map.put((long)0, (long)1);
		System.out.println(map_get(N));
	}
	static long map_get(long n) {
		if(map.containsKey(n)) return map.get(n);
		
		map.put(n, map_get(n/P)+map_get(n/Q));
		return map.get(n);
	}
}
