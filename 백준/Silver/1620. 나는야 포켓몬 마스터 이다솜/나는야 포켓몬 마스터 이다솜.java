import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> pokemon = new HashMap<String, String>();
		
		String temp;
		for(int i = 0; i<N; i++) {
			temp = br.readLine();
			pokemon.put(Integer.toString(i+1), temp);
			pokemon.put(temp, Integer.toString(i+1));
		}
		
		
		for(int i = 0; i<M; i++) {
			temp = br.readLine();
			System.out.println(pokemon.get(temp));
		}
	}
}
