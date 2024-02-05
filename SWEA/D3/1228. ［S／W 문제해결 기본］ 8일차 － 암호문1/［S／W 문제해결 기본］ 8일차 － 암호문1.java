import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			LinkedList<Integer> ll = new LinkedList<>();
			for(int i = 0; i<N; i++) {
				ll.add(sc.nextInt());
			}
			int M = sc.nextInt();
			for(int i = 0; i<M; i++) {
				String unuse = sc.next();
				int from = sc.nextInt(), cnt = sc.nextInt();
				for(int j = 0; j<cnt; j++) {
					ll.add(j+from, sc.nextInt());
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#"+test_case+" ");
			for(int i = 0; i<10; i++) sb.append(ll.get(i)+" ");
			System.out.println(sb.toString());
		}
	}
}