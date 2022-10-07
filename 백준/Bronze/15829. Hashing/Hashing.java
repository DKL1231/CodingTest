import java.io.*;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String hash = br.readLine();
		long M = 1234567891;
		long result = 0;
		long r_i = 1;
		for (int i = 0; i<L; i++) {
			int temp = hash.charAt(i) - 'a' + 1;
			result += (temp*r_i)%M;
			r_i = (r_i*31)%M;
		}
		System.out.println(result%M);
	}
}
