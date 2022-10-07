import java.io.*;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		char[] word = new char[input.length()];
		for(int i = 0; i < input.length(); i++)
			word[i] = input.charAt(i);
		input = br.readLine();
		char[] psword = new char[input.length()];
		for(int i = 0; i < input.length(); i++)
			psword[i] = input.charAt(i);
		
		long result = 0;
		long tmp = 1;
		for(int i = psword.length-1; i >= 0; i--) {
			for(int j = 0; j < word.length; j++) {
				if(psword[i] == word[j]) {
					result = (result+tmp*(j+1))%900528;
					tmp = (tmp*word.length)%900528;
				}
			}
		}
		System.out.println(result);
	}
}