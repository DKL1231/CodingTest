import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] mosq = new int[N*2];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			mosq[2*i] = Integer.parseInt(st.nextToken());
			mosq[2*i+1] = Integer.parseInt(st.nextToken());
		}
		int[] mosqPressed = Arrays.stream(mosq).distinct().toArray();
		Arrays.sort(mosqPressed);
		Map<Integer, Integer> m = new HashMap<>();
		for(int i = 0; i<mosqPressed.length; i++) {
			m.put(mosqPressed[i], i);
		}
		
		int[] preSum = new int[mosqPressed.length];
		for(int i = 0; i<N; i++) {
			int from = m.get(mosq[2*i]);
			int to = m.get(mosq[2*i+1]);
			for(int j = from; j<to; j++) {
				preSum[j]++;
			}
		}
		int maxValue = -1;
		int fptr=0, bptr=0;
		for(int i = 0; i<preSum.length; i++) {
			if(preSum[i] > maxValue) {
				fptr = i;
				bptr = i;
				maxValue=preSum[i];
			} else if(preSum[i] == maxValue && preSum[i] == preSum[i-1]) {
				bptr++;
			}
		}
		System.out.println(preSum[fptr]);
		System.out.println(mosqPressed[fptr]+" "+mosqPressed[bptr+1]);
	}
}