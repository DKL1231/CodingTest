import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		
		long result;
		long r;
		long temp_a = A;
		long temp_b = B;
		while(true) {
			r = temp_a%temp_b;
			if(r == 0) break;
			temp_a = temp_b;
			temp_b = r;
		}
		System.out.println(A*B/temp_b);
	}
}
