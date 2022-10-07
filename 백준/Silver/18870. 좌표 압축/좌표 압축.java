import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] lst = new int[N];
		int[] org = new int[N];
		HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i<N; i++) {
			lst[i] = org[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(lst);
		int cnt=0;
		for(int i : lst)
			if(!temp.containsKey(i)) {
				temp.put(i, cnt);
				cnt++;
			}
		
		StringBuilder str = new StringBuilder();
		for(int i = 0; i<N; i++)
			str.append(temp.get(org[i])+" ");
		System.out.println(str);
	}
}

