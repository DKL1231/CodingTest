import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<String> dfs(int n) {
		if (n == 3) {
			ArrayList<String> s = new ArrayList<>();
			s.add("  *  ");
			s.add(" * * ");
			s.add("*****");
			return s;
		}
		ArrayList<String> tmp = dfs(n / 2);
		ArrayList<String> newString = new ArrayList<>();
		String tmpString;
		tmpString = "";
		for (int i = 0; i < n / 2; i++)
			tmpString += " ";
		for (int i = 0; i < tmp.size(); i++) {
			newString.add(tmpString + tmp.get(i) + tmpString);
		}
		for (int i = 0; i < tmp.size(); i++) {
			newString.add(tmp.get(i) + " " + tmp.get(i));
		}
		return newString;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<String> result = dfs(N);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}