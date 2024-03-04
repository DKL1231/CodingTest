import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int stones[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			stones = new int[n];
			int answer = 0;

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				stones[i] = Integer.parseInt(st.nextToken());
			}

			int tmp = 0;
			for (int i = 0; i < n; i++)
				tmp ^= stones[i];
			if (tmp == 0) {
				System.out.println(0);
				continue;
			}
			for (int i = 0; i < n; i++)
				if ((tmp ^ stones[i]) < stones[i])
					answer++;
			System.out.println(answer);
		}
	}
}
