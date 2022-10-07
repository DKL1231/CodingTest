import java.io.*;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = {0,0,0,0,0,0,0,0,0};
		int temp = N;
		
		while(temp!=0) {
			int tmp = temp%10;
			temp /= 10;
			if(tmp == 9)
				num[6] += 1;
			else
				num[tmp] += 1;
		}
		for(int i = 0; i < 9; i++) {
			if(i == 6) {
				if(num[i]%2 == 0)
					temp = Math.max(num[i]/2, temp);
				else
					temp = Math.max(num[i]/2+1, temp);
			}
			else
				temp = Math.max(num[i], temp);
		}
		System.out.println(temp);
	}
}	
