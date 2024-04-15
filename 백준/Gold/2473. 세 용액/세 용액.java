import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long[] water;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		water = new long[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			water[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(water);
		long[] answer = new long[3];
		long nowMin = Long.MAX_VALUE;

		for(int i = 0; i<n; i++) {
			for(int j = n-1; j>=0; j--) {
				if(j<=i+1) break;
				long now = water[i]+water[j];
				int innerleft = i+1;
				int innerright = j-1;
				int innermid = (innerleft+innerright)/2;
				while(innerleft<innerright) {
					innermid = (innerleft + innerright) / 2;
					if (now + water[innermid] < 0) {
						innerleft = innermid + 1;
					} else if (now + water[innermid] > 0) {
						innerright = innermid;
					} else {
						break;
					}
				}
				//System.out.println(i+":"+water[i]);
				//System.out.println(innermid+":"+water[innermid]);
				//System.out.println(j+":"+water[j]);
				//System.out.println();
				if(innermid-1>i) {
					if(Math.abs(now+water[innermid-1])<Math.abs(now+water[innermid])) {
						long tmp = now + water[innermid-1];
						if (Math.abs(nowMin) > Math.abs(tmp)) {
							nowMin = tmp;
							answer[0] = water[i];
							answer[1] = water[innermid-1];
							answer[2] = water[j];
						}
					}
				}
				if(innermid+1<j) {
					if(Math.abs(now+water[innermid+1])<Math.abs(now+water[innermid])) {
						long tmp = now + water[innermid+1];
						if (Math.abs(nowMin) > Math.abs(tmp)) {
							nowMin = tmp;
							answer[0] = water[i];
							answer[1] = water[innermid+1];
							answer[2] = water[j];
						}
					}
				}
				
				long tmp = now + water[innermid];
				if (Math.abs(nowMin) > Math.abs(tmp)) {
					nowMin = tmp;
					answer[0] = water[i];
					answer[1] = water[innermid];
					answer[2] = water[j];
				}
				//System.out.println(nowMin);
				//System.out.println(answer[0]);
				//System.out.println(answer[1]);
				//System.out.println(answer[2]);
				//System.out.println("---");
				
			}
		}
		
		for (long l : answer)
			System.out.print(l + " ");
	}
}
