import java.io.*;
import java.util.HashMap;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, String> temp = new HashMap<String, String>();
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			String tmp = br.readLine();
			if(tmp.equals("ENTER")) {
				temp.clear();
				continue;
			}
			if(temp.containsKey(tmp)) continue;
			temp.put(tmp, tmp);
			cnt++;
		}
		System.out.println(cnt);
	}
}
