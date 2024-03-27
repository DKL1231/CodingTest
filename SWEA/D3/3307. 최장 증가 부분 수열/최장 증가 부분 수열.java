import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int[] lis = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i<n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			int max = 0;
			for(int i = 0; i<n; i++) {
				int position = Arrays.binarySearch(lis, 0, max, arr[i]);
				position = Math.abs(position)-1;
				
				lis[position] = arr[i];
				if(max == position) max++;
			}
			System.out.println("#"+test_case+" "+max);
		}
	}
}
