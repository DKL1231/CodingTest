import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static int n, k;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		k = Integer.parseInt(br.readLine());
		
		
		
		
		int left = 0;
		int right = n-1;
		int answer = 0;
		while(left< right) {
			int sum = arr[left]+arr[right];
			if(sum == k) {
				answer++;
				right--;
			}else if(sum < k) {
				left++;
			}else {
				right--;
			}
		}
		System.out.println(answer);
	}
}
