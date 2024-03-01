import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<n;i ++) nums[i] = Integer.parseInt(st.nextToken());
		if(n < 2) {
			System.out.println("A");
			return;
		}
		if(n == 2) {
			if(nums[0] == nums[1]) System.out.println(nums[0]);
			else System.out.println("A");
			return;
		}
		// nums[1] = nums[0]*a+b, nums[2] = nums[1]*a+b
		// x증가량 : nums[1]-nums[0], y증가량 : nums[2]-nums[1]
		// 기울기(a) : (nums[2]-nums[1])/(nums[1]-nums[0])
		// y절편(b) : nums[1]-nums[0]*a
		
		if(nums[0] == nums[1]) {
			for(int i = 0; i<n-1; i++) {
				if(nums[i] != nums[i+1]) {
					System.out.println("B");
					return;
				}
			}
			System.out.println(nums[0]);
			return;
		}
		
		int a, b;
		if((nums[2]-nums[1])%(nums[1]-nums[0]) != 0) {
			System.out.println("B");//a는정수여야함
			return;
		}
		a = (nums[2]-nums[1])/(nums[1]-nums[0]);
		b = nums[1]-nums[0]*a;
		
		for(int i = 3; i<n; i++) {
			if(nums[i] != nums[i-1]*a+b) {
				System.out.println("B");
				return;
			}
		}
		System.out.println(nums[n-1]*a+b);
	}
}
