import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int temp = A/2 + B;
		
		if(temp > N)
			System.out.println(N);
		else
			System.out.println(temp);
	}
}
