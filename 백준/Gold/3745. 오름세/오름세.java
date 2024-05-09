import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dp;
	static int[] num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static int search(int num, int length, int[] arr) {
		int result = 0;
		int lt = 0;
		int rt = length -1;
		while(lt<=rt) {
			int mid = (lt + rt)/2;
			if(arr[mid] >= num) {
				rt = mid - 1;
				result = mid;
			} else {
				lt = mid + 1;
			}
		}
		return result;
	}
	
	static boolean input() throws Exception {
		String inp = br.readLine();
		if(inp == null || inp.equals("")) return false;
		n = Integer.parseInt(inp.trim());
		num = new int[n];
		dp = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		return true;
	}
	
	static int solve() {
		int[] tmp = new int[n];
		int idx = 0;
		for(int i = 0; i<n; i++) {
			if(i == 0) {
				dp[i] = 1;
				tmp[idx++] = num[i];
			}else {
				if(tmp[idx-1] < num[i]) {
					dp[i] = idx+1;
					tmp[idx++] = num[i];
				}else {
					int index = search(num[i], idx+1, tmp);
					dp[i] = index+1;
					tmp[index] = num[i];
				}
			}
//			for(int j = 0; j<idx; j++)
//				System.out.print(tmp[j]+" ");
//			System.out.println();
		}
		
		return idx;
	}

	public static void main(String[] args) throws Exception {
		while(input()) {
			System.out.println(solve());
		}
	}
}