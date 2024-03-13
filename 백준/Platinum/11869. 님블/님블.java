import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

class Main {
	static int m;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		m = Integer.parseInt(br.readLine());
		
		int tmp = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<m; i++) {
			tmp ^= Integer.parseInt(st.nextToken());
		}
		if(tmp == 0) System.out.println("cubelover");
		else System.out.println("koosaga");
	}
}