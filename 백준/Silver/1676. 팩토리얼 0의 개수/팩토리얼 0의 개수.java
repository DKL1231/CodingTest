import java.io.*;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i = 1; i<=N; i++) {
			if(i%5 == 0)
				cnt++;
			if(i%25 == 0)
				cnt++;
			if(i%125 == 0)
				cnt++;
		}
		System.out.println(cnt);
	}
}
