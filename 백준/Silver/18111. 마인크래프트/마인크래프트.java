import java.io.*;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		long B = Long.parseLong(temp[2]);
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		int[][] land = new int[N][M];
		for(int i = 0; i<N; i++) {
			String[] str_land = br.readLine().split(" ");
			for(int j = 0; j<M; j++) {
				land[i][j] = Integer.parseInt(str_land[j]);
				if(land[i][j] > max)
					max = land[i][j];
				if(land[i][j] < min)
					min = land[i][j];
			}
		}
		int time = Integer.MAX_VALUE;
		int time_temp;
		long B_temp;
		int result=min;
		fin : for(int i = min; i<=max; i++) {
			time_temp = 0;
			B_temp = B;
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<M; k++) {
					if(land[j][k] < i) {
						time_temp += i-land[j][k];
						B_temp -= i-land[j][k];
					}
					else if(land[j][k] > i) {
						time_temp += 2*(land[j][k]-i);
						B_temp += land[j][k]-i;
					}
				}
			}
			if(time>=time_temp && B_temp >= 0) {
				time = time_temp;
				result = i;
			}
		}
		System.out.println(time+" "+result);
	}
}
