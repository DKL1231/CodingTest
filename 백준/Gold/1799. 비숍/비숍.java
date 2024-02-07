import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static int N;
	static int WhiteBishopCnt = 0;
	static int BlackBishopCnt = 0;
	static int[][] WhiteBishopList = new int[51][2];
	static int[][] BlackBishopList = new int[51][2];
	static int[][] nowBishopList = new int[51][2];
	static int WhiteAnswer = 0;
	static int BlackAnswer = 0;
	
	static void WhiteDfs(int depth, int nowBishops) {
		if(depth == WhiteBishopCnt) {
			WhiteAnswer = Math.max(WhiteAnswer, nowBishops);
			return;
		}
		
		if(WhiteAnswer-(nowBishops+WhiteBishopCnt-depth) >= 0) return;
		
		int x = WhiteBishopList[depth][0];
		int y = WhiteBishopList[depth][1];
		if(isAvail(x, y, nowBishops)) {
			nowBishopList[nowBishops] = WhiteBishopList[depth];
			WhiteDfs(depth+1, nowBishops+1);
		}
		WhiteDfs(depth+1, nowBishops);
	}
	
	static void BlackDfs(int depth, int nowBishops) {
		if(depth == BlackBishopCnt) {
			BlackAnswer = Math.max(BlackAnswer, nowBishops);
			return;
		}
		
		if(BlackAnswer-(nowBishops+BlackBishopCnt-depth) >= 0) return;
		
		int x = BlackBishopList[depth][0];
		int y = BlackBishopList[depth][1];
		if(isAvail(x, y, nowBishops)) {
			nowBishopList[nowBishops] = BlackBishopList[depth];
			BlackDfs(depth+1, nowBishops+1);
		}
		BlackDfs(depth+1, nowBishops);
	}
	
	
	static boolean isAvail(int x, int y, int nowBishops) {
		for(int i = 0; i<nowBishops; i++) {
			if(Math.abs(nowBishopList[i][0]-x)==Math.abs(nowBishopList[i][1]-y)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					if((i+j)%2 == 0) {
						WhiteBishopList[WhiteBishopCnt][0] = i;
						WhiteBishopList[WhiteBishopCnt][1] = j;
						WhiteBishopCnt++;
					}else {
						BlackBishopList[BlackBishopCnt][0] = i;
						BlackBishopList[BlackBishopCnt][1] = j;
						BlackBishopCnt++;
					}
					
				}
			}
		}
		WhiteDfs(0, 0);
		BlackDfs(0, 0);
		System.out.println(WhiteAnswer+BlackAnswer);;
	}
}