import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> pswd = new HashMap<String, String>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pswd.put(st.nextToken(), st.nextToken());
		}
		for(int i = 0; i < M; i++)
			System.out.println(pswd.get(br.readLine()));
	}
}
