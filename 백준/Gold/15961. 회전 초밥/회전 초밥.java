import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n, d, k, c;
	static int sushi[];
	static int answer = 0;
	static Map<Integer, Integer> nowSushi = new HashMap<Integer, Integer>();
	
	static void countSushi(){
		int sushicnt = nowSushi.keySet().size();
		if(!nowSushi.keySet().contains(c)) sushicnt++;
		answer = Math.max(answer, sushicnt);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());		
		d = Integer.parseInt(st.nextToken());		
		k = Integer.parseInt(st.nextToken());		
		c = Integer.parseInt(st.nextToken());
		sushi = new int[n+k];
		for(int i = 0; i<n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		for(int i = n; i<n+k; i++) {
			sushi[i] = sushi[i-n]; // 환형인데 번거로워서 배열을 늘려 해결
		}
		int rp = k;
		for(int i = 0; i<k; i++) {
			nowSushi.put(sushi[i], nowSushi.keySet().contains(sushi[i])?nowSushi.get(sushi[i])+1:1);
		}
		countSushi();
		while(rp<n+k) {
			nowSushi.put(sushi[rp], nowSushi.keySet().contains(sushi[rp])?nowSushi.get(sushi[rp])+1:1);
			if(nowSushi.get(sushi[rp-k])==1) nowSushi.remove(sushi[rp-k]);
			else nowSushi.put(sushi[rp-k], nowSushi.get(sushi[rp-k])-1);
			countSushi();
			rp++;
		}
		System.out.println(answer);
	}
}