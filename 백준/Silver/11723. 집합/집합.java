import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] S = new int[21];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String txt = st.nextToken();
			
			if(txt.equals("all"))
				for(int j = 1; j<=20; j++)
					S[j] = 1;
			else if(txt.equals("empty"))
				for(int j = 1; j<=20; j++)
					S[j] = 0;
			else {
				int num = Integer.parseInt(st.nextToken());
				switch (txt) {
				case "add":
					S[num] = 1;
					break;
				case "remove":
					S[num] = 0;
					break;
				case "check":
					sb.append(S[num]+"\n");
					break;
				case "toggle":
					S[num] = (S[num]+1)%2;
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
