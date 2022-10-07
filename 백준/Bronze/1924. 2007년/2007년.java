import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int[] month = {0, 31,28,31,30,31,30,31,31,30,31,30,31};
		String[] date = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int tmp = 0;
		for(int i = 0; i<x; i++)
			tmp += month[i];
		tmp += y;
		tmp %= 7;
		System.out.println(date[tmp]);
	}
}
