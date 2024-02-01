import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	static int N;
	static ArrayList<Integer> prime;
	
	static void makePrime(int cnt, int now) {
		if(cnt == N) {
			System.out.println(now);
			return;
		}
		for(int i = 1; i<=9; i++) {
			int tmp = 10*now+i;
			if(tmp == 1) continue;
			if(checkPrime(tmp)) {
				makePrime(cnt+1, tmp);
			}
		}
	}
	static boolean checkPrime(int num) {
		for(int j = 0; j<prime.size(); j++) {
			if(prime.get(j)>Math.pow(num, 0.5)) return true;
			if(num%prime.get(j) == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		prime = new ArrayList<>();
		
		prime.add(2);
		for(int i = 3; i<=Math.pow(10, N/2+1); i++) {
			boolean flag = true;
			for(int j = 0; j<prime.size(); j++) {
				if(prime.get(j)>Math.pow(i, 0.5)) break;
				if(i%prime.get(j) == 0) {
					flag = false;
					break;
				}
			}
			if(flag) prime.add(i);
		}
		makePrime(0, 0);
	}
}