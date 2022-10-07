import java.io.*;

public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		double cnt = 0;
		for(int i = 0; i<S.length(); i++)
			if(S.charAt(i)!='C') cnt++;
		int answer = (int) Math.ceil((S.length()-cnt)/(cnt+1));
		System.out.println(answer);
	}
}
