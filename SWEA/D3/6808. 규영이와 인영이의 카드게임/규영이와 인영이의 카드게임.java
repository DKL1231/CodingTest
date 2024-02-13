import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] cards;
	static int[] inCard;
	static int[] selectedInCard;
	static boolean[] visit;
	static int win = 0;
	static int lose = 0;
	static void solve(int depth) {
		if(depth == 9) {
			calScore();
			return;
		}
		
		for(int i = 0; i<9; i++) {
			if(!visit[i]) {
				visit[i] = true;
				selectedInCard[depth] = inCard[i];
				solve(depth+1);
				visit[i] = false;
			}
		}
	}
	static void calScore() {
		int gyuScore = 0;
		int inScore = 0;
		for(int i = 0; i<9; i++) {
			if(cards[i]>selectedInCard[i]) {
				gyuScore += cards[i]+selectedInCard[i];
			}else if(cards[i]<selectedInCard[i]) {
				inScore += cards[i]+selectedInCard[i];
			}
		}
		if(inScore > gyuScore) lose++;
		else if(inScore<gyuScore) win++;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			cards = new int[9];
			win = 0;
			lose = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i<9; i++) cards[i] = Integer.parseInt(st.nextToken());
			inCard = new int[9];
			selectedInCard = new int[9];
			visit = new boolean[9];
			Arrays.sort(cards);
			int idxC = 0;
			int idxMc = 0;
			for(int i = 1; i<=18; i++) {
				if(idxC < 9 && i == cards[idxC]) {
					idxC++;
					continue;
				}
				inCard[idxMc++] = i;
			}
			solve(0);
			
			System.out.println("#"+test_case+" "+win+" "+lose);
		}
	}
}