import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] bridges = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++)
			bridges[i] = Integer.parseInt(st.nextToken());
		int tmp = 0;
		for (int i = 0; i < n; i++)
			tmp ^= bridges[i]-2;
		
		String firstKing = br.readLine();
		
		if (tmp == 0)
			System.out.println(firstKing.equals("Whiteking")?"Blackking":"Whiteking");
		else
			System.out.println(firstKing);
	}
}