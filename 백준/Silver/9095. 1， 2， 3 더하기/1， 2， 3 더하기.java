import java.io.*;
public class Main {
	static int r;
	static int c;
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] num = new int[11];
		num[1] = 1;
		num[2] = 2;
		num[3] = 4;
		for(int i = 0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			for(int j = 4; j<=n; j++)
				num[j] = num[j-1] + num[j-2] + num[j-3];
			System.out.println(num[n]);
		}
	}
}
