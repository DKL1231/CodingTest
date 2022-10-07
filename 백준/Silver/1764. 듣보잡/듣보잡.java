import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> person = new HashMap<String, Integer>();
		ArrayList<String> no_HS = new ArrayList<String>();
		for(int i = 0; i < N; i++)
			person.put(br.readLine(), i);
		for(int i = 0; i < M; i++) {
			String temp = br.readLine();
			if (person.containsKey(temp))
				no_HS.add(temp);
		}
		no_HS.sort(null);
		System.out.println(no_HS.size());
		for (int i = 0; i < no_HS.size(); i++)
			System.out.println(no_HS.get(i));
	}
}
