import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int[][] map;
	static int n;
	static int calMax() {
		int a, b, c;
		int prva, prvb, prvc;
		a = map[0][0];
		b = map[0][1];
		c = map[0][2];
		prva = a;
		prvb = b;
		prvc = c;
		for(int i = 1; i<n; i++) {
			a = Math.max(prva, prvb)+map[i][0];
			b = Math.max(Math.max(prva, prvb), prvc)+map[i][1];
			c = Math.max(prvb, prvc)+map[i][2];
			
			prva = a;
			prvb = b;
			prvc = c;
		}
		return (int) Math.max(Math.max(a, b),c);
	}
	
	static int calMin() {
		int a, b, c;
		int prva, prvb, prvc;
		a = map[0][0];
		b = map[0][1];
		c = map[0][2];
		prva = a;
		prvb = b;
		prvc = c;
		for(int i = 1; i<n; i++) {
			a = Math.min(prva, prvb)+map[i][0];
			b = Math.min(Math.min(prva, prvb), prvc)+map[i][1];
			c = Math.min(prvb, prvc)+map[i][2];
			
			prva = a;
			prvb = b;
			prvc = c;
		}
		return (int) Math.min(Math.min(a, b),c);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][3];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<3; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
			}
		}
		System.out.println(calMax()+" "+calMin());
	}
}