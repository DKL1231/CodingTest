import java.io.*;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int K = Integer.parseInt(temp[0]);
		int N = Integer.parseInt(temp[1]);
		
		int[] arr = new int[K];
		long max = 0;
		long min = 1;
		long mid = 0;
		for(int i = 0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] > max)
				max = arr[i];
		}
		max++;
		while (min < max) {
			mid = (max+min)/2;
			long cnt = 0;
			for(int i = 0; i < K ; i++)
				cnt += arr[i] / mid;
			
			if (cnt < N)
				max = mid;
			else
				min = mid + 1;
		}
		System.out.println(min-1);
	}
}
