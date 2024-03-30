import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	static int n, c;
	static ArrayList<Long> left = new ArrayList<>(), right = new ArrayList<>();
	static int[] things;
	static void dfs(int depth, boolean type, long now) {
		if((type && depth==n/2) || (!type && depth==n-n/2)) {
			if(type) {
				left.add(now);
				return;
			}else {
				right.add(now);
				return;
			}
		}
		int nowIdx = depth;
		if(!type) nowIdx += n/2;
		
		dfs(depth+1, type, now);
		
		if(now+things[nowIdx]<=c)
			dfs(depth+1, type, now+things[nowIdx]);
	}
	
	static int find(long target, ArrayList<Long> list) {
		int left = 0;
		int right = list.size();
		
		while(left<right) {
			int mid = (left+right)/2;
			
			if(list.get(mid) >= target) {
				right = mid;
			}
			else {
				left = mid+1;
			}
		}
		return right;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		things = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<n; i++)
			things[i] = Integer.parseInt(st.nextToken());
		
		dfs(0, true, 0);
		dfs(0, false, 0);
		left.sort(null);
		right.sort(null);
		
		int answer = 0;
		
		for(long l: left) {
			int cnt = find(c-l+1, right);
			answer += cnt;
		}
		System.out.println(answer);
	}
}