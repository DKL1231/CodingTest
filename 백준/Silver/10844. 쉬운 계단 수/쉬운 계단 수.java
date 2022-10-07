import java.io.*;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] stair_num = new int[N+1][10];
		for(int i = 0; i<=9; i++)
			stair_num[1][i] = 1;

		for(int i = 2; i<=N; i++) {
			for(int j = 0; j<=9; j++) {
				if(j == 0)
					stair_num[i][j] = stair_num[i-1][j+1];
				else if(j == 9)
					stair_num[i][j] = stair_num[i-1][j-1];
				else
					stair_num[i][j] = stair_num[i-1][j-1] + stair_num[i-1][j+1];
				stair_num[i][j] %= 1000000000;
			}
		}
		
		int result = 0;
		for(int i = 1; i<=9; i++) // 첫자리 0오는경우 불가
			result = (result+stair_num[N][i]) % 1000000000;
		System.out.println(result);
	}
}
