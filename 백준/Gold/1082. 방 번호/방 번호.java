import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] price = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			price[i] = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());

		int canBuycnt = 0;
		int minPrice = Integer.MAX_VALUE;
		int zeroPriceAndMinPrice = price[0];
		String answer = "";
		for (int i = 1; i < N; i++) {
			minPrice = Math.min(minPrice, price[i]);
		}
		zeroPriceAndMinPrice = Math.min(zeroPriceAndMinPrice, minPrice);
		if (M < minPrice) {
			System.out.println(0);
			return;
		}
		int tmp = M;
		canBuycnt = 1;
		tmp -= minPrice;
		canBuycnt += tmp / zeroPriceAndMinPrice;
		tmp %= zeroPriceAndMinPrice;
		for(int i = N-1; i>=1; i--) {
			if(tmp >= price[i]-minPrice) {
				tmp -= price[i]-minPrice;
				canBuycnt--;
				answer += i;
				break;
			}
		}
		for (int i = 0; i < N; i++) {
			price[i] -= zeroPriceAndMinPrice;
		}
		while (canBuycnt != 0) {
			for(int i = N-1; i>=0; i--) {
				if(tmp >= price[i]) {
					answer += i;
					tmp -= price[i];
					break;
				}
			}
			canBuycnt--;
		}
		System.out.println(answer);
	}
}