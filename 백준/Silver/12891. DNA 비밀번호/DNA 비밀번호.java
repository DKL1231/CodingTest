import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class Main {
	static int S, P;
	static String dnaString;
	static int answer = 0;
	static int[] nowList;
	static int[] leastValue = new int[4];
	
	public static int countChar(String str, char ch) {
		return (int)str.chars().filter(c->c==ch).count();
	}
	
	static boolean checkAnswer() {
		for(int i = 0; i<4; i++) {
			if(nowList[i]<leastValue[i]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Map<Character, Integer> charMap = new HashMap<>();
		charMap.put('A', 0);
		charMap.put('C', 1);
		charMap.put('G', 2);
		charMap.put('T', 3);
		nowList = new int[4];
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dnaString = br.readLine();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<4; i++) {
			leastValue[i] = Integer.parseInt(st.nextToken());
		}
		char[] dnaCharArr = dnaString.toCharArray();
		for(int i = 0; i<P; i++) {
			nowList[charMap.get(dnaCharArr[i])]++;
		}
		if(checkAnswer()) answer++;
		
		for(int i = 0; i<S-P; i++) {
			nowList[charMap.get(dnaCharArr[i])]--;
			nowList[charMap.get(dnaCharArr[i+P])]++;
			if(checkAnswer()) answer++;
		}
		
		System.out.println(answer);
	}
}